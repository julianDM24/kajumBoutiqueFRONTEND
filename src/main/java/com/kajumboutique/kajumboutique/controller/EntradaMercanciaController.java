package com.kajumboutique.kajumboutique.controller;

import com.kajumboutique.kajumboutique.model.EntradaMercancia;
import com.kajumboutique.kajumboutique.repository.EntradaMercanciaRepository;
import com.kajumboutique.kajumboutique.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/entrada")
public class EntradaMercanciaController {

    @Autowired
    private EntradaMercanciaRepository entradaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/formulario")
    public String mostrarFormularioEntrada(Model model) {
        model.addAttribute("entrada", new EntradaMercancia());
        model.addAttribute("usuarios", usuarioRepository.findAll());
        return "formulario_entrada";
    }

    @PostMapping("/guardar")
    public String guardarEntrada(@ModelAttribute EntradaMercancia entrada) {
        entradaRepository.save(entrada);
        return "redirect:/entrada/formulario";
    }
    
    @GetMapping("/listar")
    public String listarEntradas(Model model) {
        model.addAttribute("entradas", entradaRepository.findAll());
        return "listar_entradas";
    }

}
