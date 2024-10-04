package com.example.orders.controller;

import com.example.orders.dto.BillDto;
import com.example.orders.service.BillService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bills")
@RequiredArgsConstructor
public class BillController {

    private final BillService billService;

    @GetMapping("/findall")
    public List<BillDto> getAllBills(){
        return billService.getAllBills();
    }//POSTMAN

    @GetMapping("/{id}")
    public BillDto getBillById(@PathVariable Long id){
        return billService.getBillById(id);
    }//POSTMAN

    @PostMapping("/insert")
    public BillDto saveBill (@RequestBody @Valid BillDto billDto){
        return billService.saveBill(billDto);
    }//POSTMAN

    @DeleteMapping("/delete/{id}")
    public BillDto deleteBill(@PathVariable Long id){
        return billService.deleteBill(id);
    }//POSTMAN

    @PutMapping("/update")
    public BillDto updateBill (@RequestBody @Valid BillDto billDto){
        return billService.updateBill(billDto);
    }//POSTMAN
}
