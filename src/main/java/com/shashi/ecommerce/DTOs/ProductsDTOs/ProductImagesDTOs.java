package com.shashi.ecommerce.DTOs.ProductsDTOs;

import jakarta.validation.constraints.NotBlank;

public class ProductImagesDTOs {
    public record AddProductImagesRequestDTO(

            @NotBlank
            String imageUrl,

            @NotBlank
            Boolean isPrimaryImage
    ){}
    public record AddImagesResponseDTO(
            String imageUrl
    ){}
}
