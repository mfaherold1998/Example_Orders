package com.example.orders.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;

import com.example.orders.entity.Bill;

import jakarta.transaction.Transactional;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BillRepositoryTest {

	@Autowired
	public BillRepository billRepository;

	/*
	 * Usato cosi crea problemi
	 * 
	 * @BeforeAll public static void setUp(){ Ordine ordine = new Ordine();
	 * bill.setId(500L); bill.setTotalAmount(100.0); bill.setDateBill(new Date());
	 * //bill.setOrd(ordine); }
	 */

	@Test // La gestion de H2 no funciona bien
	@Transactional
	public void BillRepository_SaveAll_ReturnSavedBill() {

		Bill last = billRepository.findFirstByOrderByIdDesc().orElse(Bill.builder().id(0L).build());
		Bill bill = Bill.builder().totalAmount(100.0).dateBill(new Date()).build();
		// Act
		Bill savedBill = billRepository.saveAndFlush(bill);

		// Assert
		assertNotNull(savedBill);
		assertTrue(savedBill.getId() == last.getId()+1);
	}

	@Test
	public void BillRepository_GetAll_MoreThanOneBill() {
		Bill bill1 = Bill.builder().totalAmount(100.0).dateBill(new Date()).build();
		Bill bill2 = Bill.builder().totalAmount(100.0).dateBill(new Date()).build();

		List<Bill> beforeBills = billRepository.findAll();

		billRepository.save(bill1);
		billRepository.save(bill2);

		List<Bill> bills = billRepository.findAll();
		assertTrue(bills.size() > beforeBills.size());
	}
}
