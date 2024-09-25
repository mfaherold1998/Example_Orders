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

    private String pedidosID;
    private String date;
    private Float total;
    private BillDto billId;
    private ClientDto cli;
    private List<ProductDto> products;
}
