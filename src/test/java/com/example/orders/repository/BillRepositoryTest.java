package com.example.orders.repository;

import com.example.orders.entity.Bill;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BillRepositoryTest {

    @Autowired
    public BillRepository billRepository;

	@Test
	@Transactional
	public void saveAndFlush_withValidBill_returnSavedBill() {
		//Create
		Bill last = billRepository.findFirstByOrderByIdDesc().orElse(Bill.builder().id(0L).build());
		Bill bill = Bill.builder().totalAmount(100.0).dateBill(new Date()).build();

		// Act
		Bill savedBill = billRepository.saveAndFlush(bill);

		// Assert
		assertNotNull(savedBill);
        assertEquals((long) savedBill.getId(), last.getId() + 1);
	}

	@Test
	public void findAll_withTwoValidBill_returnListOfBill() {

		Bill bill1 = Bill.builder().totalAmount(100.0).dateBill(new Date()).build();
		Bill bill2 = Bill.builder().totalAmount(100.0).dateBill(new Date()).build();

		List<Bill> beforeBills = billRepository.findAll();

		billRepository.save(bill1);
		billRepository.save(bill2);

		List<Bill> bills = billRepository.findAll();

		assertEquals(bills.size(), beforeBills.size()+2 );
	}
}
