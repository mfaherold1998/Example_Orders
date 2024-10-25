package com.example.orders.controller;

import com.example.orders.dto.BillDto;
import com.example.orders.service.BillService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BillController implements BillApi{

    private final BillService billService;

    @GetMapping(value = "/bills", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<BillDto>> getAllBills(){
        return ResponseEntity.ok(billService.getAllBills());
    }//

    @GetMapping(value = "/bills/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BillDto> getBillById(@PathVariable Long id){
        return ResponseEntity.ok(billService.getBillById(id));
    }//

    @PostMapping(value = "/bills", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BillDto> saveBill (@RequestBody @Valid BillDto billDto){
        return new ResponseEntity<>(billService.saveBill(billDto), HttpStatus.CREATED);
    }//

    @DeleteMapping("/bills/{id}")
    public ResponseEntity<Void> deleteBill(@PathVariable Long id){
        billService.deleteBill(id);
        return ResponseEntity.accepted().build();
    }//

    @PutMapping(value = "/bills", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BillDto> updateBill (@RequestBody @Valid BillDto billDto){
        return ResponseEntity.ok(billService.updateBill(billDto));
    }//
}
