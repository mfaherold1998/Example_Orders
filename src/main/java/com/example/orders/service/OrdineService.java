package com.example.orders.service;

import com.example.orders.dto.OrdineDto;
import com.example.orders.exceptions.NotFoundException;
import com.example.orders.mappers.OrdineMapper;
import com.example.orders.repository.OrdineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrdineService {

    private final OrdineRepository ordineRepository;
    private final OrdineMapper ordineMapper;

    public List<OrdineDto> getAllOrdini(){
        return  ordineRepository.findAll().stream().map(ordineMapper::toDto).toList();
    }

    public OrdineDto getOrdineById(Long id){
        return  ordineMapper.toDto(ordineRepository.findById(id).orElseThrow(() -> new NotFoundException("Not Found Exception","Order with id "+id+" does not exists")));
    }

    public OrdineDto saveOrdine(OrdineDto ordineDto){
        return ordineMapper.toDto(ordineRepository.saveAndFlush(ordineMapper.toEntity(ordineDto)));
    }

    public void deleteOrdine(Long id){
        ordineRepository.deleteById(id);
    }

    public boolean existsById(Long id){return ordineRepository.existsById(id);}

    public OrdineDto updateOrdine (OrdineDto ordineDto){
        return ordineMapper.toDto(ordineRepository.saveAndFlush(ordineMapper.toEntity(ordineDto)));
    }
}
