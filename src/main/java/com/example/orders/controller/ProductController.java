package com.example.orders.controller;

import com.example.orders.dto.ProductDto;
import com.example.orders.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/findall")
    public List<ProductDto> getAllProducts(){
        return productService.getAllProducts();
    }//POSTMAN

    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }//POSTMAN

    @PostMapping("/insert")
    public ProductDto saveProduct (@RequestBody @Valid ProductDto productDto){
        return productService.saveProduct(productDto);
    }//POSTMAN

    @DeleteMapping("/delete/{id}")
    public ProductDto deleteProduct(@PathVariable Long id){
        return productService.deleteProduct(id);
    }//POSTMAN

    @PutMapping("/update")
    public ProductDto updateProduct (@RequestBody @Valid ProductDto productDto){
        return productService.updateProduct(productDto);
    }//POSTMAN
}
