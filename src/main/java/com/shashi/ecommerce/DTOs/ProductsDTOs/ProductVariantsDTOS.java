package com.shashi.ecommerce.DTOs.ProductsDTOs;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class ProductVariantsDTOS {
    public record AddProductVariantsRequestDTO(

            @NotBlank
            String color,

            @Min(value = 2)
            Integer stock,

            @Min(value = 3)
            Double size,

            Double extraPrice
    ){}
    public record AddProductVariantsResponseDTO(

            Long id,

            String color,

            Double size,

            Double extraPrice
    ) {}
    public record ProductVariantDTO(
            Long id,

            String color,

            Double size,

            Double price,

            Double extraPrice
    ) {}
}
