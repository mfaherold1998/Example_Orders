package com.example.orders.controller;

import com.example.orders.dto.ClientDto;
import com.example.orders.dto.OrdineDto;
import com.example.orders.dto.ProductDto;
import com.example.orders.exceptions.NotFoundException;
import com.example.orders.repository.OrdineRepository;
import com.example.orders.service.OrdineService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@WebMvcTest(OrdineController.class)
class OrdineControllerMockBeanTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrdineRepository ordineRepository;

    @MockBean
    private OrdineService ordineService;

    @Autowired
    private ObjectMapper objectMapper;

    private NotFoundException createNotFoundException(Long id){
        return new NotFoundException("Not Found Exception","There is not ordine with id "+id);
    }

    @Test
    void getAllOrdini_withValidOrdini_returnOk() throws Exception {

        Long id = 1L;
        ClientDto cliDto = ClientDto.builder().id(id).build();
        OrdineDto ordine1 = OrdineDto.builder().id(id).dateOrdine(new Date()).total(100.0).cli(cliDto).build();
        OrdineDto ordine2 = OrdineDto.builder().id(id).dateOrdine(new Date()).total(100.0).cli(cliDto).build();

        List<OrdineDto> ordini = new ArrayList<OrdineDto>();
        ordini.add(ordine1);
        ordini.add(ordine2);

        Mockito.when(ordineService.getAllOrdini()).thenReturn(ordini);


        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/ordini")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(2));
    }

    @Test
    void getAllOrdini_withNone_returnEmptyList() throws Exception {

        List<OrdineDto> ordini = new ArrayList<OrdineDto>();

        Mockito.when(ordineService.getAllOrdini()).thenReturn(ordini);


        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/ordini")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isEmpty());
    }

    @Test
    void getOrdineById_whitValidOrdineDto_returnOk() throws Exception{

        Long id = 1L;
        ClientDto cliDto = ClientDto.builder().id(id).build();
        OrdineDto response = OrdineDto.builder().id(id).dateOrdine(new Date()).total(100.0).cli(cliDto).build();

        Mockito.when(ordineService.getOrdineById(id)).thenReturn(response);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/ordini/" + id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(id));
    }

    @Test
    void getOrdineById_whitInvalidOrdineDto_throwException() throws Exception{

        Long id = 1L;

        Mockito.when(ordineService.getOrdineById(id)).thenThrow(createNotFoundException(id));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/ordini/" + id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    void saveOrdine_withValidOrdineDto_returnOk() throws Exception{

        Long id = 1L;
        ClientDto cliDto = ClientDto.builder().id(id).name("Maria").email("maria@test.com").build();
        OrdineDto response = OrdineDto.builder().id(id).dateOrdine(new Date()).total(100.0).cli(cliDto).prods(new ArrayList<ProductDto>()).build();

        Mockito.when(ordineService.saveOrdine(ArgumentMatchers.any(OrdineDto.class))).thenReturn(response);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/ordini")
                        .content(objectMapper.writeValueAsString(response))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(id));
    }

    @Test
    void saveOrdine_withInvalidOrdineDto_returnOk() throws Exception {

        Long id = 1L;
        ClientDto cliDto = ClientDto.builder().id(id).build();
        OrdineDto response = OrdineDto.builder().id(id).dateOrdine(new Date()).total(100.0).cli(cliDto).build();

        Mockito.when(ordineService.saveOrdine(ArgumentMatchers.any(OrdineDto.class))).thenThrow(new RuntimeException());

        mockMvc.perform(MockMvcRequestBuilders.post("/api/ordini")
                        .content(objectMapper.writeValueAsString(response))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isInternalServerError());
    }

    @Test
    void deleteOrdine_withExistentOrdineDto_returnAccepted() throws Exception{

        Long id = 1L;

        Mockito.doNothing().when(ordineService).deleteOrdine(id);

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/ordini/{id}",id))
                .andExpect(MockMvcResultMatchers.status().isAccepted());

    }

    @Test
    void deleteOrdine_withNotExistentOrdineDto_throwNotFoundException() throws Exception{

        Long id = 1L;

        Mockito.doThrow(createNotFoundException(id)).when(ordineService).deleteOrdine(id);

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/ordini/{id}",id))
               .andExpect(MockMvcResultMatchers.status().isNotFound());

    }

    @Test
    void updateOrdine_withValidOrdineDto_returnOk() throws Exception{

        Long id = 1L;
        ClientDto cliDto = ClientDto.builder().id(id).name("Maria").email("maria@test.com").build();
        OrdineDto response = OrdineDto.builder().id(id).dateOrdine(new Date()).total(100.0).cli(cliDto).prods(new ArrayList<ProductDto>()).build();

        Mockito.when(ordineService.updateOrdine(ArgumentMatchers.any(OrdineDto.class))).thenReturn(response);

        mockMvc.perform(MockMvcRequestBuilders.put("/api/ordini")
                    .content(objectMapper.writeValueAsString(response))
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    void updateOrdine_withInvalidOrdineDto_throwNotFoundException() throws Exception{

        Long id = 1L;
        ClientDto cliDto = ClientDto.builder().id(id).name("Maria").email("maria@test.com").build();
        OrdineDto response = OrdineDto.builder().id(id).dateOrdine(new Date()).total(100.0).cli(cliDto).prods(new ArrayList<ProductDto>()).build();

        Mockito.when(ordineService.updateOrdine(ArgumentMatchers.any(OrdineDto.class))).thenThrow(createNotFoundException(id));

        mockMvc.perform(MockMvcRequestBuilders.put("/api/ordini")
                    .content(objectMapper.writeValueAsString(response))
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isNotFound());

    }
}
