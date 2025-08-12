package com.kajumboutique.kajumboutique.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kajumboutique.kajumboutique.model.Venta;
import com.kajumboutique.kajumboutique.repository.VentaRepository;

@Service
public class VentaService {

    private final VentaRepository ventaRepository;

    public VentaService(VentaRepository ventaRepository) {
        this.ventaRepository = ventaRepository;
    }

    // Obtener todas las ventas
    public List<Venta> obtenerTodasLasVentas() {
        return ventaRepository.findAll();
    }

    // Obtener venta por ID
    public Optional<Venta> obtenerVentaPorId(int id) {
        return ventaRepository.findById(id);
    }

    // Guardar nueva venta
    public Venta guardarVenta(Venta venta) {
        return ventaRepository.save(venta);
    }

    // Actualizar venta existente
    public Venta actualizarVenta(Venta venta) {
        if (ventaRepository.existsById(venta.getId_venta())) {
            return ventaRepository.save(venta);
        }
        throw new RuntimeException("Venta no encontrada con id " + venta.getId_venta());
    }

    // Eliminar venta por ID
    public void eliminarVenta(int id) {
        ventaRepository.deleteById(id);
    }

    // Obtener ventas que no tienen factura asignada
    public List<Venta> obtenerVentasSinFactura() {
        return ventaRepository.findByFacturaIsNull();
    }
}
