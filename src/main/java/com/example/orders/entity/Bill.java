package com.example.orders.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Bill {

    //@Column //redundante si no se especifica ningun parametro
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long billId;

    @Column(nullable = false)
    private Date date;

    @Column(nullable = false, precision = 10)
    private Double totalAmount;

    @OneToOne
    @JoinColumn(name="pedidoID",nullable = true)
    private Pedidos ped;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="bill_product", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "bill_id"))
    private List<Product> prods = Collections.emptyList();
}
