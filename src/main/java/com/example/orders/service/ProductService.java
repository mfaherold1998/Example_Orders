package com.example.orders.service;

import com.example.orders.entity.Product;
import com.example.orders.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product getProductById(String id){
        return productRepository.findById(id).orElse(null);
    }

    public void saveProduct (Product product){
        productRepository.save(product);
    }

    public void deleteProduct(String id){
        productRepository.deleteById(id);
    }

    public boolean existsById(String id){
        return productRepository.existsById(id);
    }

    public void updateProduct (Product product){
        productRepository.save(product);
    }
}
