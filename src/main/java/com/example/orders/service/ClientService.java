package com.example.orders.service;

import com.example.orders.dto.ClientDto;
import com.example.orders.exceptions.InvalidException;
import com.example.orders.exceptions.NotFoundException;
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
    }

    public ClientDto getClientById(Long id){
        return clientMapper.toDto(clientRepository.findById(id).orElseThrow(() -> new NotFoundException("Not Found Exception","Client with id "+id+" does not exists")));
    }

    public ClientDto saveClient (ClientDto clientDto){
        return clientMapper.toDto(clientRepository.saveAndFlush(clientMapper.toEntity(clientDto)));
    }

    public ClientDto deleteClient(Long id){
        ClientDto clientDto = getClientById(id);
        clientRepository.deleteById(id);
        return clientDto;
    }

    public boolean existsById(Long id){
        return clientRepository.existsById(id);
    }

    public ClientDto updateClient (ClientDto clientDto){
        return clientMapper.toDto(clientRepository.saveAndFlush(clientMapper.toEntity(clientDto)));
    }
}
