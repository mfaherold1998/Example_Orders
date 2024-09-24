package com.example.orders.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Pedidos {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String pedidosID;

    @Column
    private String date;

    @Column
    private Float total;

    @OneToOne(mappedBy = "ped")
    private Bill billId;

    @ManyToOne
    @JoinColumn(name="client_id")
    private Client cli;

    @OneToMany(mappedBy = "peds")
    private List<Product> products;
}
