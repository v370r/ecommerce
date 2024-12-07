package com.vijay.ecommerce.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.kafka.test.utils.KafkaTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.vijay.ecommerce.dto.UserRegistrationRequest;
import com.vijay.ecommerce.dto.UserResponse;
import com.vijay.ecommerce.model.User;
import com.vijay.ecommerce.repositories.UserRepository;

@SpringBootTest
@EmbeddedKafka(partitions = 1, topics = { "user-registered" })
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class UserServiceImplIntegrationTest {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @BeforeEach
    public void setUp() {
        userRepository.deleteAll();
    }

    @Test
    public void testRegisterUser() {
        UserRegistrationRequest request = new UserRegistrationRequest();
        request.setUsername("john_doe");
        request.setEmail("john.doe@example.com");
        request.setPassword("password123");

        UserResponse response = userService.registerUser(request);

        assertNotNull(response);
        assertEquals("john_doe", response.getUsername());
        assertEquals("john.doe@example.com", response.getEmail());

        User savedUser = userRepository.findById(response.getId()).orElse(null);
        assertNotNull(savedUser);
        assertEquals("john_doe", savedUser.getUsername());
        assertEquals("john.doe@example.com", savedUser.getEmail());
    }
}