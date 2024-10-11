package com.example.orders.controller;

import com.example.orders.dto.BillDto;
import com.example.orders.entity.Bill;
import com.example.orders.repository.BillRepository;
import com.example.orders.service.BillService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;



@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BillControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private BillService billService;

    @Test
    void getBillById_withValidBillDto_returnIsOK() throws Exception, RuntimeException {

        Bill bill = Bill.builder().dateBill(new Date()).totalAmount(100.0).build();
        Bill savedBill = billRepository.save(bill);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/bills/{id}", savedBill.getId()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(savedBill.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.totalAmount").value(savedBill.getTotalAmount()));
    }

    @Test
    void saveBill_withValidBillDto_returnBillDto() throws Exception {
        /*BillDto billDto = BillDto.builder().dateBill(new Date()).totalAmount(100.0).build();;
        String reqBody = new ObjectMapper().writeValueAsString(billDto);

        mockMvc.perform(MockMvcRequestBuilders.post("/bills")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON_VALUE)
                        .content(reqBody))
                        .andExpect(MockMvcResultMatchers.status().isCreated());*/
    }

}
