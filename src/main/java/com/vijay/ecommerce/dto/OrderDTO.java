package com.vijay.ecommerce.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.vijay.ecommerce.model.Order;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class OrderDTO {

    private Long id;
    private Long userId;

    @NotBlank(message = "Address is required")
    private String address;
    @NotBlank(message = "Phone number is required")
    private String phoneNumber;
    private Order.OrderStatus status;
    private LocalDateTime createdAt;
    private List<OrderItemDTO> orderItems;
}
