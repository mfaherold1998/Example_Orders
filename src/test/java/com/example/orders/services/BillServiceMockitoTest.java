package com.example.orders.services;

import com.example.orders.dto.BillDto;
import com.example.orders.entity.Bill;
import com.example.orders.exceptions.NotFoundException;
import com.example.orders.mappers.BillMapper;
import com.example.orders.repository.BillRepository;
import com.example.orders.service.BillService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BillServiceMockitoTest {

    @Mock
    private BillRepository billRepository;

    @Spy
    private BillMapper billMapper = Mappers.getMapper(BillMapper.class);

    @InjectMocks
    private BillService billService;

    private NotFoundException createNotFoundException(Long id){
        return new NotFoundException("Not Found Exception","There is not Bill with id "+id);
    }

    @Test
    void getAllBill_withValidBillDTO_returnListOfBillDto() {

        Bill bill1 = Bill.builder().id(1L).dateBill(new Date()).totalAmount(100.0).build();
        Bill bill2 = Bill.builder().id(2L).dateBill(new Date()).totalAmount(100.0).build();
        List<Bill> bills = new ArrayList<>();
        bills.add(bill1);
        bills.add(bill2);

        Mockito.when(billRepository.findAll()).thenReturn(bills);

        List<BillDto> response = billService.getAllBills();

        assertEquals(2, response.size());

    }

    @Test
    void getAllBill_withNone_returnEmptyListOfBillDto() {

        List<Bill> bills = new ArrayList<>();

        Mockito.when(billRepository.findAll()).thenReturn(bills);

        List<BillDto> response = billService.getAllBills();

        assertEquals(0, response.size());
    }

    @Test
    void saveBill_withValidBillDTO_returnSavedBillDto() {

        Bill bill = Bill.builder().id(1L).dateBill(new Date()).totalAmount(100.0).build();
        BillDto billDto = BillDto.builder().id(1L).dateBill(new Date()).totalAmount(100.0).build();

        Mockito.when(billRepository.saveAndFlush(ArgumentMatchers.any(Bill.class))).thenReturn(bill);

        BillDto savedDto = billService.saveBill(billDto);

        assertNotNull(savedDto);
    }

    @Test
    void saveBill_withInvalidBillDTO_throwException() {

        BillDto billDto1 = BillDto.builder().dateBill(new Date()).totalAmount(null).build();

        Mockito.when(billRepository.saveAndFlush(ArgumentMatchers.any(Bill.class))).thenThrow(new RuntimeException());

        assertThrows(RuntimeException.class, () -> {
            billService.saveBill(billDto1);
        });
    }

    @Test
    void saveBill_withTwoValidDto_returnBillDtoCorrectId() {

        Date date = new Date();
        Bill bill1 = Bill.builder().id(1L).dateBill(date).totalAmount(100.0).build();
        BillDto billDto1 = BillDto.builder().id(1L).dateBill(date).totalAmount(100.0).build();

        Mockito.when(billRepository.saveAndFlush(ArgumentMatchers.any(Bill.class))).thenReturn(bill1);

        BillDto savedBill = billService.saveBill(billDto1);

        assertEquals(1L, savedBill.getId());
    }

    @Test
    void getBillById_withValidBillDto_returnBillDto(){

        Long id = 1L;
        Bill bill1 = Bill.builder().id(id).dateBill(new Date()).totalAmount(100.0).build();
        Optional<Bill> optBill = Optional.of(bill1);
        BillDto billDto1 = BillDto.builder().id(id).dateBill(new Date()).totalAmount(100.0).build();

        Mockito.when(billRepository.findById(id)).thenReturn(optBill);

        BillDto bill = billService.getBillById(id);

        assertNotNull(bill);
        assertEquals(1L, bill.getId());

    }

    @Test
    void getBillById_withNotValidId_returnException(){

        Long id = 1L;

        Mockito.when(billRepository.findById(id)).thenThrow(createNotFoundException(id));

        assertThrows(NotFoundException.class, () -> {
            billService.getBillById(id);
        });
    }

    @Test
    void deleteBill_withValidBillDto_returnListOfBillDto(){

        Long id = 1L;

        Mockito.when(billRepository.existsById(id)).thenReturn(true);
        Mockito.doNothing().when(billRepository).deleteById(id);

        billService.deleteBill(id);

        Mockito.verify(billRepository, Mockito.times(1)).deleteById(id);

    }

    @Test
    void deleteBill_withNotValidId_returnException(){

        Long id = 1L;

        assertThrows(NotFoundException.class, () -> {
            billService.deleteBill(id);
        });
    }

    @Test
    void existById_withExistingBillDto_returnTrue(){

        Long id = 1L;

        Mockito.when(billRepository.existsById(id)).thenReturn(true);

        assertTrue(billService.existsById(id));
    }

    @Test
    void updateBill_withValidBillDto_returnUpdatedBillDto(){

        Long id = 1L;
        Bill bill1 = Bill.builder().dateBill(new Date()).totalAmount(200.0).id(id).build();
        BillDto billDto1 = BillDto.builder().dateBill(new Date()).totalAmount(200.0).id(id).build();

        Mockito.when(billRepository.saveAndFlush(ArgumentMatchers.any(Bill.class))).thenReturn(bill1);
        Mockito.when(billRepository.existsById(id)).thenReturn(true);

        BillDto updatedBill = billService.updateBill(billDto1);

        assertEquals(id, updatedBill.getId());
        assertEquals(200, updatedBill.getTotalAmount());

    }

    @Test
    void updateBill_withNotValidBillDto_returnException(){

        Long id = 1L;
        BillDto billDto1 = BillDto.builder().dateBill(new Date()).totalAmount(200.0).id(id).build();

        Mockito.when(billRepository.existsById(id)).thenReturn(false);

        assertThrows(NotFoundException.class, () -> {
            billService.updateBill(billDto1);
        });
    }

}
