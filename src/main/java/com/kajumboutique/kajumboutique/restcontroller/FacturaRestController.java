package com.kajumboutique.kajumboutique.restcontroller;

import com.kajumboutique.kajumboutique.model.Factura;
import com.kajumboutique.kajumboutique.model.Cliente;
import com.kajumboutique.kajumboutique.model.Usuario;
import com.kajumboutique.kajumboutique.model.Venta;
import com.kajumboutique.kajumboutique.repository.FacturaRepository;
import com.kajumboutique.kajumboutique.repository.ClienteRepository;
import com.kajumboutique.kajumboutique.repository.UsuarioRepository;
import com.kajumboutique.kajumboutique.repository.VentaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/facturas")
@CrossOrigin(origins = "http://localhost:3000")
public class FacturaRestController {

    @Autowired
    private FacturaRepository facturaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private VentaRepository ventaRepository;

    @GetMapping
    public List<Factura> listar() {
        return facturaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Factura obtener(@PathVariable int id) {
        return facturaRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Factura guardar(@RequestBody Factura factura) {
        if (factura.getCliente() != null && factura.getCliente().getId_cliente() != 0) {
            Cliente cliente = clienteRepository.findById(factura.getCliente().getId_cliente()).orElse(null);
            factura.setCliente(cliente);
        }

        if (factura.getUsuario() != null && factura.getUsuario().getIdUsuario() != 0) {
            Usuario usuario = usuarioRepository.findById(factura.getUsuario().getIdUsuario()).orElse(null);
            factura.setUsuario(usuario);
        }

        if (factura.getVenta() != null && factura.getVenta().getId_venta() != 0) {
            Venta venta = ventaRepository.findById(factura.getVenta().getId_venta()).orElse(null);
            factura.setVenta(venta);
        }

        return facturaRepository.save(factura);
    }

    @PutMapping("/{id}")
    public Factura actualizar(@PathVariable int id, @RequestBody Factura nuevaFactura) {
        return facturaRepository.findById(id).map(factura -> {
            factura.setFecha_emision(nuevaFactura.getFecha_emision());
            factura.setForma_pago(nuevaFactura.getFormaPago());

            if (nuevaFactura.getCliente() != null) {
                Cliente cliente = clienteRepository.findById(nuevaFactura.getCliente().getId_cliente()).orElse(null);
                factura.setCliente(cliente);
            }

            if (nuevaFactura.getUsuario() != null) {
                Usuario usuario = usuarioRepository.findById(nuevaFactura.getUsuario().getIdUsuario()).orElse(null);
                factura.setUsuario(usuario);
            }

            if (nuevaFactura.getVenta() != null) {
                Venta venta = ventaRepository.findById(nuevaFactura.getVenta().getId_venta()).orElse(null);
                factura.setVenta(venta);
            }

            return facturaRepository.save(factura);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        facturaRepository.deleteById(id);
    }
}
