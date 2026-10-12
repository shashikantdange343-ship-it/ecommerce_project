package com.shashi.ecommerce.Security.UserSecurity; // Apna package name match kar lena

import com.shashi.ecommerce.Entity.ProductsEntity.Brands;
import com.shashi.ecommerce.Entity.ProductsEntity.Categories;
import com.shashi.ecommerce.Repository.ProductRepositories.BrandsRepository;
import com.shashi.ecommerce.Repository.ProductRepositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataInitializer2 implements CommandLineRunner {

    private final BrandsRepository brandsRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {

        // 1. Check karo ki kya database me pehle se Brands hain? (Taaki baar baar duplicate na bane)
        if (brandsRepository.count() == 0) {

            Brands nike = new Brands();
            nike.setBrandName("Nike");
            nike.setContactEmail("support@nike.com");
            nike.setLogoUrl("https://upload.wikimedia.org/wikipedia/commons/a/a6/Logo_NIKE.svg");

            Brands puma = new Brands();
            puma.setBrandName("Puma");
            puma.setContactEmail("support@puma.com");
            puma.setLogoUrl("https://upload.wikimedia.org/wikipedia/commons/8/88/Puma_Logo.png");

            Brands adidas = new Brands();
            adidas.setBrandName("Adidas");
            adidas.setContactEmail("support@adidas.com");
            adidas.setLogoUrl("https://upload.wikimedia.org/wikipedia/commons/2/20/Adidas_Logo.png");

            // Ek sath teeno ko database me save kar diya
            brandsRepository.saveAll(List.of(nike, puma, adidas));
            System.out.println("✅ Brands Data Initialized!");
        }

        // 2. Check karo ki kya Categories khali hain?
        if (categoryRepository.count() == 0) {

            Categories mensClothing = new Categories();
            mensClothing.setName("Men's Clothing");
            mensClothing.setDescription("All types of apparel for men.");
            mensClothing.setParentCategoryId(0); // 0 matlab ye Main category hai

            Categories shoes = new Categories();
            shoes.setName("Shoes");
            shoes.setDescription("Footwear for all occasions.");
            shoes.setParentCategoryId(0);

            // Ek sath dono ko save kar diya
            categoryRepository.saveAll(List.of(mensClothing, shoes));
            System.out.println("✅ Categories Data Initialized!");
        }
    }
}