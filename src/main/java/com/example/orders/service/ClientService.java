package com.example.orders.service;

import com.example.orders.dto.ClientDto;
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

    public void deleteClient(Long id){
        if(clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
        }
        else{
            throw new NotFoundException("Not Found Exception","Client with id "+id+" does not exists, you cannot delete it");
        }
    }

    public boolean existsById(Long id){
        return clientRepository.existsById(id);
    }

    public ClientDto updateClient (ClientDto clientDto){
        if(clientRepository.existsById(clientDto.getId())){
            return clientMapper.toDto(clientRepository.saveAndFlush(clientMapper.toEntity(clientDto)));
        }
        else{
            throw new NotFoundException("Not Found Exception","Client with id "+clientDto.getId()+" does not exists, you cannot update it");
        }
    }
}
