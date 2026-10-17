package com.shashi.ecommerce.Services.ProductServices;

import com.shashi.ecommerce.Entity.ProductsEntity.Inventory;
import com.shashi.ecommerce.Entity.ProductsEntity.ProductVariant;

public interface InventoryService {

     Inventory addToInventory(ProductVariant productVariant);

     Inventory getInventory(long variantId);

     Inventory saveInventory(Inventory inventory);
}
