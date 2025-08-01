package com.kajumboutique.kajumboutique.repository;

import com.kajumboutique.kajumboutique.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
