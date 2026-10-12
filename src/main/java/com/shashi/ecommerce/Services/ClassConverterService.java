package com.shashi.ecommerce.Services;

import com.shashi.ecommerce.DTOs.CartDTOs.CartDTOS;
import com.shashi.ecommerce.DTOs.ProductsDTOs.*;
import com.shashi.ecommerce.Entity.Cart.CartItems;
import com.shashi.ecommerce.Entity.ProductsEntity.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassConverterService {

     public ProductDTOS.GetAllProductDTO toProductDTO(Products product){
        return new ProductDTOS.GetAllProductDTO(product.getId(),
                 product.getProductName(),product.getBrands().getBrandName(),product.getBasePrice(),product.getBaseDescription()
                 ,product.getProductImages().stream()
                .filter(i -> Boolean.TRUE.equals(i.getIsPrimaryImage())).findFirst()
                .map(ProductImages::getImageUrl).orElse("Image Not Available !"));
     }

    public Products toProduct(ProductDTOS.AddProductRequestDTO product){
         Products newProduct = new Products();
         newProduct.setProductName(product.productName());
         newProduct.setBasePrice(product.basePrice());
         newProduct.setBaseDescription(product.baseDescription());
        return newProduct;
    }

     public Brands toProductBrand(BrandsDTOs.AddProductBrandRequestDTO request){
         Brands brand = new Brands();
         brand.setBrandName(request.name());
         brand.setLogoUrl(request.logoUrl());
         brand.setContactEmail(request.contactEmail());
         return brand;
     }

    public Categories toProductCategory(CategoryDTOs.AddProductCategoryRequestDTO request){
        Categories category = new Categories();
        category.setDescription(request.description());
        category.setName(request.categoryName());
        category.setParentCategoryId(1);
        return category;
    }

    public ProductImages toProductImage(ProductImagesDTOs.AddProductImagesRequestDTO request ){

        ProductImages image = new ProductImages();
        image.setImageUrl(request.imageUrl());
        image.setIsPrimaryImage(request.isPrimaryImage());
        return image;
    }

    public ProductVariant toProductVariant(ProductVariantsDTOS.AddProductVariantsRequestDTO request){
        ProductVariant variant = new ProductVariant();
        variant.setColor(request.color());
        variant.setExtraPrice(request.extraPrice());
        variant.setSize(request.size());
        variant.setStockKeepingUnit(request.stock());
        return variant;
    }

    public ProductVariantsDTOS.AddProductVariantsResponseDTO toProductVariantDTO(ProductVariant request){
        ProductVariantsDTOS.AddProductVariantsResponseDTO productVariants = new ProductVariantsDTOS.AddProductVariantsResponseDTO(
                request.getId(),
                request.getColor(),
                request.getSize(),
                request.getExtraPrice()
        );
        return productVariants;
    }
    public ProductImagesDTOs.AddImagesResponseDTO toProductImagesDTO(ProductImages productImages){
         return new ProductImagesDTOs.AddImagesResponseDTO(productImages.getImageUrl());
    }


    // CART CLASS CONVERTERS


    public ProductVariantsDTOS.CartProductVariantDTO toCartProductVariantDTO(CartItems cartItems){
      return new ProductVariantsDTOS.CartProductVariantDTO(
                cartItems.getProductVariant().getId(),
                cartItems.getProductVariant().getColor(),
                cartItems.getProductVariant().getSize(),
                cartItems.getProductVariant().getExtraPrice()
        );
    }

    public CartDTOS.CartProductDTO toCartProductDTO(CartItems cartItems){
        return new CartDTOS.CartProductDTO(
                cartItems.getProductVariant().getProducts().getProductName(),
                cartItems.getProductVariant().getProducts().getBrands().getBrandName(),
                toCartProductVariantDTO(cartItems)
        );
    }

}


