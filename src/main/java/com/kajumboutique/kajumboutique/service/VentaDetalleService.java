package com.kajumboutique.kajumboutique.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kajumboutique.kajumboutique.model.VentaDetalle;
import com.kajumboutique.kajumboutique.repository.VentaDetalleRepository;

@Service
public class VentaDetalleService {

    private final VentaDetalleRepository ventaDetalleRepository;

    public VentaDetalleService(VentaDetalleRepository ventaDetalleRepository) {
        this.ventaDetalleRepository = ventaDetalleRepository;
    }

    // Obtener todos los detalles de venta
    public List<VentaDetalle> obtenerTodosLosDetalles() {
        return ventaDetalleRepository.findAll();
    }

    // Obtener detalle por ID
    public Optional<VentaDetalle> obtenerDetallePorId(int id) {
        return ventaDetalleRepository.findById(id);
    }

    // Guardar nuevo detalle de venta
    public VentaDetalle guardarDetalle(VentaDetalle detalle) {
        return ventaDetalleRepository.save(detalle);
    }

    // Actualizar detalle existente
    public VentaDetalle actualizarDetalle(VentaDetalle detalle) {
        if (ventaDetalleRepository.existsById(detalle.getId_venta_detalle())) {
            return ventaDetalleRepository.save(detalle);
        }
        throw new RuntimeException("Detalle de venta no encontrado con id " + detalle.getId_venta_detalle());
    }

    // Eliminar detalle por ID
    public void eliminarDetalle(int id) {
        ventaDetalleRepository.deleteById(id);
    }
}
