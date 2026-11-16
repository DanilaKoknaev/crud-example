package com.example.demo.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductRequest(
        @NotBlank(message = "Name must not be blank")
        String name,

        String description,

        @NotNull(message = "Price must not be null")
        @DecimalMin(value = "0.0", message = "Price must not be negative")
        BigDecimal price
) {
}
