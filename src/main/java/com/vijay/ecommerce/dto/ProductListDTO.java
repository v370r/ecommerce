package com.vijay.ecommerce.dto;

@Data
@AllArgsConstructor
public class ProductListDTO {
    private Long id;
    @NotBlank(message = "Name is required")
    private String name;
    @NotBlank(message = "Description is required")
    private String description;
    @Positive(message = "Price must be positive")
    private BigDecimal price;
    @PositiveOrZero(message = "Qunatity must be positive or zero")
    private Integer quantity;
    private String image;
}