package com.vijay.ecommerce.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class OTPService {

    private final Map<Long, Integer> otpStore = new HashMap<>();

    public void generateOtp(Long userId, int otp) {
        otpStore.put(userId, otp);
    }

    public boolean verifyOtp(Long userId, int otp) {
        Integer storedOtp = otpStore.get(userId);
        if (storedOtp != null && storedOtp == otp) {
            otpStore.remove(userId);
            return true;
        }
        return false;
    }
}
