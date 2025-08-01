package com.kajumboutique.kajumboutique.restcontroller;

import com.kajumboutique.kajumboutique.model.Prendas;
import com.kajumboutique.kajumboutique.repository.PrendasRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prendas")
@CrossOrigin(origins = "http://localhost:3000")
public class PrendaRestController {

    @Autowired
    private PrendasRepository prendasRepository;

    @GetMapping
    public List<Prendas> listarPrendas() {
        return prendasRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prendas> obtenerPrenda(@PathVariable int id) {
        return prendasRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Prendas crearPrenda(@RequestBody Prendas prenda) {
        return prendasRepository.save(prenda);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Prendas> actualizarPrenda(@PathVariable int id, @RequestBody Prendas detalles) {
        return prendasRepository.findById(id)
                .map(prenda -> {
                    prenda.setCodigo_prenda(detalles.getCodigo_prenda());
                    prenda.setNombre(detalles.getNombre());
                    prenda.setDescripcion(detalles.getDescripcion());
                    prenda.setTalla(detalles.getTalla());
                    prenda.setPrecio_por_mayor(detalles.getPrecio_por_mayor());
                    prenda.setPrecio_publico(detalles.getPrecio_publico());
                    prenda.setCantidad_disponible(detalles.getCantidad_disponible());
                    return ResponseEntity.ok(prendasRepository.save(prenda));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPrenda(@PathVariable int id) {
        if (!prendasRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        prendasRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

