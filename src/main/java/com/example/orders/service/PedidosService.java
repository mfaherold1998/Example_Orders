package com.example.orders.service;

import com.example.orders.dto.PedidosDto;
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
    }//DONE

    public PedidosDto getPedidoById(String id){
        return pedidosMapper.toDto(pedidosRepository.findById(id).orElse(null));
    }//DONE

    public PedidosDto savePedido (PedidosDto pedidosDto){
        return pedidosMapper.toDto(pedidosRepository.saveAndFlush(pedidosMapper.toEntity(pedidosDto)));
    }//DONE

    public PedidosDto deletePedido(String id){
        PedidosDto pedDto = getPedidoById(id);
        pedidosRepository.deleteById(id);
        return pedDto;
    }//DONE

    public boolean existsById(String id){
        return pedidosRepository.existsById(id);
    }

    public PedidosDto updatePedido (PedidosDto pedidosDto){
        return pedidosMapper.toDto(pedidosRepository.saveAndFlush(pedidosMapper.toEntity(pedidosDto)));
    }//DONE
}
