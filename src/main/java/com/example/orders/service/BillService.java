package com.example.orders.service;

import com.example.orders.dto.BillDto;
import com.example.orders.exceptions.InvalidException;
import com.example.orders.exceptions.NotFoundException;
import com.example.orders.mappers.BillMapper;
import com.example.orders.repository.BillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor//Injecta todos los atributos final en el constructor
public class BillService {

    private final BillRepository billRepository;
    private final BillMapper billMapper;

    public List<BillDto> getAllBills(){
        return billRepository.findAll().stream().map(billMapper::toDto).toList();
    }

    public BillDto getBillById(Long id){
        return billMapper.toDto(billRepository.findById(id).orElseThrow(() -> new NotFoundException("Not Found Exception","Bill with id "+id+" does not exists")));
    }

    public BillDto saveBill (BillDto billDto){
        return  billMapper.toDto(billRepository.saveAndFlush(billMapper.toEntity(billDto)));
    }

    public boolean deleteBill(Long id){
        billRepository.deleteById(id);
        return true;
    }

    public boolean existsById(Long id){
        return billRepository.existsById(id);
    }

    public BillDto updateBill (BillDto billDto){
        if(billRepository.existsById(billDto.getId())){
            return billMapper.toDto(billRepository.saveAndFlush(billMapper.toEntity(billDto)));
        }
        else{
            throw new InvalidException("Invalid Exception","Bill with id "+billDto.getId()+" does not exists, you cannot update it");
        }


    }
}
