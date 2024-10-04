package com.example.orders.controller;

import com.example.orders.dto.OrdineDto;
import com.example.orders.service.OrdineService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ordini")
@RequiredArgsConstructor
public class OrdineController {

    private final OrdineService ordineService;

    @GetMapping("/findall")
    public List<OrdineDto> getAllOrdini(){
        return ordineService.getAllOrdini();
    }//POSTMAN

    @GetMapping("/{id}")
    public OrdineDto getOrdineById(@PathVariable Long id){
        return ordineService.getOrdineById(id);
    }//POSTMAN

    @PostMapping("/insert")
    public OrdineDto saveBill(@RequestBody @Valid OrdineDto ordineDto){
        return ordineService.saveOrdine(ordineDto);
    }//POSTMAN

    @DeleteMapping("/delete/{id}")
    public OrdineDto deleteOrdine(@PathVariable Long id){
        return ordineService.deleteOrdine(id);
    }//POSTMAN

    @PutMapping("/update")
    public OrdineDto updateOrdine (@RequestBody @Valid OrdineDto ordineDto){
        return ordineService.updateOrdine(ordineDto);
    }//POSTMAN

}
