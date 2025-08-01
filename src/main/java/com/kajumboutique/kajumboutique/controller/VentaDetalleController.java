package com.kajumboutique.kajumboutique.controller;

import com.kajumboutique.kajumboutique.model.Prendas;
import com.kajumboutique.kajumboutique.model.Venta;
import com.kajumboutique.kajumboutique.model.VentaDetalle;
import com.kajumboutique.kajumboutique.repository.PrendasRepository;
import com.kajumboutique.kajumboutique.repository.VentaDetalleRepository;
import com.kajumboutique.kajumboutique.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/venta-detalle")
public class VentaDetalleController {

    @Autowired
    private VentaDetalleRepository ventaDetalleRepository;

    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private PrendasRepository prendasRepository;

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("ventaDetalles", ventaDetalleRepository.findAll());
        return "listar_ventas_detalles";
    }

    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("ventas", ventaRepository.findAll());
        model.addAttribute("prendas", prendasRepository.findAll());
        return "formulario_venta_detalle";
    }

    @PostMapping("/guardar")
    public String guardarVentaDetalle(@RequestParam("ventaId") int ventaId,
                                      @RequestParam("prendasId") int prendasId,
                                      @RequestParam("cantidad") int cantidad) {

        VentaDetalle detalle = new VentaDetalle();
        Venta venta = ventaRepository.findById(ventaId).orElse(null);
        Prendas prendas = prendasRepository.findById(prendasId).orElse(null);

        detalle.setVenta(venta);
        detalle.setPrendas(prendas);
        detalle.setCantidad(cantidad);

        ventaDetalleRepository.save(detalle);
        return "redirect:/venta-detalle/listar";
    }
}

