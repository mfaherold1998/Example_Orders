package com.example.orders.controller;

import com.example.orders.dto.ClientDto;
import com.example.orders.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/findall")
    public List<ClientDto> getAllClients(){
        return clientService.getAllClients();
    }//DONE

    @GetMapping("/getclient/{id}")
    public ClientDto getClientById(@RequestBody Long id){
        return clientService.getClientById(id);
    }//DONE

    @PostMapping("/insert")
    public ClientDto saveClient (@RequestBody @Valid ClientDto clientDto){
        return clientService.saveClient(clientDto);
    }//DONE

    @DeleteMapping("/delete/{id}")
    public ClientDto deleteClient(@PathVariable Long id){
        return clientService.deleteClient(id);
    }//DONE

    @PutMapping("/update/{id}")
    public ClientDto updateClient (@RequestBody @Valid ClientDto clientDto){
        return clientService.updateClient(clientDto);
    }//DONE
}
