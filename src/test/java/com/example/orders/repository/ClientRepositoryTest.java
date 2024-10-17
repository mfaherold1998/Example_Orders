package com.example.orders.repository;

import com.example.orders.entity.Client;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ClientRepositoryTest {

    @Autowired
    public ClientRepository clientRepository;

    @Test
    @Transactional
    void saveAndFlush_withValidClient_returnSavedClient() {
        //Create
        Client last = clientRepository.findFirstByOrderByIdDesc().orElse(Client.builder().id(0L).build());
        Client client = Client.builder().name("Maria").email("maria@test.com").build();

        // Act
        Client savedClient = clientRepository.saveAndFlush(client);

        // Assert
        assertNotNull(savedClient);
        assertEquals(last.getId() + 1, (long) savedClient.getId());
    }

    @Test
    void findAll_withTwoValidClients_returnListOfClients() {

        Client client1 = Client.builder().name("Maria").email("maria@test.com").build();
        Client client2 = Client.builder().name("Federico").email("federico@test.com").build();

        List<Client> beforeClients = clientRepository.findAll();

        clientRepository.save(client1);
        clientRepository.save(client2);

        List<Client> clients = clientRepository.findAll();

        assertEquals(beforeClients.size()+2 , clients.size());
    }

    @Test
    void findAllByName_withTwoValidClients_returnListOfClients() {

        Client client1 = Client.builder().name("Maria").email("maria@test.com").build();
        Client client2 = Client.builder().name("Maria").email("federico@test.com").build();

        List<Client> beforeClient = clientRepository.findAllByName("Maria");

        clientRepository.save(client1);
        clientRepository.save(client2);

        List<Client> clients = clientRepository.findAllByName("Maria");

        assertEquals(beforeClient.size()+2, clients.size());
        assertEquals("Maria", clients.get(0).getName());
        assertEquals("Maria", clients.get(1).getName());
    }


    @Test
    @Transactional
    void save_withInvalidName_throwException(){

        Client client1 = Client.builder().name(null).email("maria@test.com").build();

        assertThrows(DataIntegrityViolationException.class, () -> {
            clientRepository.save(client1);
        });
    }

    @Test
    @Transactional
    void deleteById_withValidClient_returnListOfClients(){

        Client client0 = clientRepository.findFirstByOrderByIdDesc().orElse(Client.builder().id(0L).build());
        Client client1 = Client.builder().name("Maria").email("maria@test.com").build();
        Client client2 = Client.builder().name("Federico").email("federico@test.com").build();

        clientRepository.save(client1);
        clientRepository.save(client2);

        List<Client> beforeClient = clientRepository.findAll();

        clientRepository.deleteById(client0.getId()+2);

        List<Client> actualClient = clientRepository.findAll();

        assertEquals(beforeClient.size()-1, actualClient.size());

    }

    @Test
    @Transactional
    void deleteById_withInvalidId_throwException(){

        Client client0 = clientRepository.findFirstByOrderByIdDesc().orElse(Client.builder().id(0L).build());
        Client client1 = Client.builder().name("Maria").email("maria@test.com").build();
        Client client2 = Client.builder().name("Federico").email("federico@test.com").build();

        clientRepository.save(client1);
        clientRepository.save(client1);

        assertDoesNotThrow(() -> {
            clientRepository.deleteById(client0.getId() + 3);
        });

    }
}