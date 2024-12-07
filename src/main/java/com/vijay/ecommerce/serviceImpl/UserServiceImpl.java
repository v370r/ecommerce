package com.vijay.ecommerce.serviceImpl;

import com.vijay.ecommerce.dto.UserRegistrationRequest;
import com.vijay.ecommerce.dto.UserResponse;
import com.vijay.ecommerce.events.UserRegisteredEvent;
import com.vijay.ecommerce.model.User;
import com.vijay.ecommerce.repositories.UserRepository;
import com.vijay.ecommerce.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;



@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserRepository userRepository;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, KafkaTemplate<String, Object> kafkaTemplate) {
        this.userRepository = userRepository;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public UserResponse registerUser(UserRegistrationRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        User savedUser = userRepository.save(user);
        kafkaTemplate.send("user-registered", new UserRegisteredEvent(savedUser.getId(), savedUser.getEmail()));
        logger.info(
                "Published UserRegisteredEvent for userId: " + savedUser.getId() + ", email: " + savedUser.getEmail());
        return new UserResponse(savedUser.getId(), savedUser.getUsername(), savedUser.getEmail());
    }
}
