package com.example.orders.service;

import com.example.orders.dto.BillDto;
import com.example.orders.entity.Bill;
import com.example.orders.mappers.BillMapper;
import com.example.orders.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillService {

    @Autowired
    private BillRepository billRepository;
    @Autowired
    private BillMapper billMapper;

    public List<BillDto> getAllBills(){
        return billRepository.findAll().stream().map((bill)->billMapper.toDto(bill)).toList();
    }

    public Bill getBillById(String id){
        return billRepository.findById(id).orElse(null);
    }//TODO return the DTO object para save, delete, update

    public void saveBill (Bill bill){
        billRepository.save(bill);//return BillDTo
    }

    public void deleteBill(String id){
        billRepository.deleteById(id);
    }

    public boolean existsById(String id){
        return billRepository.existsById(id);
    }

    public void updateBill (Bill bill){
        billRepository.save(bill);
    }
}
