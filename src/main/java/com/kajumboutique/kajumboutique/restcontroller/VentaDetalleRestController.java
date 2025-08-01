package com.kajumboutique.kajumboutique.restcontroller;

import com.kajumboutique.kajumboutique.model.VentaDetalle;
import com.kajumboutique.kajumboutique.repository.VentaDetalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ventadetalles")
@CrossOrigin(origins = "http://localhost:3000")
public class VentaDetalleRestController {

    @Autowired
    private VentaDetalleRepository ventaDetalleRepository;

    @GetMapping
    public List<VentaDetalle> listarVentaDetalles() {
        return ventaDetalleRepository.findAll();
    }

    @PostMapping
    public VentaDetalle crearVentaDetalle(@RequestBody VentaDetalle ventaDetalle) {
        return ventaDetalleRepository.save(ventaDetalle);
    }

    @GetMapping("/{id}")
    public VentaDetalle obtenerPorId(@PathVariable int id) {
        return ventaDetalleRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public VentaDetalle actualizarVentaDetalle(@PathVariable int id, @RequestBody VentaDetalle ventaDetalle) {
        VentaDetalle existente = ventaDetalleRepository.findById(id).orElse(null);
        if (existente != null) {
            existente.setVenta(ventaDetalle.getVenta());
            existente.setPrendas(ventaDetalle.getPrendas());
            existente.setCantidad(ventaDetalle.getCantidad());
            return ventaDetalleRepository.save(existente);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void eliminarVentaDetalle(@PathVariable int id) {
        ventaDetalleRepository.deleteById(id);
    }
}
