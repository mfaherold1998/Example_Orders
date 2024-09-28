package com.example.orders.dto;

import com.example.orders.entity.Pedidos;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
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
public class ClientDto {

    @NotNull
    private Long clientId;
    @NotNull
    @Pattern(regexp = "^[a-zA-Z\\s]+$")
    @Size(min=1,max=100)
    private String name;
    @Email
    private String email;
    @Size(min=1)
    @NotNull
    @Valid
    private List<PedidosDtoMini> peds;
}
