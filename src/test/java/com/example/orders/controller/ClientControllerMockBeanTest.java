package com.example.orders.controller;

import com.example.orders.dto.ClientDto;
import com.example.orders.exceptions.NotFoundException;
import com.example.orders.repository.ClientRepository;
import com.example.orders.service.ClientService;
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
import java.util.List;
@WebMvcTest(ClientController.class)
class ClientControllerMockBeanTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClientRepository clientRepository;

    @MockBean
    private ClientService clientService;

    @Autowired
    private ObjectMapper objectMapper;

    private NotFoundException createNotFoundException(Long id){
        return new NotFoundException("Not Found Exception","There is not client with id "+id);
    }

    @Test
    void getAllClients_withValidClients_returnOk() throws Exception {

        ClientDto client1 = ClientDto.builder().name("Maria").email("maria@test.com").build();
        ClientDto client2 = ClientDto.builder().name("Federico").email("federico@test.com").build();

        List<ClientDto> clients = new ArrayList<ClientDto>();
        clients.add(client1);
        clients.add(client2);

        Mockito.when(clientService.getAllClients()).thenReturn(clients);


        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/clients")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(2));
    }

    @Test
    void getAllClients_withNone_returnEmptyList() throws Exception {

        List<ClientDto> clients = new ArrayList<ClientDto>();

        Mockito.when(clientService.getAllClients()).thenReturn(clients);


        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/clients")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isEmpty());
    }

    @Test
    void getClientById_whitValidClientDto_returnOk() throws Exception{
        Long id = 1L;
        ClientDto response = ClientDto.builder().id(id).name("Maria").email("maria@test.com").build();

        Mockito.when(clientService.getClientById(id)).thenReturn(response);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/clients/" + id)
                        .contentType(MediaType.APPLICATION_JSON))
                
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(id));
    }

    @Test
    void getClientById_whitInvalidClientDto_throwException() throws Exception{

        Long id = 1L;

        Mockito.when(clientService.getClientById(id)).thenThrow(createNotFoundException(id));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/clients/" + id)
                        .contentType(MediaType.APPLICATION_JSON))
                
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    void saveClient_withValidClientDto_returnOk() throws Exception{

        Long id = 1L;
        ClientDto response = ClientDto.builder().id(id).name("Maria").email("maria@test.com").build();

        Mockito.when(clientService.saveClient(ArgumentMatchers.any(ClientDto.class))).thenReturn(response);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/clients")
                        .content(objectMapper.writeValueAsString(response))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(id));
    }

    @Test
    void saveClient_withInvalidClientDto_returnOk() throws Exception {

        Long id = 1L;
        ClientDto response = ClientDto.builder().id(id).name("Maria").email("maria@test.com").build();

        Mockito.when(clientService.saveClient(ArgumentMatchers.any(ClientDto.class))).thenThrow(new RuntimeException());

        mockMvc.perform(MockMvcRequestBuilders.post("/api/clients")
                        .content(objectMapper.writeValueAsString(response))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                
                .andExpect(MockMvcResultMatchers.status().isInternalServerError());
    }

    @Test
    void deleteClient_withExistentClientDto_returnAccepted() throws Exception{

        Long id = 1L;

        Mockito.doNothing().when(clientService).deleteClient(id);

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/clients/{id}",id))
                
                .andExpect(MockMvcResultMatchers.status().isAccepted());

    }

    @Test
    void deleteClient_withNotExistentClientDto_throwNotFoundException() throws Exception{

        Long id = 1L;

        Mockito.doThrow(createNotFoundException(id)).when(clientService).deleteClient(id);

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/clients/{id}",id))
                
                .andExpect(MockMvcResultMatchers.status().isNotFound());

    }

    @Test
    void updateClient_withValidClientDto_returnOk() throws Exception{

        Long id = 1L;
        ClientDto response = ClientDto.builder().id(id).name("Maria").email("maria@test.com").build();

        Mockito.when(clientService.updateClient(ArgumentMatchers.any(ClientDto.class))).thenReturn(response);

        mockMvc.perform(MockMvcRequestBuilders.put("/api/clients")
                    .content(objectMapper.writeValueAsString(response))
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON_VALUE))
                
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    void updateClient_withInvalidClientDto_throwNotFoundException() throws Exception{

        Long id = 1L;
        ClientDto response = ClientDto.builder().id(id).name("Maria").email("maria@test.com").build();

        Mockito.when(clientService.updateClient(ArgumentMatchers.any(ClientDto.class))).thenThrow(createNotFoundException(id));

        mockMvc.perform(MockMvcRequestBuilders.put("/api/clients")
                    .content(objectMapper.writeValueAsString(response))
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON_VALUE))
                
                .andExpect(MockMvcResultMatchers.status().isNotFound());

    }
}
