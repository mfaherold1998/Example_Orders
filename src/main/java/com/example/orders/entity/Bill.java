package com.example.orders.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Collections;
import java.util.List;

@Entity
@Data
public class Bill {

    //@Column //redundante si no se especifica ningun parametro
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long billId;

    private String date;

    private Float totalAmount;

    @OneToOne
    @JoinColumn(name="pedidoID")
    private Pedidos ped;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="bill_product", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "bill_id"))
    private List<Product> prods = Collections.emptyList();
}
