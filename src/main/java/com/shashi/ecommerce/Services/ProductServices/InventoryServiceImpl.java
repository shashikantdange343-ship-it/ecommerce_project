package com.shashi.ecommerce.Services.ProductServices;

import com.shashi.ecommerce.Entity.ProductsEntity.Inventory;
import com.shashi.ecommerce.Entity.ProductsEntity.ProductVariant;
import com.shashi.ecommerce.Exceptons.ResourceNotFoundException;
import com.shashi.ecommerce.Repository.ProductRepositories.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService{

    private final InventoryRepository inventoryRepository;

    public Inventory addToInventory(ProductVariant productVariant){
        Inventory newInventory = new Inventory();
        newInventory.setAvailableQuantity(productVariant.getStockKeepingUnit());
        newInventory.setLowStockThreshold(10);
        newInventory.setProductVariant(productVariant);
        newInventory.setWarehouse_id(1);
        return newInventory;
    }

    @Override
    public Inventory getInventory(long variantId) {
        Optional<Inventory> optionalInventory = inventoryRepository.findByProductVariantId(variantId);

        if (optionalInventory.isEmpty()){
            throw new ResourceNotFoundException("Variant Not Found !");
        }
        return optionalInventory.get();

    }

    @Override
    public Inventory saveInventory(Inventory inventory) {

        return inventoryRepository.save(inventory);

    }

}
