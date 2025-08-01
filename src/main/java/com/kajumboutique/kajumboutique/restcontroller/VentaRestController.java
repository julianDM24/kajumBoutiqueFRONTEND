package com.kajumboutique.kajumboutique.restcontroller;

import com.kajumboutique.kajumboutique.model.Venta;
import com.kajumboutique.kajumboutique.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ventas")
@CrossOrigin(origins = "http://localhost:3000")
public class VentaRestController {

    @Autowired
    private VentaRepository ventaRepository;

    @GetMapping
    public List<Venta> obtenerVentas() {
        return ventaRepository.findAll();
    }

    @GetMapping("/sin-factura")
    public List<Venta> obtenerVentasSinFactura() {
        return ventaRepository.findByFacturaIsNull();
    }

    @PostMapping
    public Venta crearVenta(@RequestBody Venta venta) {
        return ventaRepository.save(venta);
    }

    @GetMapping("/{id}")
    public Venta obtenerVentaPorId(@PathVariable int id) {
        return ventaRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Venta actualizarVenta(@PathVariable int id, @RequestBody Venta ventaActualizada) {
        return ventaRepository.findById(id).map(venta -> {
            venta.setFecha_venta(ventaActualizada.getFecha_venta());
            venta.setTipoPago(ventaActualizada.getTipoPago());
            venta.setDiasCredito(ventaActualizada.getDiasCredito());
            venta.setTotal_venta(ventaActualizada.getTotal_venta());
            venta.setCliente(ventaActualizada.getCliente());
            venta.setUsuario(ventaActualizada.getUsuario());
            venta.setFactura(ventaActualizada.getFactura());
            return ventaRepository.save(venta);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void eliminarVenta(@PathVariable int id) {
        ventaRepository.deleteById(id);
    }
}
