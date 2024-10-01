package com.example.orders.service;

import com.example.orders.dto.BillDto;
import com.example.orders.exceptions.InvalidException;
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
    }//TODO conexion a la base de datos

    public BillDto getBillById(Long id){
        if (id <= 0) {
            throw new InvalidException("Invalid Bill Exception","Invalid Bill ID: " + id);
        }
        return billMapper.toDto(billRepository.findById(id).orElse(null));
    }//TODO

    public BillDto saveBill (BillDto billDto){
        return  billMapper.toDto(billRepository.saveAndFlush(billMapper.toEntity(billDto)));
    }//TODO ya no se valida el DTO en el controller?

    public BillDto deleteBill(Long id){
        BillDto billDto= getBillById(id);
        billRepository.deleteById(id);
        return billDto;
    }//TODO controlar que el id es valido

    public boolean existsById(Long id){
        return billRepository.existsById(id);
    }

    public BillDto updateBill (BillDto billDto){
        billRepository.save(billMapper.toEntity(billDto));
        return billDto;
    }//TODO que el id exista y sea valido
}
