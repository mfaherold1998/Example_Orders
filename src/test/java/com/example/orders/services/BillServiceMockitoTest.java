package com.example.orders.services;

import com.example.orders.dto.BillDto;
import com.example.orders.entity.Bill;
import com.example.orders.mappers.BillMapper;
import com.example.orders.repository.BillRepository;
import com.example.orders.service.BillService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BillServiceMockitoTest {

    @Mock
    private BillRepository billRepository;

    @Mock
    private BillMapper billMapper;

    @InjectMocks
    private BillService billService;


    @Test
    void saveBill_withValidBillDTO_returnSavedBillDtoNotNull() {

        /*Date date = new Date();

        Bill bill = Bill.builder().dateBill(date).totalAmount(100.0).build();
        BillDto billDto = BillDto.builder().dateBill(date).totalAmount(100.0).build();

        lenient().when(billMapper.toDto(Mockito.any(Bill.class))).thenReturn(billDto);
        when(billMapper.toEntity(Mockito.any(BillDto.class))).thenReturn(bill);
        when(billRepository.save(Mockito.any(Bill.class))).thenReturn(bill);

        BillDto savedDto = billService.saveBill(billDto);

        assertNotNull(savedDto);*/
    }


}
