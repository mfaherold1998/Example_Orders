package com.example.orders.service;

import com.example.orders.dto.PedidosDto;
import com.example.orders.exceptions.NotFoundException;
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
    }

    public PedidosDto getPedidoById(Long id){
        return pedidosMapper.toDto(pedidosRepository.findById(id).orElseThrow(() -> new NotFoundException("Not Found Exception","Order with id "+id+" does not exists")));
    }

    public PedidosDto savePedido (PedidosDto pedidosDto){
        return pedidosMapper.toDto(pedidosRepository.saveAndFlush(pedidosMapper.toEntity(pedidosDto)));
    }

    public PedidosDto deletePedido(Long id){
        PedidosDto pedDto = getPedidoById(id);
        pedidosRepository.deleteById(id);
        return pedDto;
    }

    public boolean existsById(Long id){
        return pedidosRepository.existsById(id);
    }

    public PedidosDto updatePedido (PedidosDto pedidosDto){
        return pedidosMapper.toDto(pedidosRepository.saveAndFlush(pedidosMapper.toEntity(pedidosDto)));
    }
}
