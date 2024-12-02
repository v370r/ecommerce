package com.vijay.ecommerce.service;

import com.vijay.ecommerce.dto.UserRegistrationRequest;
import com.vijay.ecommerce.dto.UserResponse;

public interface UserService {
    UserResponse registerUser(UserRegistrationRequest request);
}