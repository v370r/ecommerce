package com.vijay.ecommerce.listeners;

import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;
import com.vijay.ecommerce.events.UserRegisteredEvent;
import com.vijay.ecommerce.service.OTPService;

@Component
public class UserRegisteredEventListener {

    private final OTPService otpService;
    private static final Logger logger = LoggerFactory.getLogger(UserRegisteredEventListener.class);
    public UserRegisteredEventListener(OTPService otpService) {
        this.otpService = otpService;
    }

    @KafkaListener(topics = "user-registered", groupId = "group_id", containerFactory = "kafkaListenerContainerFactory")
    public void handleUserRegisteredEvent(UserRegisteredEvent event, Acknowledgment acknowledgment) {
        logger.info(
                "Received UserRegisteredEvent for userId: " + event.getUserId() + ", email: " + event.getEmail());

        int otp = new Random().nextInt(900000) + 100000;
        logger.info("Generated OTP " + otp + " for user " + event.getEmail());
        otpService.generateOtp(event.getUserId(), otp);
        acknowledgment.acknowledge();
        logger.info("Message acknowledged successfully.");
    }
}