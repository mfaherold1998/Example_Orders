package com.example.orders.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Collections;
import java.util.List;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;

    private String name;

    private Float price;

    @ManyToOne
    @JoinColumn(name="pedidosID")
    private Pedidos peds;

    @ManyToMany(mappedBy = "prods")
    private List<Bill> bills = Collections.emptyList();
}
