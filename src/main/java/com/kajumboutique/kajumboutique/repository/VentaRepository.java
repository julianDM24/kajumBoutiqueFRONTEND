package com.kajumboutique.kajumboutique.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.kajumboutique.kajumboutique.model.Venta;

public interface VentaRepository extends JpaRepository<Venta, Integer> {
    List<Venta> findByFacturaIsNull();

}
