package com.example.orders.repository;

import com.example.orders.entity.Ordine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrdineRepository extends JpaRepository<Ordine,Long> {
    Optional<Ordine> findFirstByOrderByIdDesc();
    List<Ordine> findAllByTotal(Double number);
    List<Ordine> findAllByDateOrdine(Date date);
}
