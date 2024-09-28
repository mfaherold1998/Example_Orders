package com.example.orders.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
public class Pedidos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pedidosID;

    @Column(nullable = false)
    private Date date;

    @Column(nullable = false, precision = 10)
    private Double total;

    @OneToOne(mappedBy = "ped", optional = false)
    private Bill billId;

    @ManyToOne(optional = false)
    @JoinColumn(name="client_id")
    private Client cli;

    @OneToMany(mappedBy = "peds")
    private List<Product> products;
}
