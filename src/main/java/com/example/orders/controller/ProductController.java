package com.example.orders.controller;

import com.example.orders.dto.ProductDto;
import com.example.orders.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/findall")
    public List<ProductDto> getAllProducts(){
        return productService.getAllProducts();
    }//DONE

    @GetMapping("/getproduct/{id}")
    public ProductDto getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }//DONE

    @PostMapping("/insert")
    public ProductDto saveProduct (@RequestBody @Valid ProductDto productDto){
        return productService.saveProduct(productDto);
    }//DONE

    @DeleteMapping("/delete/{id}")
    public ProductDto deleteProduct(@PathVariable Long id){
        return productService.deleteProduct(id);
    }//DONE

    @PutMapping("/update/{id}")
    public ProductDto updateProduct (@RequestBody @Valid ProductDto productDto){
        return productService.updateProduct(productDto);
    }//DONE
}
