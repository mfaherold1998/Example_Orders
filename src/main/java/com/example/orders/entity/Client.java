package com.example.orders.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Collections;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column
    private String email;

    @OneToMany(mappedBy = "cli")
    private List<Ordine> ords = Collections.emptyList();
}
