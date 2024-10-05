package com.vijay.ecommerce.dto;

import java.math.BigDecimal;
import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
public class ProductDTO {

    private Long id;

    @NotBlank(message = "Product name is required")
    private String name;

    @NotBlank(message = "Product description is required")
    private String description;

    @Positive(message = "Price must be greater than zero")
    private BigDecimal price;

    @PositiveOrZero(message = "Quantity must be zero or greater")
    private Integer quantity;
    private String image;
    private List<CommentDTO> comments;
}
