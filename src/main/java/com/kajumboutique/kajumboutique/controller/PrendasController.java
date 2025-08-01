package com.kajumboutique.kajumboutique.controller;

import com.kajumboutique.kajumboutique.model.Prendas;
import com.kajumboutique.kajumboutique.repository.PrendasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/prendas")
public class PrendasController {

    @Autowired
    private PrendasRepository prendasRepository;

    @GetMapping("/formulario")
    public String mostrarFormulario(Model model) {
        model.addAttribute("prenda", new Prendas());
        return "formulario_prenda";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Prendas prenda) {
        prendasRepository.save(prenda);
        return "redirect:/prendas/formulario";
    }

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("prendas", prendasRepository.findAll());
        return "listar_prendas";
    }
}
