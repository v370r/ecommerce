package com.vijay.ecommerce.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CommentDTO {

    private Long id;

    @NotBlank(message = "Comment content is required")
    private String content;

    @Min(value = 1, message = "Score must be greater than zero")
    @Max(value = 5, message = "Score must be less than or equal to 5")
    private Integer score;
    private Long userId;

}
