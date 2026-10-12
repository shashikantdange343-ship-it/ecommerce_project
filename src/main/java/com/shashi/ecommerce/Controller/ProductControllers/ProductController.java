package com.shashi.ecommerce.Controller.ProductControllers;

import com.shashi.ecommerce.DTOs.ProductsDTOs.ProductDTOS;
import com.shashi.ecommerce.Services.ProductServices.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
@CrossOrigin("*")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/all")
    public ResponseEntity<Page<ProductDTOS.GetAllProductDTO>> getAllProducts(@RequestParam int pageNum){
        return ResponseEntity.ok().body(productService.getProducts(pageNum));
    }

    @GetMapping("/details")
    public ResponseEntity<ProductDTOS.GetProductDetailsDTO> getProductDetails(@RequestParam long productId){
        return ResponseEntity.ok(productService.getProductDetails(productId));
    }

    @PostMapping
    public ResponseEntity<ProductDTOS.AddProductResponseDTO> AddProduct(@Valid @RequestBody ProductDTOS.AddFullProductRequestDTO request){
       return ResponseEntity.status(HttpStatus.CREATED).body(productService.addProduct(request));
    }

}
