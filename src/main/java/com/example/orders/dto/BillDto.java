package com.example.orders.dto;

import com.example.orders.entity.Pedidos;
import com.example.orders.entity.Product;
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
public class BillDto {

    private String billId;
    private String date;
    private Float totalAmount;
    private PedidosDto ped;//TODO just id name
    private List<ProductDto> prods = Collections.emptyList();

}
