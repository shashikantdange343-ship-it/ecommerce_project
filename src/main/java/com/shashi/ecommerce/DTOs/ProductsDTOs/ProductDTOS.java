package com.shashi.ecommerce.DTOs.ProductsDTOs;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class ProductDTOS {
    public record AddFullProductRequestDTO(

            AddProductRequestDTO productRequest,

            Long categoryId,

            List<ProductImagesDTOs.AddProductImagesRequestDTO> imagesRequest,

            List<ProductVariantsDTOS.AddProductVariantsRequestDTO> variantsRequest
    ){}
    public record AddProductResponseDTO(String message){}

    public record GetAllProductDTO(

            Long id,

            String productName,

            String bradName,

            Double basePrice,

            String baseDescription,

            String primaryProductImageUrl
    ){}
    public record GetProductDetailsDTO(

            GetAllProductDTO Product,

            List<ProductVariantsDTOS.AddProductVariantsResponseDTO> variants,

            List<ProductImagesDTOs.AddImagesResponseDTO> images

    ){}

    public record AddProductRequestDTO(

            @NotBlank
            String productName ,

            @Min(value = 10)
            Double basePrice ,

            @NotBlank
            String baseDescription,

            Long brandId
    ){}
}
