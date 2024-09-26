package com.example.orders.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Pedidos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pedidosID;

    private String date;

    private Float total;

    @OneToOne(mappedBy = "ped")
    private Bill billId;

    @ManyToOne
    @JoinColumn(name="client_id")
    private Client cli;

    @OneToMany(mappedBy = "peds")
    private List<Product> products;
}
