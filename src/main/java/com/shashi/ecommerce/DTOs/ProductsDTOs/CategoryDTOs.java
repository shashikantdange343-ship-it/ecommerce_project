package com.shashi.ecommerce.DTOs.ProductsDTOs;

import jakarta.validation.constraints.NotBlank;

public class CategoryDTOs {
    public record AddProductCategoryRequestDTO(

            @NotBlank
            String categoryName,

            @NotBlank
            String description
    ){}
}
