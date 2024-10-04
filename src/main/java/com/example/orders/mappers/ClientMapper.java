package com.example.orders.mappers;

import com.example.orders.dto.ClientDto;
import com.example.orders.entity.Client;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    ClientDto toDto(Client client);
    Client toEntity(ClientDto clientDto);
}
