package com.example.orders.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Bill {

    //@Column //redundante si no se especifica ningun parametro
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Date dateBill;

    @Column(nullable = false, precision = 10)
    private Double totalAmount;

    @OneToOne
    @JoinColumn(name="ordine_id",nullable = true)
    private Ordine ord;

}
