package com.example.orders.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Collections;
import java.util.List;

@Entity
@Data
public class Product {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String productId;

    @Column
    private String name;

    @Column
    private Float price;

    @ManyToOne
    @JoinColumn(name="pedidosID")
    private Pedidos peds;

    @ManyToMany(mappedBy = "prods")
    private List<Bill> bills = Collections.emptyList();
}
