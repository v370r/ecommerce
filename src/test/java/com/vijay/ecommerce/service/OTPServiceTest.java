package com.vijay.ecommerce.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OTPServiceTest {

    private OTPService otpService;

    @BeforeEach
    public void setUp() {
        otpService = new OTPService();
    }

    @Test
    public void testGenerateOtp() {
        Long userId = 1L;
        int otp = 123456;

        otpService.generateOtp(userId, otp);

        assertTrue(otpService.verifyOtp(userId, otp), "OTP should be verified successfully");
    }

    @Test
    public void testVerifyOtp_Success() {
        Long userId = 1L;
        int otp = 123456;

        otpService.generateOtp(userId, otp);

        boolean isVerified = otpService.verifyOtp(userId, otp);

        assertTrue(isVerified);
    }

    @Test
    public void testVerifyOtp_Failure() {
        Long userId = 1L;
        int otp = 123456;
        int wrongOtp = 654321;

        otpService.generateOtp(userId, otp);

        boolean isVerified = otpService.verifyOtp(userId, wrongOtp);

        assertFalse(isVerified);
    }

    @Test
    public void testRemoveOTPOnceVerified() {
        Long userId = 1L;
        int otp = 123456;

        otpService.generateOtp(userId, otp);

        boolean isVerifiedFirstTime = otpService.verifyOtp(userId, otp);
        assertTrue(isVerifiedFirstTime, "OTP should be verified successfully the first time");

        boolean isVerifiedSecondTime = otpService.verifyOtp(userId, otp);
        assertFalse(isVerifiedSecondTime, "OTP should not be verified successfully the second time");
    }
}