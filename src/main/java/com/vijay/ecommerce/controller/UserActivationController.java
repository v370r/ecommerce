package com.vijay.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vijay.ecommerce.service.OTPService;

@RestController
@RequestMapping("/api/users")
public class UserActivationController {

    private final OTPService otpService;

    @Autowired
    public UserActivationController(OTPService otpService) {
        this.otpService = otpService;
    }

    @PostMapping("/activate")
    public ResponseEntity<String> activateUser(@RequestParam Long userId, @RequestParam int otp) {
        boolean isVerified = otpService.verifyOtp(userId, otp);
        if (isVerified) {
            return ResponseEntity.ok("Account activated successfully!");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid OTP.");
        }
    }
}
