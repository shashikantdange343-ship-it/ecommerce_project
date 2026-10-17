package com.shashi.ecommerce.Services.ProductServices;

import com.shashi.ecommerce.Entity.ProductsEntity.Brands;
import com.shashi.ecommerce.Exceptons.ResourceNotFoundException;
import com.shashi.ecommerce.Repository.ProductRepositories.BrandsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BrandServicesImpl implements BrandService{

    private final BrandsRepository brandsRepository;

    @Override
    public Brands getBrands(long brandId) {

        Optional<Brands> optionalBrands = brandsRepository.findById(brandId);

        if (optionalBrands.isEmpty()){
            throw new ResourceNotFoundException("Brand is Not Found !");
        }

        return optionalBrands.get();
    }
}
