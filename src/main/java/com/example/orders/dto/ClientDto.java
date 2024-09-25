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

    private String clientId;
    private String name;
    private String email;
    private List<Pedidos> peds = Collections.emptyList();
}
