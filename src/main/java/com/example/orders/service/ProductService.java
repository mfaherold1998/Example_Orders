package com.example.orders.service;

import com.example.orders.dto.ProductDto;
import com.example.orders.exceptions.NotFoundException;
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
    }

    public ProductDto getProductById(Long id){
        return productMapper.toDto(productRepository.findById(id).orElseThrow(() -> new NotFoundException("Not Found Exception","Product with id "+id+" does not exists")));
    }

    public ProductDto saveProduct (ProductDto productDto){
        return productMapper.toDto(productRepository.saveAndFlush(productMapper.toEntity(productDto)));
    }

    public void deleteProduct(Long id){
        if(productRepository.existsById(id)) {
            productRepository.deleteById(id);
        }
        else{
            throw new NotFoundException("Not Found Exception","Product with id "+id+" does not exists, you cannot delete it");
        }
    }

    public boolean existsById(Long id){
        return productRepository.existsById(id);
    }

    public ProductDto updateProduct (ProductDto productDto){
        if(productRepository.existsById(productDto.getId())){
            return productMapper.toDto(productRepository.saveAndFlush(productMapper.toEntity(productDto)));
        }
        else{
            throw new NotFoundException("Not Found Exception","Product with id "+productDto.getId()+" does not exists, you cannot update it");
        }
    }
}
