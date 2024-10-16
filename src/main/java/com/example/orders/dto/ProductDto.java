package com.example.orders.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.Collections;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {

    //@NotNull
    private Long id;
    @NotNull
    @Size(min=1,max=100)
    private String name;
    @NotNull
    @Min(0)
    @Digits(integer = 10, fraction = 2)
    private Double price;
    @Valid
    @NotNull
    private List<OrdineDto> ords = Collections.emptyList();

}
