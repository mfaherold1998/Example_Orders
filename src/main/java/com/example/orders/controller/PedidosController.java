package com.example.orders.controller;

import com.example.orders.dto.PedidosDto;
import com.example.orders.service.PedidosService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidosController {

    @Autowired
    private PedidosService pedidosService;

    @GetMapping("/findall")
    public List<PedidosDto> getAllPedidos(){
        return pedidosService.getAllPedidos();
    }//DONE

    @GetMapping("/getpedidos/{id}")
    public PedidosDto getPedidoById(@RequestBody String id){
        return pedidosService.getPedidoById(id);
    }//DONE

    @PostMapping("/insert")
    public PedidosDto savePedido (@RequestBody @Valid PedidosDto pedidoDto){
        return pedidosService.savePedido(pedidoDto);
    }//DONE

    @DeleteMapping("/delete/{id}")
    public PedidosDto deletePedido(@PathVariable String id){
        return pedidosService.deletePedido(id);
    }//DONE

    @PutMapping("/update/{id}")
    public PedidosDto updatePedido (@RequestBody @Valid PedidosDto pedidpDto){
        return pedidosService.updatePedido(pedidpDto);
    }//DONE
}
