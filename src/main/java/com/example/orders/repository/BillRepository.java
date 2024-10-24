package com.example.orders.repository;
import com.example.orders.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface BillRepository extends JpaRepository<Bill,Long> {

	Optional<Bill> findFirstByOrderByIdDesc();

	List<Bill> findAllByTotalAmount(Double number);

	List<Bill> findAllByDateBill(Date dateBill);
}
