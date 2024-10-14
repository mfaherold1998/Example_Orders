package com.example.orders.controller;

import com.example.orders.dto.BillDto;
import com.example.orders.entity.Bill;
import com.example.orders.service.BillService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class BillControllerMockitoTest {

    @Mock
    private BillService billService;

    @InjectMocks
    private BillController billController;

    @Test
    public void getAllBills_withValidDto_returnListOfBillDto() {
        BillDto bill1 = BillDto.builder().dateBill(new Date()).totalAmount(100.0).build();
        BillDto bill2 = BillDto.builder().dateBill(new Date()).totalAmount(200.0).build();
        List<BillDto> bills = new ArrayList<BillDto>();
        bills.add(bill1);
        bills.add(bill2);

        Mockito.when(billService.getAllBills()).thenReturn(bills);

        ResponseEntity<List<BillDto>> result = billController.getAllBills();

        assertEquals(2, result.getBody().size());
        assertEquals(100.0, result.getBody().get(0).getTotalAmount());
        assertEquals(200.0, result.getBody().get(1).getTotalAmount());
        assertEquals(200, result.getStatusCode().value());
    }

    @Test
    public void saveBill_withValidBillDto_returnBillDto()
    {
        BillDto bill = BillDto.builder().dateBill(new Date()).totalAmount(100.0).build();

        Mockito.when(billService.saveBill(ArgumentMatchers.any(BillDto.class))).thenReturn(bill);

        ResponseEntity<BillDto> responseEntity = billController.saveBill(bill);

        assertEquals(201, responseEntity.getStatusCode().value());
    }
}
