package com.example.orders.controller;

import com.example.orders.dto.PedidosDto;
import com.example.orders.service.PedidosService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
@RequiredArgsConstructor
public class PedidosController {

    private final PedidosService pedidosService;

    @GetMapping("/findall")
    public List<PedidosDto> getAllPedidos(){
        return pedidosService.getAllPedidos();
    }//DONE

    @GetMapping("/getpedidos/{id}")
    public PedidosDto getPedidoById(@PathVariable Long id){
        return pedidosService.getPedidoById(id);
    }//DONE

    @PostMapping("/insert")
    public PedidosDto savePedido (@RequestBody @Valid PedidosDto pedidoDto){
        return pedidosService.savePedido(pedidoDto);
    }//DONE

    @DeleteMapping("/delete/{id}")
    public PedidosDto deletePedido(@PathVariable Long id){
        return pedidosService.deletePedido(id);
    }//DONE

    @PutMapping("/update/{id}")
    public PedidosDto updatePedido (@RequestBody @Valid PedidosDto pedidpDto){
        return pedidosService.updatePedido(pedidpDto);
    }//DONE
}
