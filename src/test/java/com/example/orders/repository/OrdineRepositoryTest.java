package com.example.orders.repository;

import com.example.orders.entity.Client;
import com.example.orders.entity.Ordine;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.annotation.DirtiesContext;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Disabled
@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class OrdineRepositoryTest {

    @Autowired
    public OrdineRepository ordineRepository;

    @Autowired
    public ClientRepository clientRepository;

    @Test
    @Transactional
    void saveAndFlush_withValidOrdine_returnSavedOrdine() {
        //Create
        Client client = Client.builder().name("Maria").email("maria@test.com").build();
        clientRepository.save(client);
        Ordine last = ordineRepository.findFirstByOrderByIdDesc().orElse(Ordine.builder().id(0L).build());
        Ordine ordine = Ordine.builder().total(100.0).dateOrdine(new Date()).cli(client).build();

        // Act
        Ordine savedOrdine = ordineRepository.saveAndFlush(ordine);

        // Assert
        assertNotNull(savedOrdine);
        assertEquals(last.getId() + 1, (long) savedOrdine.getId());
    }

    @Test
    void findAll_withTwoValidOrdine_returnListOfOrdine() {

        Client client = Client.builder().name("Maria").email("maria@test.com").build();
        clientRepository.save(client);
        Ordine ordine1 = Ordine.builder().total(100.0).dateOrdine(new Date()).cli(client).build();
        Ordine ordine2 = Ordine.builder().total(100.0).dateOrdine(new Date()).cli(client).build();

        List<Ordine> beforeOrdine = ordineRepository.findAll();

        ordineRepository.save(ordine1);
        ordineRepository.save(ordine2);

        List<Ordine> ordines = ordineRepository.findAll();

        assertEquals(beforeOrdine.size()+2 , ordines.size());
    }

    @Test
    void findAllByTotal_withTwoValidOrdine_returnListOfOrdine() {

        Client client = Client.builder().name("Maria").email("maria@test.com").build();
        clientRepository.save(client);
        Ordine ordine1 = Ordine.builder().total(100.0).dateOrdine(new Date()).cli(client).build();
        Ordine ordine2 = Ordine.builder().total(100.0).dateOrdine(new Date()).cli(client).build();

        List<Ordine> beforeOrdine = ordineRepository.findAllByTotal(100.0);

        ordineRepository.save(ordine1);
        ordineRepository.save(ordine2);

        List<Ordine> ordines = ordineRepository.findAllByTotal(100.0);

        assertEquals(beforeOrdine.size()+2, ordines.size());
    }

    @Test
    void findAllByDateBill_withTwoValidOrdine_returnListOfOrdine() {

        Date date= new Date();

        Client client = Client.builder().name("Maria").email("maria@test.com").build();
        clientRepository.save(client);
        Ordine ordine1 = Ordine.builder().total(100.0).dateOrdine(date).cli(client).build();
        Ordine ordine2 = Ordine.builder().total(100.0).dateOrdine(date).cli(client).build();

        List<Ordine> beforeOrdine = ordineRepository.findAllByDateOrdine(date);

        ordineRepository.save(ordine1);
        ordineRepository.save(ordine2);

        List<Ordine> ordines = ordineRepository.findAllByDateOrdine(date);

        assertEquals(beforeOrdine.size()+2, ordines.size());
    }

    @Test
    @Transactional
    void save_withInvalidTotal_trhowException(){

        Client client = Client.builder().name("Maria").email("maria@test.com").build();
        clientRepository.save(client);
        Ordine ordine1 = Ordine.builder().total(null).dateOrdine(new Date()).cli(client).build();

        assertThrows(DataIntegrityViolationException.class, () -> {
            ordineRepository.save(ordine1);
        });
    }

    @Test
    @Transactional
    void deleteById_withValidOrdine_returnListOfOrdine(){

        Client client = Client.builder().name("Maria").email("maria@test.com").build();
        clientRepository.save(client);
        Ordine ordine0 = ordineRepository.findFirstByOrderByIdDesc().orElse(Ordine.builder().id(0L).build());
        Ordine ordine1 = Ordine.builder().total(100.0).dateOrdine(new Date()).cli(client).build();
        Ordine ordine2 = Ordine.builder().total(100.0).dateOrdine(new Date()).cli(client).build();

        ordineRepository.save(ordine1);
        ordineRepository.save(ordine2);

        List<Ordine> beforeOrdine = ordineRepository.findAll();

        ordineRepository.deleteById(ordine0.getId()+2);

        List<Ordine> actualOrdine = ordineRepository.findAll();

        assertEquals(beforeOrdine.size()-1, actualOrdine.size());

    }

    @Test
    @Transactional
    void deleteById_withInalidId_throwException(){

        Ordine ordine0 = ordineRepository.findFirstByOrderByIdDesc().orElse(Ordine.builder().id(0L).build());

        assertDoesNotThrow(() -> {
            ordineRepository.deleteById(ordine0.getId() + 1);
        });

    }
}
