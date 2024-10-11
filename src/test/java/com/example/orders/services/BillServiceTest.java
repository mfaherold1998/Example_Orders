package com.example.orders.services;

import com.example.orders.dto.BillDto;
import com.example.orders.entity.Bill;
import com.example.orders.exceptions.InvalidException;
import com.example.orders.exceptions.NotFoundException;
import com.example.orders.mappers.BillMapper;
import com.example.orders.repository.BillRepository;
import com.example.orders.service.BillService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.annotation.DirtiesContext;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class BillServiceTest {

    //@Mock
    @Autowired
    public BillRepository billRepository;
    //@Mock
    @Autowired
    public BillMapper billMapper;
    //@InjectMocks
    @Autowired
    public BillService billService;

    @Test
    void saveBill_withValidBillDTO_returnSavedBillDtoNotNull() {
        BillDto billDto1 = BillDto.builder().dateBill(new Date()).totalAmount(100.0).build();
        BillDto savedDto = billService.saveBill(billDto1);
        assertNotNull(savedDto);
    }

    @Test
    void saveBill_withNotValidBillDTO_returnException() {

        BillDto billDto1 = BillDto.builder().dateBill(new Date()).totalAmount(null).build();
        assertThrows(DataIntegrityViolationException.class, () -> {
            billService.saveBill(billDto1);
        });
    }

    @Test
    @Transactional
    void saveBills_withTwoValidDto_returnBillDtoCorrectId() {

        Bill last = billRepository.findFirstByOrderByIdDesc().orElse(Bill.builder().id(0L).build());

        BillDto billDto1 = BillDto.builder().dateBill(new Date()).totalAmount(100.0).build();
        BillDto billDto2 = BillDto.builder().dateBill(new Date()).totalAmount(100.0).build();

        BillDto savedDto1 = billService.saveBill(billDto1);
        BillDto savedDto2 = billService.saveBill(billDto2);

        assertEquals(last.getId() + 1, savedDto1.getId());
        assertEquals(last.getId() + 2, savedDto2.getId());
    }

    @Test
    void getAllBills_withTwoValidBills_returnListOfBills(){

        BillDto billDto1 = BillDto.builder().dateBill(new Date()).totalAmount(100.0).build();
        BillDto billDto2 = BillDto.builder().dateBill(new Date()).totalAmount(100.0).build();

        List<BillDto> beforeBills = billService.getAllBills();

        billService.saveBill(billDto1);
        billService.saveBill(billDto2);

        List<BillDto> actualBills = billService.getAllBills();

        assertEquals(beforeBills.size() + 2, actualBills.size());
    }

    @Test
    void getAllBills_withNone_returnEmptyListOfBills(){

        List<BillDto> bills = billService.getAllBills();

        assertEquals(0,bills.size());
    }

    @Test
    void getBillById_withValidBillDto_returnBillDto(){

        Bill last = billRepository.findFirstByOrderByIdDesc().orElse(Bill.builder().id(0L).build());

        BillDto billDto1 = BillDto.builder().dateBill(new Date()).totalAmount(100.0).build();
        BillDto billDto2 = BillDto.builder().dateBill(new Date()).totalAmount(100.0).build();

        billService.saveBill(billDto1);
        billService.saveBill(billDto2);

        BillDto savedBill1 = billService.getBillById(last.getId()+1);
        BillDto savedBill2 = billService.getBillById(last.getId()+2);

        assertNotNull(savedBill1);
        assertNotNull(savedBill2);
    }

    @Test
    void getBillById_withNotValidId_returnException(){

        Bill last = billRepository.findFirstByOrderByIdDesc().orElse(Bill.builder().id(0L).build());
        long notValidId = last.getId()+1;
        assertThrows(NotFoundException.class, () -> {
            billService.getBillById(notValidId);
        });
    }

    @Test
    void deleteBill_withValidBillDto_returnListOfBillDto(){

        Bill last = billRepository.findFirstByOrderByIdDesc().orElse(Bill.builder().id(0L).build());

        BillDto billDto1 = BillDto.builder().dateBill(new Date()).totalAmount(100.0).build();
        BillDto billDto2 = BillDto.builder().dateBill(new Date()).totalAmount(100.0).build();

        billService.saveBill(billDto1);
        billService.saveBill(billDto2);

        List<BillDto> beforeBills = billService.getAllBills();

        billService.deleteBill(last.getId() + 2);

        List<BillDto> actualBills = billService.getAllBills();

        assertEquals(beforeBills.size()-1, actualBills.size());

    }

    @Test
    void deleteBill_withNotValidId_returnException(){

        Bill last = billRepository.findFirstByOrderByIdDesc().orElse(Bill.builder().id(0L).build());

        BillDto billDto1 = BillDto.builder().dateBill(new Date()).totalAmount(100.0).build();
        BillDto billDto2 = BillDto.builder().dateBill(new Date()).totalAmount(100.0).build();

        billService.saveBill(billDto1);
        billService.saveBill(billDto2);

        long notValidId = last.getId()+3;

        assertThrows(NotFoundException.class, () -> {
            billService.deleteBill(notValidId);
        });
    }

    @Test
    void existById_withExistingBillDto_returnTrue(){

        Bill last = billRepository.findFirstByOrderByIdDesc().orElse(Bill.builder().id(0L).build());

        BillDto billDto1 = BillDto.builder().dateBill(new Date()).totalAmount(100.0).build();
        BillDto billDto2 = BillDto.builder().dateBill(new Date()).totalAmount(100.0).build();

        billService.saveBill(billDto1);
        billService.saveBill(billDto2);

        assertTrue(billService.existsById(last.getId()+1));
        assertTrue(billService.existsById(last.getId()+2));
        assertFalse(billService.existsById(last.getId()+3));
    }

    @Test
    void updateBill_withValidBillDto_returnUpdatedBillDto(){

        Bill last = billRepository.findFirstByOrderByIdDesc().orElse(Bill.builder().id(0L).build());

        BillDto billDto1 = BillDto.builder().dateBill(new Date()).totalAmount(100.0).build();
        BillDto billDto2 = BillDto.builder().dateBill(new Date()).totalAmount(100.0).build();

        billService.saveBill(billDto1);
        billService.saveBill(billDto2);

        List<BillDto> beforeBills = billService.getAllBills();

        BillDto originalBill = billService.getBillById(last.getId()+1);

        billService.updateBill(BillDto.builder().id(last.getId()+1).dateBill(new Date()).totalAmount(200.0).build());

        List<BillDto> afterBills = billService.getAllBills();

        BillDto updatedBill = billService.getBillById(last.getId()+1);

        assertEquals(beforeBills.size(),afterBills.size());
        assertEquals(originalBill.getId(),updatedBill.getId());

        assertEquals(100.0,originalBill.getTotalAmount());
        assertEquals(200.0,updatedBill.getTotalAmount());
    }

    @Test
    void updateBill_withNotValidBillDto_returnException(){

        Bill billDto0 = billRepository.findFirstByOrderByIdDesc().orElse(Bill.builder().id(0L).build());
        BillDto updatedBill = BillDto.builder().id(billDto0.getId()+1).dateBill(new Date()).totalAmount(200.0).build();

        assertThrows(InvalidException.class, () -> {
            billService.updateBill(updatedBill);
        });
    }
}
