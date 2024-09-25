package com.example.orders.mappers;

import com.example.orders.dto.BillDto;
import com.example.orders.entity.Bill;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",uses = {PedidosMapper.class, ProductMapper.class})
public interface BillMapper {

    BillDto toDto(Bill bill);
    Bill toEntity(BillDto billDto);

}
