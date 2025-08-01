package com.kajumboutique.kajumboutique.controller;

import com.kajumboutique.kajumboutique.model.Cliente;
import com.kajumboutique.kajumboutique.model.Usuario;
import com.kajumboutique.kajumboutique.model.Venta;
import com.kajumboutique.kajumboutique.model.TipoPago;
import com.kajumboutique.kajumboutique.repository.ClienteRepository;
import com.kajumboutique.kajumboutique.repository.UsuarioRepository;
import com.kajumboutique.kajumboutique.repository.VentaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/venta")
public class VentaController {

    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/formulario")
    public String mostrarFormulario(Model model) {
        model.addAttribute("venta", new Venta());
        model.addAttribute("clientes", clienteRepository.findAll());
        model.addAttribute("usuarios", usuarioRepository.findAll());
        model.addAttribute("tiposPago", TipoPago.values());
        return "formulario_venta";
    }

    @PostMapping("/guardar")
    public String guardarVenta(@ModelAttribute Venta venta) {
        Cliente cliente = clienteRepository.findById(venta.getCliente().getId_cliente()).orElse(null);
        Usuario usuario = usuarioRepository.findById(venta.getUsuario().getIdUsuario()).orElse(null);

        venta.setCliente(cliente);
        venta.setUsuario(usuario);

        ventaRepository.save(venta);
        return "redirect:/venta/listar";
    }

    @GetMapping("/listar")
    public String listarVentas(Model model) {
        model.addAttribute("ventas", ventaRepository.findAll());
        return "listar_ventas";
    }
}