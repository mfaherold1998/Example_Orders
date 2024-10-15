package com.example.orders.controller;

import com.example.orders.dto.BillDto;
import com.example.orders.repository.BillRepository;
import com.example.orders.service.BillService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(BillController.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BillControllerMockBeanTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BillRepository billRepository;

    @MockBean
    private BillService billService;

    @Test
    void getAllBills_withValidBills_returnOk() throws Exception {

        BillDto bill1 = BillDto.builder().dateBill(new Date()).totalAmount(100.0).build();
        BillDto bill2 = BillDto.builder().dateBill(new Date()).totalAmount(200.0).build();

        List<BillDto> bills = new ArrayList<BillDto>();
        bills.add(bill1);
        bills.add(bill2);

        Mockito.when(billService.getAllBills()).thenReturn(bills);


        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/bills")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isNotEmpty());
    }
}
