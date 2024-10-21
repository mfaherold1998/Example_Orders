package com.example.orders.controller;

import com.example.orders.dto.OrdineDto;
import com.example.orders.service.OrdineService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Ordine", description = "the Ordine Api")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class OrdineController implements OrdineApi{

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
    public ResponseEntity<OrdineDto> saveOrdine(@RequestBody @Valid OrdineDto ordineDto){
        return new ResponseEntity<>(ordineService.saveOrdine(ordineDto), HttpStatus.CREATED);
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
