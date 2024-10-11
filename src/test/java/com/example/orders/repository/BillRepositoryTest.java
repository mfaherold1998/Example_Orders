package com.example.orders.repository;

import com.example.orders.entity.Bill;
import com.example.orders.exceptions.NotFoundException;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.annotation.DirtiesContext;
import org.tukaani.xz.check.None;

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
        assertEquals(last.getId() + 1, (long) savedBill.getId());
	}

	@Test
	public void findAll_withTwoValidBill_returnListOfBill() {

		Bill bill1 = Bill.builder().totalAmount(100.0).dateBill(new Date()).build();
		Bill bill2 = Bill.builder().totalAmount(100.0).dateBill(new Date()).build();

		List<Bill> beforeBills = billRepository.findAll();

		billRepository.save(bill1);
		billRepository.save(bill2);

		List<Bill> bills = billRepository.findAll();

		assertEquals(beforeBills.size()+2 , bills.size());
	}

	@Test
	public void findAllByTotalAmount_withTwoValidBill_returnListOfBill() {

		Bill bill1 = Bill.builder().totalAmount(100.0).dateBill(new Date()).build();
		Bill bill2 = Bill.builder().totalAmount(100.0).dateBill(new Date()).build();

		List<Bill> beforeBills = billRepository.findAllByTotalAmount(100.0);

		billRepository.save(bill1);
		billRepository.save(bill2);

		List<Bill> bills = billRepository.findAllByTotalAmount(100.0);

		assertEquals(beforeBills.size()+2, bills.size());
	}

	@Test
	public void findAllByDateBill_withTwoValidBill_returnListOfBill() {

		Date date= new Date();

		Bill bill1 = Bill.builder().totalAmount(100.0).dateBill(date).build();
		Bill bill2 = Bill.builder().totalAmount(100.0).dateBill(date).build();

		List<Bill> beforeBills = billRepository.findAllByDateBill(date);

		billRepository.save(bill1);
		billRepository.save(bill2);

		List<Bill> bills = billRepository.findAllByDateBill(date);

		assertEquals(beforeBills.size()+2, bills.size());
	}

	@Test
	public void save_withBillWithInvalidTotalAmount_returnException(){

		Bill bill1 = Bill.builder().totalAmount(null).dateBill(new Date()).build();

		assertThrows(DataIntegrityViolationException.class, () -> {
			billRepository.save(bill1);
		});
	}

	@Test
	public void save_withBillWithInvalidDate_returnException(){

		Bill bill1 = Bill.builder().totalAmount(100.0).dateBill(null).build();

		assertThrows(DataIntegrityViolationException.class, () -> {
			billRepository.save(bill1);
		});
	}

	@Test
	public void deleteById_withValidBill_returnListOfBill(){

		Bill bill0 = billRepository.findFirstByOrderByIdDesc().orElse(Bill.builder().id(0L).build());
		Bill bill1 = Bill.builder().totalAmount(100.0).dateBill(new Date()).build();
		Bill bill2 = Bill.builder().totalAmount(100.0).dateBill(new Date()).build();

		billRepository.save(bill1);
		billRepository.save(bill2);

		List<Bill> beforeBills = billRepository.findAll();

		billRepository.deleteById(bill0.getId()+2);

		List<Bill> actualBills = billRepository.findAllByTotalAmount(100.0);

		assertEquals(beforeBills.size()-1, actualBills.size());

	}

	@Test
	public void deleteById_withNotValidId_returnException(){

		Bill bill0 = billRepository.findFirstByOrderByIdDesc().orElse(Bill.builder().id(0L).build());
		Bill bill1 = Bill.builder().totalAmount(100.0).dateBill(new Date()).build();
		Bill bill2 = Bill.builder().totalAmount(100.0).dateBill(new Date()).build();

		billRepository.save(bill1);
		billRepository.save(bill2);

		assertDoesNotThrow(() -> {
			billRepository.deleteById(bill0.getId() + 3);
		});

	}
}
