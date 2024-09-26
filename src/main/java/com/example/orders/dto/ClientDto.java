package com.example.orders.dto;

import com.example.orders.entity.Pedidos;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collections;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ClientDto {

    private Long clientId;
    private String name;
    private String email;
    private List<PedidosDtoMini> peds = Collections.emptyList();
}
