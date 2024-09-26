package com.example.orders.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PedidosDto {

    private Long pedidosID;
    private String date;
    private Float total;
    private BillDtoMini billId;
    private ClientDtoMini cli;
    private List<ProductDtoMini> products;
}
