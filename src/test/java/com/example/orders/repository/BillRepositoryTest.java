package com.example.orders.repository;

import com.example.orders.entity.Bill;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class BillRepositoryTest {

    @Autowired
    public BillRepository billRepository;

	@Test
	@Transactional
	public void saveAndFlush_withValidBill_returnSavedBill() {
		//Create
		Bill bill1 = new Bill();
		bill1.setId(0L);

		Bill last = billRepository.findFirstByOrderByIdDesc().orElse(bill1);

		Bill bill2 = new Bill();
		bill2.setTotalAmount(100.0);
		bill2.setDateBill(new Date());

		// Act
		Bill savedBill = billRepository.saveAndFlush(bill2);

		// Assert
		assertNotNull(savedBill);
        assertEquals((long) savedBill.getId(), last.getId() + 1);
	}

	@Test
	public void findAll_withTwoValidBill_returnListOfBill() {

		Bill bill1 = new Bill();
		bill1.setTotalAmount(100.0);
		bill1.setDateBill(new Date());

		Bill bill2 = new Bill();
		bill2.setTotalAmount(100.0);
		bill2.setDateBill(new Date());

		List<Bill> beforeBills = billRepository.findAll();

		billRepository.save(bill1);
		billRepository.save(bill2);

		List<Bill> bills = billRepository.findAll();

		assertTrue(bills.size() > beforeBills.size());
	}
}
