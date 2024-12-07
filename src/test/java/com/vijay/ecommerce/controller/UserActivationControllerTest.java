package com.vijay.ecommerce.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.vijay.ecommerce.service.OTPService;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserActivationControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private OTPService otpService;

    @BeforeEach
    public void setUp() {
        otpService.generateOtp(1L, 123456);
    }

    @Test
    public void testActivateUser_Success() {
        ResponseEntity<String> response = restTemplate.postForEntity("/api/users/activate?userId=1&otp=123456", null,
                String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Account activated successfully!", response.getBody());
    }

    @Test
    public void testActivateUser_InvalidOtp() {
        ResponseEntity<String> response = restTemplate.postForEntity("/api/users/activate?userId=1&otp=654321", null,
                String.class);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Invalid OTP.", response.getBody());
    }
}
