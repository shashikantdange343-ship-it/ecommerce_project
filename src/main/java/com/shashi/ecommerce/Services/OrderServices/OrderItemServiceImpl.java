package com.shashi.ecommerce.Services.OrderServices;

import com.shashi.ecommerce.DTOs.OrdersDTOs.OrderItemDTOs;
import com.shashi.ecommerce.Entity.Orders.OrderItems;
import com.shashi.ecommerce.Entity.ProductsEntity.Inventory;
import com.shashi.ecommerce.Entity.ProductsEntity.ProductVariant;
import com.shashi.ecommerce.Exceptons.CustomException;
import com.shashi.ecommerce.Exceptons.ResourceNotFoundException;
import com.shashi.ecommerce.Repository.Orders.OrderItemRepository;
import com.shashi.ecommerce.Repository.ProductRepositories.InventoryRepository;
import com.shashi.ecommerce.Services.ClassConverterService;
import com.shashi.ecommerce.Services.ProductServices.InventoryService;
import com.shashi.ecommerce.Services.ProductServices.ProductVariantsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderItemServiceImpl implements OrderItemService{

    private final ProductVariantsService productVariantsService;

    private final InventoryService inventoryService;

    @Override
    public OrderItems AddOrderItems(OrderItemDTOs.OrderItemRequestDTO orderItems) {

       Inventory inventory = inventoryService.getInventory(orderItems.variantId());

       if (inventory.getAvailableQuantity() < orderItems.quantity() || inventory.getAvailableQuantity() == 0){
           throw new CustomException("Quantity Of Variant Is Out Of Stock !");
       }

       ProductVariant productVariant = productVariantsService.getProductVariant(orderItems.variantId());

       OrderItems orderItems1 = new OrderItems();

       orderItems1.setProductVariant(productVariant);
       orderItems1.setPriceAtThatTime(productVariant.getProducts().getBasePrice() + productVariant.getExtraPrice());
       orderItems1.setQuantity(orderItems.quantity());
       inventory.setAvailableQuantity(inventory.getAvailableQuantity() - orderItems.quantity());
       productVariant.setStockKeepingUnit(productVariant.getStockKeepingUnit() - orderItems.quantity());
       inventoryService.saveInventory(inventory);

        return orderItems1;
    }
}
