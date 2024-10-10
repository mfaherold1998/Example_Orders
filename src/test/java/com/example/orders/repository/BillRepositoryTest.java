package com.example.orders.repository;

import com.example.orders.entity.Bill;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class BillRepositoryTest {

    @Autowired
    public BillRepository billRepository;

    @Test
    public void BillRepository_SaveAll_ReturnSavedBill(){

        //Arrange: crear el objeto
        Bill bill = new Bill();
        bill.setId(1L);
        bill.setTotalAmount(100.0);
        bill.setDateBill(new Date());

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

        bill1.setId(1L);
        bill1.setTotalAmount(100.0);
        bill1.setDateBill(new Date());

        bill2.setId(2L);
        bill2.setTotalAmount(100.0);
        bill2.setDateBill(new Date());

        billRepository.save(bill1);
        billRepository.save(bill2);

        List<Bill> bills = billRepository.findAll();

        assertNotNull(bills);
        assertEquals(1,bills.size());
    }

}
