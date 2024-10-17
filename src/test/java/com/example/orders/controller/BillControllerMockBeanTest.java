package com.example.orders.controller;

import com.example.orders.dto.BillDto;
import com.example.orders.exceptions.NotFoundException;
import com.example.orders.repository.BillRepository;
import com.example.orders.service.BillService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(BillController.class)
class BillControllerMockBeanTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BillRepository billRepository;

    @MockBean
    private BillService billService;

    @Autowired
    private ObjectMapper objectMapper;

    private NotFoundException createNotFoundException(Long id){
        return new NotFoundException("Not Found Exception","There is not bill with id "+id);
    }

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
                .andExpect(MockMvcResultMatchers.jsonPath("$").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(2));
    }

    @Test
    void getAllBills_withNone_returnEmptyList() throws Exception {

        List<BillDto> bills = new ArrayList<BillDto>();

        Mockito.when(billService.getAllBills()).thenReturn(bills);


        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/bills")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isEmpty());
    }

    @Test
    void getBillById_whitValidBillDto_returnOk() throws Exception{
        Long id = 1L;
        BillDto response = BillDto.builder().id(id).dateBill(new Date()).totalAmount(100.0).build();

        Mockito.when(billService.getBillById(id)).thenReturn(response);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/bills/" + id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(id));
    }

    @Test
    void getBillById_whitInvalidBillDto_throwException() throws Exception{

        Long id = 1L;

        Mockito.when(billService.getBillById(id)).thenThrow(createNotFoundException(id));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/bills/" + id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    void saveBill_withValidBillDto_returnOk() throws Exception{

        Long id = 1L;
        BillDto response = BillDto.builder().id(id).dateBill(new Date()).totalAmount(100.0).build();

        Mockito.when(billService.saveBill(ArgumentMatchers.any(BillDto.class))).thenReturn(response);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/bills")
                        .content(objectMapper.writeValueAsString(response))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(id));
    }

    @Test
    void saveBill_withInvalidBillDto_throwException() throws Exception {

        Long id = 1L;
        BillDto response = BillDto.builder().id(id).dateBill(new Date()).totalAmount(null).build();

        Mockito.when(billService.saveBill(ArgumentMatchers.any(BillDto.class))).thenThrow(new RuntimeException());

        mockMvc.perform(MockMvcRequestBuilders.post("/api/bills")
                        .content(objectMapper.writeValueAsString(response))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isInternalServerError());
    }

    @Test
    void deleteBill_withExistentId_returnAccepted() throws Exception{

        Long id = 1L;

        Mockito.doNothing().when(billService).deleteBill(id);

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/bills/{id}",id))
                
                .andExpect(MockMvcResultMatchers.status().isAccepted());

    }

    @Test
    void deleteBill_withInvalidId_throwNotFoundException() throws Exception{

        Long id = 1L;

        Mockito.doThrow(createNotFoundException(id)).when(billService).deleteBill(id);

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/bills/{id}",id))
                
                .andExpect(MockMvcResultMatchers.status().isNotFound());

    }

    @Test
    void updateBill_withValidBillDto_returnOk() throws Exception{

        Long id = 1L;
        BillDto response = BillDto.builder().id(id).dateBill(new Date()).totalAmount(200.0).build();

        Mockito.when(billService.updateBill(ArgumentMatchers.any(BillDto.class))).thenReturn(response);

        mockMvc.perform(MockMvcRequestBuilders.put("/api/bills")
                    .content(objectMapper.writeValueAsString(response))
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON_VALUE))
                
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    void updateBill_withInvalidBillDto_throwNotFoundException() throws Exception{

        Long id = 1L;
        BillDto response = BillDto.builder().id(id).dateBill(new Date()).totalAmount(200.0).build();

        Mockito.when(billService.updateBill(ArgumentMatchers.any(BillDto.class))).thenThrow(createNotFoundException(id));

        mockMvc.perform(MockMvcRequestBuilders.put("/api/bills")
                    .content(objectMapper.writeValueAsString(response))
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON_VALUE))
                
                .andExpect(MockMvcResultMatchers.status().isNotFound());

    }
}
