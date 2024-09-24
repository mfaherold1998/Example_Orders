package com.example.orders.service;

import com.example.orders.entity.Bill;
import com.example.orders.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillService {

    @Autowired
    private BillRepository billRepository;

    public List<Bill> getAllBills(){
        return billRepository.findAll();
    }

    public Bill getBillById(String id){
        return billRepository.findById(id).orElse(null);
    }

    public void saveBill (Bill bill){
        billRepository.save(bill);
    }

    public void deleteBill(String id){
        billRepository.deleteById(id);
    }

    public boolean existsById(String id){
        return billRepository.existsById(id);
    }
}
