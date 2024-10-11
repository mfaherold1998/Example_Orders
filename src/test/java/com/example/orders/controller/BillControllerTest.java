package com.example.orders.controller;

import com.example.orders.entity.Bill;
import com.example.orders.repository.BillRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;



@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BillControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BillRepository billRepository;

    @Test
    void getBillById_withValidBillDto_returnIsOK() throws Exception, RuntimeException {

        Bill bill = Bill.builder().dateBill(new Date()).totalAmount(100.0).build();
        Bill savedBill = billRepository.save(bill);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/bills/{id}", savedBill.getId()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(savedBill.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.totalAmount").value(savedBill.getTotalAmount()));
    }

}
