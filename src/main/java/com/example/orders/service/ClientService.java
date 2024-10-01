package com.example.orders.service;

import com.example.orders.dto.ClientDto;
import com.example.orders.exceptions.InvalidException;
import com.example.orders.mappers.ClientMapper;
import com.example.orders.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public List<ClientDto> getAllClients(){
        return clientRepository.findAll().stream().map(clientMapper::toDto).toList();
    }//TODO Conexion a la base de datos

    public ClientDto getClientById(Long id){
        if (id <= 0) {
            throw new InvalidException("Invalid Client Exception","Invalid client ID: " + id);
        }
        return clientMapper.toDto(clientRepository.findById(id).orElse(null));
    }//TODO Que el id existe, que no es null (notfoundexception)

    public ClientDto saveClient (ClientDto clientDto){
        if (clientDto.getName() == null || clientDto.getEmail() == null) {
            throw new InvalidException("Invalid Client Exception","User name and email are required");
        }
        return clientMapper.toDto(clientRepository.saveAndFlush(clientMapper.toEntity(clientDto)));
    }//TODO

    public ClientDto deleteClient(Long id){
        ClientDto clientDto = getClientById(id);
        clientRepository.deleteById(id);
        return clientDto;
    }//TODO que exista el id

    public boolean existsById(Long id){
        return clientRepository.existsById(id);
    }
    //TODO conexion a la base de datos

    public ClientDto updateClient (ClientDto clientDto){
        return clientMapper.toDto(clientRepository.saveAndFlush(clientMapper.toEntity(clientDto)));
    }//TODO que el id exista y sea valido
}
