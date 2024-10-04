package com.example.orders.mappers;

import com.example.orders.dto.OrdineDto;
import com.example.orders.entity.Ordine;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrdineMapper {
    OrdineDto toDto(Ordine ordine);
    Ordine toEntity(OrdineDto ordineDto);
}
