package com.example.orders.controller;

import com.example.orders.dto.ProductDto;
import com.example.orders.service.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Product", description = "the Product Api")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProductController implements ProductApi{

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
        return new ResponseEntity<>(productService.saveProduct(productDto), HttpStatus.CREATED);
    }//POSTMAN

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return ResponseEntity.accepted().build();
    }//POSTMAN

    @PutMapping("/products")
    public ResponseEntity<ProductDto> updateProduct (@RequestBody @Valid ProductDto productDto){
        return ResponseEntity.ok(productService.updateProduct(productDto));
    }//POSTMAN
}
