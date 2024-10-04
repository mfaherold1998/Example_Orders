package com.example.orders.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.*;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BillDto {

    @NotNull
    private Long billId;
    @PastOrPresent
    private Date date;
    @NotNull
    @Min(0)
    @Digits(integer = 10, fraction = 2)
    private Double totalAmount;
    @Valid
    @NotNull
    private PedidosDtoMini ped;
    @Size(min=1)
    @NotNull
    @Valid
    private List<ProductDtoMini> prods;

}
