package com.example.orders.entity;

import jakarta.persistence.*;
import lombok.Data;

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
}
