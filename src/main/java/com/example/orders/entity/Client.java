package com.example.orders.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;
import java.util.Collections;

@Entity
@Data
public class Client {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String clientId;

    @Column
    @NotEmpty(message = "Name cannot be empty...")
    @NotNull
    private String name;

    @Column
    @Email
    private String email;

    @OneToMany(mappedBy = "cli")
    private List<Pedidos> peds = Collections.emptyList();
}
