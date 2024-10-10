package com.example.orders.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.orders.dto.BillDto;
import com.example.orders.entity.Bill;
import com.example.orders.mappers.BillMapper;
import com.example.orders.repository.BillRepository;
import com.example.orders.service.BillService;

import jakarta.transaction.Transactional;

@SpringBootTest
class BillServiceTest {

	@Autowired
	public BillRepository billRepository;
	@Autowired
	public BillMapper billMapper;
	@Autowired
	public BillService billService;

	private static BillDto billDto;

	@BeforeAll
	public static void setUp() {
		// OdineDto ordine = new OrdineDto();
		billDto = BillDto.builder().id(1L).dateBill(new Date()).totalAmount(100.0)
				// .ord(ordine)
				.build();
	}

	@Test
	void testBillDtoCreation() {
		assertNotNull(billDto);
		assertEquals(1L, billDto.getId());
		assertEquals(100.00, billDto.getTotalAmount());
	}

	@Test
	void saveBill_withValidDTO_returnBill() {
		BillDto billDto1 = BillDto.builder().dateBill(new Date()).totalAmount(100.0).build();
		BillDto savedDto = billService.saveBill(billDto1);
		assertNotNull(savedDto);
	}

	@Test
	@Transactional
	void testGetAllBills_none_ListOfBillDto() {
		Bill last = billRepository.findFirstByOrderByIdDesc().orElse(Bill.builder().id(0L).build());

		BillDto billDto1 = BillDto.builder().dateBill(new Date()).totalAmount(100.0).build();
		BillDto billDto2 = BillDto.builder().dateBill(new Date()).totalAmount(100.0).build();

		BillDto savedDto1 = billService.saveBill(billDto1);
		BillDto savedDto2 = billService.saveBill(billDto2);

		assertEquals(last.getId() + 1, savedDto1.getId());
		assertEquals(last.getId() + 2, savedDto2.getId());
	}

}
