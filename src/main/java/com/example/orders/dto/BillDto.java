package com.example.orders.dto;

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

    private Long billId;
    private String date;
    private Float totalAmount;
    private PedidosDtoMini ped;
    private List<ProductDtoMini> prods = Collections.emptyList();

}
