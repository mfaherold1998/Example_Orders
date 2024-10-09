package com.example.orders.services;

import com.example.orders.dto.BillDto;
import com.example.orders.dto.OrdineDto;
import com.example.orders.mappers.BillMapper;
import com.example.orders.repository.BillRepository;
import com.example.orders.service.BillService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BillServiceTest {

    @Mock
    public BillRepository billRepository;
    @Mock
    public BillMapper billMapper;
    @InjectMocks
    public BillService billService;

    private static BillDto bill;

    @BeforeAll
    public static void setUp(){
        OrdineDto ordine = new OrdineDto();
        bill = BillDto.builder()
                .id(1L)
                .dateBill(new Date())
                .totalAmount(100.0)
                //.ord(ordine)
                .build();
    }

    @Test
    void testBillDtoCreation(){
        assertNotNull(bill);
        assertEquals(1L, bill.getId());
        assertEquals(100.00, bill.getTotalAmount());
    }

    @Test
    void testGetAllBills_none_ListOfBillDto(){

        BillDto savedDto = billService.saveBill(bill);

        List<BillDto> bills = billService.getAllBills();

        assertNotNull(savedDto);
        assertEquals(1L,savedDto.getId());
    }


}
