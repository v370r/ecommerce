package com.vijay.ecommerce.dto;

import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class CartItemDTO {

    private Long id;
    private Long productId;

    @Positive(message = "Quantity must be greater than zero")
    private Integer quantity;
}
