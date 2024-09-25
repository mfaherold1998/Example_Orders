package com.example.orders.mappers;

import com.example.orders.dto.PedidosDto;
import com.example.orders.entity.Pedidos;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",uses = {BillMapper.class, ClientMapper.class, ProductMapper.class})
public interface PedidosMapper {

    PedidosDto toDto(Pedidos pedidos);
    Pedidos toEntity(PedidosDto pedidosDto);
}
