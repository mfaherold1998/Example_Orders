package com.example.orders.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.*;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BillDto {

    //@NotNull
    private Long id;
    @PastOrPresent
    private Date date;
    @NotNull
    @Min(0)
    @Digits(integer = 10, fraction = 2)
    private Double totalAmount;
    @Valid
    //@NotNull
    private OrdineDto ord;
}
