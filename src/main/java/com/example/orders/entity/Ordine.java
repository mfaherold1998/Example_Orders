package com.example.orders.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
public class Ordine {

    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private Date date;

    @Column(nullable = false, precision = 10)
    private Double total;

    /*@OneToOne(mappedBy = "ord", optional = false)
    private Bill billId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "client_id")
    private Client cli;

    @OneToMany(mappedBy = "ords")
    private List<Product> products;*/
}
