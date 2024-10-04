package com.example.orders.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Collections;
import java.util.List;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, precision = 10)
    private Double price;

    @ManyToOne
    @JoinColumn(name="ordine_id")
    private Ordine ords;

    @ManyToMany(mappedBy = "prods")
    private List<Bill> bills = Collections.emptyList();
}
