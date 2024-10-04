package com.example.orders.controller;

import com.example.orders.dto.OrdineDto;
import com.example.orders.service.OrdineService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ordine")
@RequiredArgsConstructor
public class OrdineController {

    private final OrdineService ordineService;

    @GetMapping("/findall")
    public List<OrdineDto> getAllOrdini(){
        return ordineService.getAllOrdini();
    }

    @GetMapping("/getordine/{id}")
    public OrdineDto getOrdineById(@PathVariable Long id){
        return ordineService.getOrdineById(id);
    }

    @PostMapping("/insert")
    public OrdineDto saveBill(@RequestBody @Valid OrdineDto ordineDto){
        return ordineService.saveOrdine(ordineDto);
    }

    @DeleteMapping("/delete/{id}")
    public OrdineDto deleteOrdine(@PathVariable Long id){
        return ordineService.deleteOrdine(id);
    }

    @PutMapping("/update")
    public OrdineDto updateOrdine (@RequestBody @Valid OrdineDto ordineDto){
        return ordineService.updateOrdine(ordineDto);
    }

}
