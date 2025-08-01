package com.kajumboutique.kajumboutique.restcontroller;

import com.kajumboutique.kajumboutique.model.SalidaMercancia;
import com.kajumboutique.kajumboutique.repository.SalidaMercanciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/salidas")
@CrossOrigin(origins = "http://localhost:3000")
public class SalidaRestController {

    @Autowired
    private SalidaMercanciaRepository salidaRepository;

    @GetMapping
    public List<SalidaMercancia> listarSalidas() {
        return salidaRepository.findAll();
    }

    @PostMapping
    public SalidaMercancia crearSalida(@RequestBody SalidaMercancia salida) {
        return salidaRepository.save(salida);
    }

    @GetMapping("/{id}")
    public SalidaMercancia obtenerSalida(@PathVariable int id) {
        return salidaRepository.findById(id).orElse(null);
    }
}
