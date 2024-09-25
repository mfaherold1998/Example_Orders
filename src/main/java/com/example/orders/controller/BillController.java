package com.example.orders.controller;

import com.example.orders.entity.Bill;
import com.example.orders.service.BillService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bill")
public class BillController {

    @Autowired
    private BillService billService;

    @GetMapping("/findall")
    public List<Bill> getAllBills(){
        return billService.getAllBills();
    }

    @GetMapping("/getbill/{id}")
    public Bill getBillById(@RequestBody String id){
        return billService.getBillById(id);
    }

    @PostMapping("/insert")
    public void saveBill (@RequestBody @Valid Bill bill){//TODO usar un DTO como argumento
        billService.saveBill(bill);//TODO return el objeto salvado DTO
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBill(@PathVariable String id){
        billService.deleteBill(id);
    }

    @PutMapping("/update/{id}")
    public void updateBill (@RequestBody @Valid Bill bill){
        billService.updateBill(bill);
    }
}
