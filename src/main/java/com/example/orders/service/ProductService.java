package com.example.orders.service;

import com.example.orders.dto.ProductDto;
import com.example.orders.mappers.ProductMapper;
import com.example.orders.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public List<ProductDto> getAllProducts(){
        return productRepository.findAll().stream().map(productMapper::toDto).toList();
    }//DONE

    public ProductDto getProductById(String id){
        return productMapper.toDto(productRepository.findById(id).orElse(null));
    }//DONE

    public ProductDto saveProduct (ProductDto productDto){
        return productMapper.toDto(productRepository.saveAndFlush(productMapper.toEntity(productDto)));
    }//DONE

    public ProductDto deleteProduct(String id){
        ProductDto prodDto = getProductById(id);
        productRepository.deleteById(id);
        return  prodDto;
    }//DONE

    public boolean existsById(String id){
        return productRepository.existsById(id);
    }

    public ProductDto updateProduct (ProductDto productDto){
        return productMapper.toDto(productRepository.saveAndFlush(productMapper.toEntity(productDto)));
    }//DONE
}
