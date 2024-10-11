package com.example.orders.controller;

import com.example.orders.dto.BillDto;
import com.example.orders.entity.Bill;
import com.example.orders.repository.BillRepository;
import com.example.orders.service.BillService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;

import org.mockito.Mockito;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(controllers = {BillController.class})
public class BillControllerMockTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BillRepository billRepository;

    @MockBean
    private BillService billService;

    @Test
    void getBillById_withValidBill_returnIsOk() throws Exception, RuntimeException{

       /* Bill last = billRepository.findFirstByOrderByIdDesc().orElse(Bill.builder().id(0L).build());

        BillDto billDto = BillDto.builder()
                .dateBill(new Date())
                .totalAmount(100.0)
                .build();

        Mockito.when(billService.getBillById(last.getId()+1)).thenReturn(billDto);

        mockMvc.perform(MockMvcRequestBuilders.get("/bills/{id}", billDto.getId()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(last.getId()+1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.totalAmount").value(100.0));*/
    }
}
