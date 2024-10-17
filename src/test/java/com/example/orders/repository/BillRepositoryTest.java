package com.example.orders.repository;

import com.example.orders.entity.Bill;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.annotation.DirtiesContext;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class BillRepositoryTest {

    @Autowired
    public BillRepository billRepository;

	@Test
	@Transactional
	void saveAndFlush_withValidBill_returnSavedBill() {
		
		Bill lastBill = billRepository.findFirstByOrderByIdDesc().orElse(Bill.builder().id(0L).build());
		Bill bill = Bill.builder().totalAmount(100.0).dateBill(new Date()).build();

		Bill savedBill = billRepository.saveAndFlush(bill);

		assertNotNull(savedBill);
        assertEquals(lastBill.getId() + 1, (long) savedBill.getId());
	}

	@Test
	void findAll_withTwoValidBill_returnListOfBill() {

		Bill bill1 = Bill.builder().totalAmount(100.0).dateBill(new Date()).build();
		Bill bill2 = Bill.builder().totalAmount(100.0).dateBill(new Date()).build();

		List<Bill> billsBefore = billRepository.findAll();

		billRepository.save(bill1);
		billRepository.save(bill2);

		List<Bill> bills = billRepository.findAll();

		assertEquals(billsBefore.size()+2 , bills.size());
	}

	@Test
	void findAllByTotalAmount_withTwoValidBill_returnListOfBill() {

		Bill bill1 = Bill.builder().totalAmount(100.0).dateBill(new Date()).build();
		Bill bill2 = Bill.builder().totalAmount(100.0).dateBill(new Date()).build();

		List<Bill> billsBefore = billRepository.findAllByTotalAmount(100.0);

		billRepository.save(bill1);
		billRepository.save(bill2);

		List<Bill> bills = billRepository.findAllByTotalAmount(100.0);

		assertEquals(billsBefore.size()+2, bills.size());
	}

	@Test
	void findAllByDateBill_withTwoValidBill_returnListOfBill() {

		Date date= new Date();

		Bill bill1 = Bill.builder().totalAmount(100.0).dateBill(date).build();
		Bill bill2 = Bill.builder().totalAmount(100.0).dateBill(date).build();

		List<Bill> billsBefore = billRepository.findAllByDateBill(date);

		billRepository.save(bill1);
		billRepository.save(bill2);

		List<Bill> bills = billRepository.findAllByDateBill(date);

		assertEquals(billsBefore.size()+2, bills.size());
	}

	@Test
	@Transactional
	void save_withInvalidTotalAmount_throwException(){

		Bill bill1 = Bill.builder().totalAmount(null).dateBill(new Date()).build();

		assertThrows(DataIntegrityViolationException.class, () -> {
			billRepository.save(bill1);
		});
	}

	@Test
	@Transactional
	void save_withInvalidDate_throwException(){

		Bill bill1 = Bill.builder().totalAmount(100.0).dateBill(null).build();

		assertThrows(DataIntegrityViolationException.class, () -> {
			billRepository.save(bill1);
		});
	}

	@Test
	@Transactional
	void deleteById_withValidBill_returnListOfBill(){

		Bill lastBill = billRepository.findFirstByOrderByIdDesc().orElse(Bill.builder().id(0L).build());
		Bill bill1 = Bill.builder().totalAmount(100.0).dateBill(new Date()).build();
		Bill bill2 = Bill.builder().totalAmount(100.0).dateBill(new Date()).build();

		billRepository.save(bill1);
		billRepository.save(bill2);

		List<Bill> billsBefore = billRepository.findAll();

		billRepository.deleteById(lastBill.getId()+2);

		List<Bill> actualBills = billRepository.findAllByTotalAmount(100.0);

		assertEquals(billsBefore.size()-1, actualBills.size());

	}

	@Test
	@Transactional
	void deleteById_withInvalidId_throwException(){

		Bill lastBill = billRepository.findFirstByOrderByIdDesc().orElse(Bill.builder().id(0L).build());
		Bill bill1 = Bill.builder().totalAmount(100.0).dateBill(new Date()).build();
		Bill bill2 = Bill.builder().totalAmount(100.0).dateBill(new Date()).build();

		billRepository.save(bill1);
		billRepository.save(bill2);

		assertDoesNotThrow(() -> {
			billRepository.deleteById(lastBill.getId() + 3);
		});

	}
}
