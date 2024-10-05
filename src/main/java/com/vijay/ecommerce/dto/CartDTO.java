package com.vijay.ecommerce.dto;

import java.util.List;

import lombok.Data;

@Data
public class CartDTO {

    private Long id;
    private Long userId;
    private List<CartItemDTO> items;
}
