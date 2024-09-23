package com.example.orders.entity;

import jakarta.persistence.*;
import lombok.Data;

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
}
