package com.example.orders.controller;

import com.example.orders.dto.ProductDto;
import com.example.orders.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<ProductDto>> getAllProducts(){
        return ResponseEntity.ok(productService.getAllProducts());
    }//POSTMAN

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long id){
        return ResponseEntity.ok(productService.getProductById(id));
    }//POSTMAN

    @PostMapping("/products")
    public ResponseEntity<ProductDto> saveProduct (@RequestBody @Valid ProductDto productDto){
        return ResponseEntity.ok(productService.saveProduct(productDto));
    }//POSTMAN

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
        return ResponseEntity.accepted().build();
    }//POSTMAN

    @PutMapping("/products")
    public ResponseEntity<ProductDto> updateProduct (@RequestBody @Valid ProductDto productDto){
        return ResponseEntity.ok(productService.updateProduct(productDto));
    }//POSTMAN
}
