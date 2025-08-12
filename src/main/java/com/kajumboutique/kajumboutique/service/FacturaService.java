package com.kajumboutique.kajumboutique.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kajumboutique.kajumboutique.model.Factura;
import com.kajumboutique.kajumboutique.repository.FacturaRepository;

@Service
public class FacturaService {

    private final FacturaRepository facturaRepository;

    public FacturaService(FacturaRepository facturaRepository) {
        this.facturaRepository = facturaRepository;
    }

    // Obtener todas las facturas
    public List<Factura> obtenerTodasLasFacturas() {
        return facturaRepository.findAll();
    }

    // Buscar factura por ID
    public Optional<Factura> obtenerFacturaPorId(int id) {
        return facturaRepository.findById(id);
    }

    // Guardar nueva factura
    public Factura guardarFactura(Factura factura) {
        return facturaRepository.save(factura);
    }

    // Actualizar factura existente
    public Factura actualizarFactura(Factura factura) {
        if (facturaRepository.existsById(factura.getId_factura())) {
            return facturaRepository.save(factura);
        }
        throw new RuntimeException("Factura no encontrada con id " + factura.getId_factura());
    }

    // Eliminar factura por ID
    public void eliminarFactura(int id) {
        facturaRepository.deleteById(id);
    }
}
