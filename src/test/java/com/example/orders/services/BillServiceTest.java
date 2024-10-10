package com.example.orders.services;

import com.example.orders.dto.BillDto;
import com.example.orders.mappers.BillMapper;
import com.example.orders.repository.BillRepository;
import com.example.orders.service.BillService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BillServiceTest {

    //@Mock
    @Autowired
    public BillRepository billRepository;
    //@Mock
    @Autowired
    public BillMapper billMapper;
    //@InjectMocks
    @Autowired
    public BillService billService;

    @Test
    void testSaveBills_none_BillDto(){

        BillDto billDto1 = BillDto.builder()
                .id(1L)
                .dateBill(new Date())
                .totalAmount(100.0)
                .build();

        BillDto savedDto = billService.saveBill(billDto1);

        assertNotNull(savedDto);
        assertEquals(1L,savedDto.getId());
    }

    @Test
    void testGetAllBills_none_ListOfBillDto(){


        BillDto billDto1 = BillDto.builder()
                .id(1L)
                .dateBill(new Date())
                .totalAmount(100.0)
                .build();
        BillDto billDto2 = BillDto.builder()
                .id(2L)
                .dateBill(new Date())
                .totalAmount(100.0)
                .build();

        BillDto savedDto1 = billService.saveBill(billDto1);
        BillDto savedDto2 = billService.saveBill(billDto2);

        assertEquals(1L,savedDto1.getId());
        assertEquals(2L,savedDto2.getId());
        assertEquals(2,billService.getAllBills().size());
    }

}
