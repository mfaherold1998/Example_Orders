package com.example.orders.services;

import com.example.orders.dto.ClientDto;
import com.example.orders.entity.Client;
import com.example.orders.exceptions.NotFoundException;
import com.example.orders.mappers.ClientMapper;
import com.example.orders.repository.ClientRepository;
import com.example.orders.service.ClientService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ClientServiceMockitoTest {

    @Mock
    private ClientRepository clientRepository;

    @Spy
    private ClientMapper clientMapper = Mappers.getMapper(ClientMapper.class);

    @InjectMocks
    private ClientService clientService;

    private NotFoundException createNotFoundException(Long id){
        return new NotFoundException("Not Found Exception","There is not Client with id "+id);
    }

    @Test
    void getAllClients_withValidClientDTO_returnListOClientDto() {

        Client client1 = Client.builder().id(1L).name("Maria").email("maria@test.com").build();
        Client client2 = Client.builder().id(2L).name("Federico").email("federico@test.com").build();
        List<Client> clients = new ArrayList<>();
        clients.add(client1);
        clients.add(client2);

        Mockito.when(clientRepository.findAll()).thenReturn(clients);

        List<ClientDto> response = clientService.getAllClients();

        assertEquals(2, response.size());

    }

    @Test
    void getAllClient_withNone_returnEmptyListOfClientDto() {

        List<Client> clients = new ArrayList<>();

        Mockito.when(clientRepository.findAll()).thenReturn(clients);

        List<ClientDto> response = clientService.getAllClients();

        assertEquals(0, response.size());
    }

    @Test
    void saveClient_withValidClientDTO_returnSavedClientDto() {

        Client client = Client.builder().id(1L).name("Maria").email("maria@test.com").build();
        ClientDto clientDto = ClientDto.builder().id(1L).name("Maria").email("maria@test.com").build();

        Mockito.when(clientRepository.saveAndFlush(ArgumentMatchers.any(Client.class))).thenReturn(client);

        ClientDto savedDto = clientService.saveClient(clientDto);

        assertNotNull(savedDto);
    }

    @Test
    void saveClient_withInvalidClientDTO_throwException() {

        ClientDto clientDto = ClientDto.builder().id(1L).name(null).email("maria@test.com").build();


        Mockito.when(clientRepository.saveAndFlush(ArgumentMatchers.any(Client.class))).thenThrow(new RuntimeException());

        assertThrows(RuntimeException.class, () -> {
            clientService.saveClient(clientDto);
        });
    }

    @Test
    void saveClient_withTwoValidDto_returnClientDto() {

        Client client = Client.builder().id(1L).name("Maria").email("maria@test.com").build();
        ClientDto clientDto = ClientDto.builder().id(1L).name("Maria").email("maria@test.com").build();

        Mockito.when(clientRepository.saveAndFlush(ArgumentMatchers.any(Client.class))).thenReturn(client);

        ClientDto savedClient = clientService.saveClient(clientDto);

        assertEquals(1L, savedClient.getId());
    }

    @Test
    void getClientById_withValidClientDto_returnClientDto(){

        Long id = 1L;
        Client client = Client.builder().id(1L).name("Maria").email("maria@test.com").build();
        Optional<Client> optClient = Optional.of(client);

        Mockito.when(clientRepository.findById(id)).thenReturn(optClient);

        ClientDto cli = clientService.getClientById(id);

        assertNotNull(cli);
        assertEquals(1L, cli.getId());

    }

    @Test
    void getClientById_withInvalidId_throwException(){

        Long id = 1L;

        Mockito.when(clientRepository.findById(id)).thenThrow(createNotFoundException(id));

        assertThrows(NotFoundException.class, () -> {
            clientService.getClientById(id);
        });
    }

    @Test
    void deleteClient_withValidClientDto_mockitoVerify(){

        Long id = 1L;

        Mockito.when(clientRepository.existsById(id)).thenReturn(true);
        Mockito.doNothing().when(clientRepository).deleteById(id);

        clientService.deleteClient(id);

        Mockito.verify(clientRepository, Mockito.times(1)).deleteById(id);

    }

    @Test
    void deleteClient_withInvalidId_throwException(){

        Long id = 1L;

        assertThrows(NotFoundException.class, () -> {
            clientService.deleteClient(id);
        });
    }

    @Test
    void existById_withExistingClientDto_returnTrue(){

        Long id = 1L;

        Mockito.when(clientRepository.existsById(id)).thenReturn(true);

        assertTrue(clientService.existsById(id));
    }

    @Test
    void updateClient_withValidClientDto_returnUpdatedClientDto(){

        Long id = 1L;
        Client client = Client.builder().id(1L).name("Maria").email("maria@test.com").build();
        ClientDto clientDto = ClientDto.builder().id(1L).name("Maria").email("maria@test.com").build();

        Mockito.when(clientRepository.saveAndFlush(ArgumentMatchers.any(Client.class))).thenReturn(client);
        Mockito.when(clientRepository.existsById(id)).thenReturn(true);

        ClientDto updatedClient = clientService.updateClient(clientDto);

        assertEquals(id, updatedClient.getId());
        assertEquals("Maria", updatedClient.getName());

    }

    @Test
    void updateClient_withInvalidClientDto_throwException(){

        Long id = 1L;
        ClientDto clientDto = ClientDto.builder().id(1L).build();

        Mockito.when(clientRepository.existsById(id)).thenReturn(false);

        assertThrows(NotFoundException.class, () -> {
            clientService.updateClient(clientDto);
        });
    }

}
