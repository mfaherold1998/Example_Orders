package com.example.orders.service;

import com.example.orders.entity.Pedidos;
import com.example.orders.repository.PedidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidosService {

    @Autowired
    private PedidosRepository pedidosRepository;

    public List<Pedidos> getAllPedidos(){
        return pedidosRepository.findAll();
    }

    public Pedidos getPedidoById(String id){
        return pedidosRepository.findById(id).orElse(null);
    }

    public void savePedido (Pedidos pedido){
        pedidosRepository.save(pedido);
    }

    public void deletePedido(String id){
        pedidosRepository.deleteById(id);
    }

    public boolean existsById(String id){
        return pedidosRepository.existsById(id);
    }
}
