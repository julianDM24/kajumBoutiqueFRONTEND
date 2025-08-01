package com.kajumboutique.kajumboutique.controller;

import com.kajumboutique.kajumboutique.model.Cliente;
import com.kajumboutique.kajumboutique.model.Factura;
import com.kajumboutique.kajumboutique.model.FormaPago;
import com.kajumboutique.kajumboutique.model.Usuario;
import com.kajumboutique.kajumboutique.repository.FacturaRepository;
import com.kajumboutique.kajumboutique.repository.ClienteRepository;
import com.kajumboutique.kajumboutique.repository.UsuarioRepository;
import com.kajumboutique.kajumboutique.repository.VentaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/factura")
public class FacturaController {

    @Autowired
    private FacturaRepository facturaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private VentaRepository ventaRepository;


    @GetMapping("/formulario")
    public String mostrarFormulario(Model model) {
        model.addAttribute("factura", new Factura());
        model.addAttribute("clientes", clienteRepository.findAll());
        model.addAttribute("usuarios", usuarioRepository.findAll());
        model.addAttribute("ventas", ventaRepository.findByFacturaIsNull());
        model.addAttribute("formasPago", FormaPago.values());
        return "formulario_factura";
    }

    @PostMapping("/guardar")
    public String guardarFactura(@ModelAttribute Factura factura) {
        Cliente cliente = clienteRepository.findById(factura.getCliente().getId_cliente()).orElse(null);
        Usuario usuario = usuarioRepository.findById(factura.getUsuario().getIdUsuario()).orElse(null);
        
        factura.setCliente(cliente);
        factura.setUsuario(usuario);

        ventaRepository.findById(factura.getVenta().getId_venta()).ifPresent(factura::setVenta);

        facturaRepository.save(factura);
        return "redirect:/factura/listar";
    }


    @GetMapping("/listar")
    public String listarFacturas(Model model) {
        List<Factura> facturas = facturaRepository.findAll();
        model.addAttribute("facturas", facturas);
        return "listar_facturas";
    }

    


}