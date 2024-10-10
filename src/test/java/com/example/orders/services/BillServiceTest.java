package com.example.orders.services;

import com.example.orders.dto.BillDto;
import com.example.orders.entity.Bill;
import com.example.orders.mappers.BillMapper;
import com.example.orders.repository.BillRepository;
import com.example.orders.service.BillService;
import jakarta.transaction.Transactional;
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
    void saveBill_withValidDTO_returnBillDto() {
        BillDto billDto1 = BillDto.builder().dateBill(new Date()).totalAmount(100.0).build();
        BillDto savedDto = billService.saveBill(billDto1);
        assertNotNull(savedDto);
    }

    @Test
    @Transactional
    void saveBills_withTwoValidDto_returnListOfBillDto() {

        Bill last = billRepository.findFirstByOrderByIdDesc().orElse(Bill.builder().id(0L).build());

        BillDto billDto1 = BillDto.builder().dateBill(new Date()).totalAmount(100.0).build();
        BillDto billDto2 = BillDto.builder().dateBill(new Date()).totalAmount(100.0).build();

        BillDto savedDto1 = billService.saveBill(billDto1);
        BillDto savedDto2 = billService.saveBill(billDto2);

        assertEquals(last.getId() + 1, savedDto1.getId());
        assertEquals(last.getId() + 2, savedDto2.getId());
    }

}
