package com.example.orders.repository;
import com.example.orders.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {

    List<Client> findAllByName (String name);

    @Query(value = "select c from client c where c.name = ?1", nativeQuery = true)
    List<Client> customFindAllByName (String name);

    Optional<Client> findFirstByOrderByIdDesc();
}
