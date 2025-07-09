package com.kajumboutique.kajumboutique.controller;

import com.kajumboutique.kajumboutique.model.SalidaMercancia;
import com.kajumboutique.kajumboutique.repository.SalidaMercanciaRepository;
import com.kajumboutique.kajumboutique.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/salida")
public class SalidaMercanciaController {

    @Autowired
    private SalidaMercanciaRepository salidaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/formulario")
    public String mostrarFormularioSalida(Model model) {
        model.addAttribute("salida", new SalidaMercancia());
        model.addAttribute("usuarios", usuarioRepository.findAll());
        return "formulario_salida";
    }

    @PostMapping("/guardar")
    public String guardarSalida(@ModelAttribute SalidaMercancia salida) {
        salidaRepository.save(salida);
        return "redirect:/salida/formulario";
    }
    
    @GetMapping("/listar")
    public String listarSalidas(Model model) {
        model.addAttribute("salidas", salidaRepository.findAll());
        return "listar_salidas";
    }

}
