package com.kajumboutique.kajumboutique.restcontroller;

import com.kajumboutique.kajumboutique.model.EntradaMercancia;
import com.kajumboutique.kajumboutique.model.Usuario;
import com.kajumboutique.kajumboutique.repository.EntradaMercanciaRepository;
import com.kajumboutique.kajumboutique.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entradas")
public class EntradaMercanciaRestController {

    @Autowired
    private EntradaMercanciaRepository entradaRepository;
    
    @Autowired
    private UsuarioRepository usuarioRepository;


    @GetMapping
    public List<EntradaMercancia> listar() {
        return entradaRepository.findAll();
    }

  
    @PostMapping
    public EntradaMercancia guardar(@RequestBody EntradaMercancia entrada) {
        if (entrada.getUsuario() != null && entrada.getUsuario().getIdUsuario() != 0) {
            Usuario usuario = usuarioRepository.findById(entrada.getUsuario().getIdUsuario()).orElse(null);
            entrada.setUsuario(usuario);
        }
        return entradaRepository.save(entrada);
    }

   

    @GetMapping("/{id}")
    public EntradaMercancia obtener(@PathVariable int id) {
        return entradaRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public EntradaMercancia actualizar(@PathVariable int id, @RequestBody EntradaMercancia nuevaEntrada) {
        return entradaRepository.findById(id).map(entrada -> {
            entrada.setCodigo_prenda(nuevaEntrada.getCodigo_prenda());
            entrada.setCantidad_entrada(nuevaEntrada.getCantidad_entrada());
            entrada.setFecha_entrada(nuevaEntrada.getFecha_entrada());
            return entradaRepository.save(entrada);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        entradaRepository.deleteById(id);
    }
}

