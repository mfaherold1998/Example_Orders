package com.example.orders.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrdineDto {

    private Long id;
    @PastOrPresent
    private Date dateOrdine;
    @NotNull
    @Min(0)
    @Digits(integer = 10, fraction = 2)
    private Double total;
    @Valid
    //@NotNull
    private ClientDto cli;
    @Size(min=0)
    @NotNull
    @Valid
    private List<ProductDto> prods = Collections.emptyList();

}
