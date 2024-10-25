package com.example.orders.mappers;

import com.example.orders.dto.BillDto;
import com.example.orders.entity.Bill;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BillMapper {

    BillDto toDto(Bill bill);
    Bill toEntity(BillDto billDto);

}
