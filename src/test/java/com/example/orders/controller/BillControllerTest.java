package com.example.orders.controller;

import com.example.orders.dto.BillDto;
import com.example.orders.entity.Bill;
import com.example.orders.repository.BillRepository;
import com.example.orders.service.BillService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Disabled;
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
@Disabled
public class BillControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private BillService billService;

    //GET
    @Test
    void getBillById_withValidBillDto_returnIsOK() throws Exception, RuntimeException {

        Bill bill = Bill.builder().dateBill(new Date()).totalAmount(100.0).build();
        Bill savedBill = billRepository.save(bill);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/bills/{id}", savedBill.getId()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(savedBill.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.totalAmount").value(savedBill.getTotalAmount()));
    }

    //DELETE
    @Test
    void deleteBill_withExistentBillDto_returnVoid() throws Exception {
        Bill bill = Bill.builder().dateBill(new Date()).totalAmount(100.0).build();
        Bill savedBill = billRepository.save(bill);

        mockMvc.perform( MockMvcRequestBuilders.delete("/api/bills/{id}", savedBill.getId()) )
                .andExpect(MockMvcResultMatchers.status().isAccepted());

    }

    @Test
    void deleteBill_withNotExistentBillDto_throwException() throws Exception {

        mockMvc.perform( MockMvcRequestBuilders.delete("/api/bills/{id}", 1L) )
                .andExpect(MockMvcResultMatchers.status().isNotFound());

    }

    //PUT
    @Test
    void updatebill_withExistentBillDto_returnBillDto() throws Exception{
        Date date = new Date();
        Bill bill1 = Bill.builder().dateBill(date).totalAmount(100.0).build();
        Bill savedBill = billRepository.save(bill1);

        Bill bill2 = Bill.builder().id(bill1.getId()).dateBill(date).totalAmount(200.0).build();
        String reqBody = new ObjectMapper().writeValueAsString(bill2);

        mockMvc.perform( MockMvcRequestBuilders
                        .put("/api/bills", savedBill.getId())
                        .content(reqBody)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value((savedBill.getId())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.totalAmount").value(200.0));
    }

    //POST
    @Test
    void saveBill_withValidBillDto_returnBillDto() throws Exception {
        BillDto billDto = BillDto.builder().dateBill(new Date()).totalAmount(100.0).build();
        String reqBody = new ObjectMapper().writeValueAsString(billDto);

        mockMvc.perform( MockMvcRequestBuilders
                        .post("/api/bills")
                        .content(reqBody)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
    }

}
