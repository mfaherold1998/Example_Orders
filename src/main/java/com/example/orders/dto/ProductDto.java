package com.example.orders.dto;

import com.example.orders.entity.Bill;
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
public class ProductDto {

    private String productId;
    private String name;
    private Float price;
    private Pedidos peds;
    private List<Bill> bills = Collections.emptyList();
}
