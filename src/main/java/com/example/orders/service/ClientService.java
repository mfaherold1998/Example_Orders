package com.example.orders.service;

import com.example.orders.entity.Client;
import com.example.orders.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAllClients(){
        return clientRepository.findAll();
    }

    public Client getClientById(String id){
        return clientRepository.findById(id).orElse(null);
    }

    public void saveClient (Client client){
        clientRepository.save(client);
    }

    public void deleteClient(String id){
        clientRepository.deleteById(id);
    }

    public boolean existsById(String id){
        return clientRepository.existsById(id);
    }
}
