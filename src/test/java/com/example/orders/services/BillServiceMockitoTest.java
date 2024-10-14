package com.example.orders.services;

import com.example.orders.dto.BillDto;
import com.example.orders.entity.Bill;
import com.example.orders.mappers.BillMapper;
import com.example.orders.repository.BillRepository;
import com.example.orders.service.BillService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class BillServiceMockitoTest {

    @Mock
    private BillRepository billRepository;

    @Mock
    private BillMapper billMapper;

    @InjectMocks
    private BillService billService;


    @Test
    void getAllBill_withValidBillDTO_returnListOfBillDto() {

        Bill bill1 = Bill.builder().dateBill(new Date()).totalAmount(100.0).build();
        BillDto billDto1 = BillDto.builder().dateBill(new Date()).totalAmount(100.0).build();
        Bill bill2 = Bill.builder().dateBill(new Date()).totalAmount(100.0).build();
        BillDto billDto2 = BillDto.builder().dateBill(new Date()).totalAmount(100.0).build();
        List<BillDto> bills = new ArrayList<>();
        bills.add(billDto1);
        bills.add(billDto2);

        List<BillDto> beforeBills = billService.getAllBills();

        Mockito.when(billService.getAllBills()).thenReturn(bills);
        Mockito.when(billMapper.toDto(bill1)).thenReturn(billDto1);
        Mockito.when(billMapper.toEntity(billDto1)).thenReturn(bill1);
        Mockito.when(billMapper.toDto(bill2)).thenReturn(billDto2);
        Mockito.when(billMapper.toEntity(billDto2)).thenReturn(bill2);

        List<BillDto> actualBills = billService.getAllBills();

        assertEquals(beforeBills.size() + 2, actualBills.size());

    }


}
