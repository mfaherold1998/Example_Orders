package com.example.orders.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Ordine {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Date dateOrdine;

    @Column(nullable = false, precision = 10)
    private Double total;

    @ManyToOne(optional = false)
    @JoinColumn(name = "client_id")
    private Client cli;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "order_product", joinColumns = @JoinColumn(name = "ordine_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> prods = Collections.emptyList();
}
