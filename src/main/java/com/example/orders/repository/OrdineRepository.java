package com.example.orders.repository;

import com.example.orders.entity.Ordine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdineRepository extends JpaRepository<Ordine,Long> {
}
