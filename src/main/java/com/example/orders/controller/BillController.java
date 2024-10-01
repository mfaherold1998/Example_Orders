package com.example.orders.controller;

import com.example.orders.dto.BillDto;
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
    public List<BillDto> getAllBills(){
        return billService.getAllBills();
    }//DONE

    @GetMapping("/getbill/{id}")
    public BillDto getBillById(@PathVariable Long id){
        return billService.getBillById(id);
    }//DONE

    @PostMapping("/insert")
    public BillDto saveBill (@RequestBody @Valid BillDto billDto){
        return billService.saveBill(billDto);
    }//DONE

    @DeleteMapping("/delete/{id}")
    public BillDto deleteBill(@PathVariable Long id){
        return billService.deleteBill(id);
    }//DONE

    @PutMapping("/update/{id}")
    public BillDto updateBill (@RequestBody @Valid BillDto billDto){
        return billService.updateBill(billDto);
    }//DONE
}
