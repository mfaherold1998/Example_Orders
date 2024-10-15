package com.example.orders.controller;

import com.example.orders.dto.OrdineDto;
import com.example.orders.service.OrdineService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class OrdineController {

    private final OrdineService ordineService;

    @GetMapping("/ordini")
    public ResponseEntity<List<OrdineDto>> getAllOrdini(){
        return ResponseEntity.ok(ordineService.getAllOrdini());
    }//POSTMAN

    @GetMapping("/ordini/{id}")
    public ResponseEntity<OrdineDto> getOrdineById(@PathVariable Long id){
        return ResponseEntity.ok(ordineService.getOrdineById(id));
    }//POSTMAN

    @PostMapping("/ordini")
    public ResponseEntity<OrdineDto> saveBill(@RequestBody @Valid OrdineDto ordineDto){
        return ResponseEntity.ok(ordineService.saveOrdine(ordineDto));
    }//POSTMAN

    @DeleteMapping("/ordini/{id}")
    public ResponseEntity<Void> deleteOrdine(@PathVariable Long id){
        ordineService.deleteOrdine(id);
        return ResponseEntity.accepted().build();
    }//POSTMAN

    @PutMapping("/ordini")
    public ResponseEntity<OrdineDto> updateOrdine (@RequestBody @Valid OrdineDto ordineDto){
        return ResponseEntity.ok(ordineService.updateOrdine(ordineDto));
    }//POSTMAN

}
