package com.example.orders.mappers;

import org.mapstruct.Mapper;

import com.example.orders.dto.BillDto;
import com.example.orders.entity.Bill;

@Mapper(componentModel = "spring"/*,uses = {PedidosMapper.class, ProductMapper.class}*/)
public interface BillMapper {

    //@Mapping(target = "prods", ignore = true)//para ignorar un campo especifico en el mapeo
    BillDto toDto(Bill bill);
    Bill toEntity(BillDto billDto);

}
