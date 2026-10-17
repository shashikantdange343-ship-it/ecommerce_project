package com.shashi.ecommerce.Services.ProductServices;

import com.shashi.ecommerce.Entity.ProductsEntity.Categories;
import com.shashi.ecommerce.Exceptons.ResourceNotFoundException;
import com.shashi.ecommerce.Repository.ProductRepositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;

    @Override
    public Categories getCategory(long categoryId) {

        Optional<Categories> optionalCategories = categoryRepository.findById(categoryId);

        if (optionalCategories.isEmpty()){

            throw new ResourceNotFoundException(" Category is Not Found !");

        }
        return optionalCategories.get();
    }
}
