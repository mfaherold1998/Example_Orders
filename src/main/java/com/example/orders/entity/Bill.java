package com.example.orders.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Bill {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String billId;

    @Column
    private String date;

    @Column
    private Float totalAmount;
}
