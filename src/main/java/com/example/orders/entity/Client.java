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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;

    @Column(nullable = false, length = 100)
    private String name;

    @Column
    private String email;

    @OneToMany(mappedBy = "cli")
    private List<Pedidos> peds = Collections.emptyList();
}
