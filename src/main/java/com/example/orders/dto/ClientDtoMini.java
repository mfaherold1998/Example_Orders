package com.example.orders.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ClientDtoMini {

    @NotNull
    private Long id;
    @NotNull
    @Pattern(regexp = "^[a-zA-Z\\s]+$")
    @Size(min=1,max=100)
    private String name;
}
