package com.example.orders.controller;

import com.example.orders.dto.ClientDto;
import com.example.orders.service.ClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @GetMapping("/findall")
    public List<ClientDto> getAllClients(){
        return clientService.getAllClients();
    }//POSTMAN

    @GetMapping("/{id}")
    public ClientDto getClientById(@PathVariable Long id){
        return clientService.getClientById(id);
    }//POSTMAN

    @PostMapping("/insert")
    public ClientDto saveClient (@RequestBody @Valid ClientDto clientDto){
        return clientService.saveClient(clientDto);
    }//POSTMAN

    @DeleteMapping("/delete/{id}")
    public ClientDto deleteClient(@PathVariable Long id){
        return clientService.deleteClient(id);
    }//POSTMAN

    @PutMapping("/update")
    public ClientDto updateClient (@RequestBody @Valid ClientDto clientDto){
        return clientService.updateClient(clientDto);
    }//POSTMAN
}
