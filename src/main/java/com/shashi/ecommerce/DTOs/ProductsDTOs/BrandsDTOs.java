package com.shashi.ecommerce.DTOs.ProductsDTOs;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class BrandsDTOs {
    public record AddProductBrandRequestDTO(

            @NotBlank
            String name ,

            @NotBlank
            String logoUrl ,

            @Email (message = "EMAIL BLANK ! OR WRONG EMAIL FORMAT !")
            String contactEmail
    ){}
}
