package com.example.orders.service;

import com.example.orders.dto.BillDto;
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
    }//DONE

    public BillDto getBillById(String id){
        return billMapper.toDto(billRepository.findById(id).orElse(null));
    }//DONE

    public BillDto saveBill (BillDto billDto){
        billRepository.save(billMapper.toEntity(billDto));
        return billDto;
    }//DONE

    public BillDto deleteBill(String id){
        BillDto billDto= getBillById(id);
        billRepository.deleteById(id);
        return billDto;
    }//DONE

    public boolean existsById(String id){
        return billRepository.existsById(id);
    }

    public BillDto updateBill (BillDto billDto){
        billRepository.save(billMapper.toEntity(billDto));
        return billDto;
    }//DONE
}
