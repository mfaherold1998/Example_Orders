package com.example.orders.mappers;

import com.example.orders.dto.PedidosDto;
import com.example.orders.dto.ProductDto;
import com.example.orders.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",uses = {PedidosMapper.class, BillMapper.class})
public interface ProductMapper {

    ProductDto toDto(Product product);
    Product toEntity(ProductDto productDto);
}
