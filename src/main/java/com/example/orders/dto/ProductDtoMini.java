package com.example.orders.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDtoMini {

    @NotNull
    private Long id;
    @NotNull
    @Size(min=1,max=100)
    private String name;
    @NotNull
    @Min(0)
    @Digits(integer = 10, fraction = 2)
    private Double price;
}
