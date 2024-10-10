package com.example.orders.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.orders.entity.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill,Long> {
	
	Optional<Bill> findFirstByOrderByIdDesc();
}
