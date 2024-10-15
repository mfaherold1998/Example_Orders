package com.example.orders.controller;

import com.example.orders.dto.ClientDto;
import com.example.orders.service.ClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @GetMapping("/clients")
    public ResponseEntity<List<ClientDto>> getAllClients(){
        return ResponseEntity.ok(clientService.getAllClients());
    }//POSTMAN

    @GetMapping("/clients/{id}")
    public ResponseEntity<ClientDto> getClientById(@PathVariable Long id){
        return ResponseEntity.ok(clientService.getClientById(id));
    }//POSTMAN

    @PostMapping("/clients")
    public ResponseEntity<ClientDto> saveClient (@RequestBody @Valid ClientDto clientDto){
        return ResponseEntity.ok(clientService.saveClient(clientDto));
    }//POSTMAN

    @DeleteMapping("/clients/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id){
        clientService.deleteClient(id);
        return ResponseEntity.accepted().build();
    }//POSTMAN

    @PutMapping("/clients")
    public ResponseEntity<ClientDto> updateClient (@RequestBody @Valid ClientDto clientDto){
        return ResponseEntity.ok(clientService.updateClient(clientDto));
    }//POSTMAN
}
