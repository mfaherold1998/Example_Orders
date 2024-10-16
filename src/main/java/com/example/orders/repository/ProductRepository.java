package com.example.orders.repository;
import com.example.orders.entity.Ordine;
import com.example.orders.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    Optional<Product> findFirstByOrderByIdDesc();
    List<Product> findAllByPrice(Double price);
    List<Product> findAllByName(String name);
}
