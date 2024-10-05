package com.vijay.ecommerce.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class OrderItemDTO {

    private Long id;
    private Long productId;
    @Positive(message = "Quantity must be greater than zero")
    private Integer quantity;
    @Positive(message = "Price must be greater than zero")
    private BigDecimal price;

}
