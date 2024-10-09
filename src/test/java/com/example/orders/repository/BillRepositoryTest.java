package com.example.orders.repository;

import com.example.orders.entity.Bill;
import com.example.orders.entity.Ordine;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class BillRepositoryTest {

    @Autowired
    public BillRepository billRepository;
    private static Bill bill = new Bill();

    @BeforeAll
    public static void setUp(){
        Ordine ordine = new Ordine();
        bill.setId(500L);
        bill.setTotalAmount(100.0);
        bill.setDateBill(new Date());
        //bill.setOrd(ordine);
    }

    @Test//La gestion de H2 no funciona bien
    public void BillRepository_SaveAll_ReturnSavedBill(){

        //Arrange: crear el objeto (setUp)

        //Act
        Bill savedBill = billRepository.save(bill);

        //Assert
        assertNotNull(savedBill);
        assertEquals(1L,savedBill.getId());
    }

    @Test
    public void BillRepository_GetAll_MoreThanOneBill(){
        Bill bill1 = new Bill();
        Bill bill2 = new Bill();
        bill1.setId(3L);
        bill1.setTotalAmount(100.0);
        bill1.setDateBill(new Date());
        bill2.setId(4L);
        bill2.setTotalAmount(100.0);
        bill2.setDateBill(new Date());

        billRepository.save(bill1);
        billRepository.save(bill2);

        List<Bill> bills = billRepository.findAll();

        assertNotNull(bills);
        assertEquals(2,bills.size());
    }
}
