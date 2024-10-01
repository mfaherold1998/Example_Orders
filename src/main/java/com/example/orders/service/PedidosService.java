package com.example.orders.service;

import com.example.orders.dto.PedidosDto;
import com.example.orders.exceptions.InvalidException;
import com.example.orders.mappers.PedidosMapper;
import com.example.orders.repository.PedidosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidosService {

    private final PedidosRepository pedidosRepository;
    private final PedidosMapper pedidosMapper;

    public List<PedidosDto> getAllPedidos(){
        return pedidosRepository.findAll().stream().map(pedidosMapper::toDto).toList();
    }//TODO

    public PedidosDto getPedidoById(Long id){
        if (id <= 0) {
            throw new InvalidException("Invalid Order Exception","Invalid order ID: " + id);
        }
        return pedidosMapper.toDto(pedidosRepository.findById(id).orElse(null));
    }//TODO

    public PedidosDto savePedido (PedidosDto pedidosDto){
        return pedidosMapper.toDto(pedidosRepository.saveAndFlush(pedidosMapper.toEntity(pedidosDto)));
    }//TODO

    public PedidosDto deletePedido(Long id){
        PedidosDto pedDto = getPedidoById(id);
        pedidosRepository.deleteById(id);
        return pedDto;
    }//TODO

    public boolean existsById(Long id){
        return pedidosRepository.existsById(id);
    }

    public PedidosDto updatePedido (PedidosDto pedidosDto){
        return pedidosMapper.toDto(pedidosRepository.saveAndFlush(pedidosMapper.toEntity(pedidosDto)));
    }//TODO
}
