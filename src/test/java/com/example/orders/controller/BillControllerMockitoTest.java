package com.example.orders.controller;

import com.example.orders.dto.BillDto;
import com.example.orders.entity.Bill;
import com.example.orders.exceptions.InvalidException;
import com.example.orders.exceptions.NotFoundException;
import com.example.orders.service.BillService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Disabled
@ExtendWith(MockitoExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BillControllerMockitoTest {

    @Mock
    private BillService billService;

    @InjectMocks
    private BillController billController;

    @Test
     void getAllBills_withValidDto_returnListOfBillDto() {
        BillDto bill1 = BillDto.builder().dateBill(new Date()).totalAmount(100.0).build();
        BillDto bill2 = BillDto.builder().dateBill(new Date()).totalAmount(200.0).build();
        List<BillDto> bills = new ArrayList<BillDto>();
        bills.add(bill1);
        bills.add(bill2);

        Mockito.when(billService.getAllBills()).thenReturn(bills);

        ResponseEntity<List<BillDto>> result = billController.getAllBills();

        assertEquals(2, result.getBody().size());
        assertEquals(100.0, result.getBody().get(0).getTotalAmount());
        assertEquals(200.0, result.getBody().get(1).getTotalAmount());
        assertEquals(200, result.getStatusCode().value());
    }

    @Test
     void getAllBills_withNone_returnEmptyList() {

        List<BillDto> bills = new ArrayList<BillDto>();

        Mockito.when(billService.getAllBills()).thenReturn(bills);

        ResponseEntity<List<BillDto>> result = billController.getAllBills();

        assertEquals(0, result.getBody().size());
        assertEquals(200, result.getStatusCode().value());
    }

    @Test
     void saveBill_withValidBillDto_returnBillDto(){
        BillDto bill = BillDto.builder().id(1L).dateBill(new Date()).totalAmount(100.0).build();

        Mockito.when(billService.saveBill(ArgumentMatchers.any(BillDto.class))).thenReturn(bill);

        ResponseEntity<BillDto> responseEntity = billController.saveBill(bill);

        assertEquals(201, responseEntity.getStatusCode().value());
        assertEquals(1L, responseEntity.getBody().getId());
    }

    @Test
     void saveBill_withTotalAmountNull_throwInvalidException(){
        BillDto bill = BillDto.builder().dateBill(new Date()).totalAmount(null).build();

        Mockito.when(billService.saveBill(ArgumentMatchers.any(BillDto.class))).thenThrow(new InvalidException("Invalid Exception", "Total amount cannot be null"));

        InvalidException exception = assertThrows(InvalidException.class, () -> {
            billController.saveBill(bill);
        });

        assertEquals("Total amount cannot be null", exception.getDetails());
    }

    @Test
    void getBillById_withValidBillDto_returnBillDto(){

        BillDto billDto = BillDto.builder().id(1L).dateBill(new Date()).totalAmount(200.0).build();

        Mockito.when(billService.getBillById(billDto.getId())).thenReturn(billDto);

        ResponseEntity<BillDto> responseEntity = billController.getBillById(billDto.getId());

        assertEquals(200, responseEntity.getStatusCode().value());
        assertEquals(1L, responseEntity.getBody().getId());
        assertEquals(200.0, responseEntity.getBody().getTotalAmount());
    }

    @Test
    void getBillById_withInvalidId_throwInvalidException(){

        Mockito.when(billService.getBillById(1L)).thenThrow(new NotFoundException("Not Found Exception", "There is not Bill with id 1"));

        NotFoundException exception = assertThrows(NotFoundException.class, () -> {
            billController.getBillById(1L);
        });

        assertEquals("There is not Bill with id 1", exception.getDetails());
    }

    @Test
    void deleteBill_withValidId_returnACCEPTED(){
        BillDto billDto = BillDto.builder().id(1L).dateBill(new Date()).totalAmount(200.0).build();

        Mockito.doNothing().when(billService).deleteBill(billDto.getId());

        HttpStatusCode status = (billController.deleteBill(billDto.getId())).getStatusCode();

        assertEquals(202, status.value());
    }

    @Test
    void deleteBill_withInvalidId_throwNotFoundException(){

        Mockito.doThrow(new NotFoundException("Not Found Exception", "There is not Bill with id 1")).when(billService).deleteBill(1L);

        NotFoundException exception = assertThrows(NotFoundException.class, () -> {
            billController.deleteBill(1L);
        });

        assertEquals("There is not Bill with id 1", exception.getDetails());
    }

    @Test
    void updateBill_withValidBillDto_returnBillDto(){

        BillDto billDto2 = BillDto.builder().id(1L).dateBill(new Date()).totalAmount(200.0).build();

        Mockito.when(billService.updateBill(billDto2)).thenReturn(billDto2);

        ResponseEntity<BillDto> responseEntity = billController.updateBill(billDto2);

        assertEquals(200, responseEntity.getStatusCode().value());
    }

    @Test
    void updateBill_withInvalidBillDto_throwNotFoundException(){

        BillDto billDto = BillDto.builder().id(1L).dateBill(new Date()).totalAmount(200.0).build();

        Mockito.when(billService.updateBill(billDto)).thenThrow(new NotFoundException("Not Found Exception","There is not Bill with id 1"));

        NotFoundException exception = assertThrows(NotFoundException.class, () -> {
            billController.updateBill(billDto);
        });

        assertEquals("There is not Bill with id 1", exception.getDetails());
    }
}
