package com.kajumboutique.kajumboutique.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kajumboutique.kajumboutique.model.Prendas;
import com.kajumboutique.kajumboutique.repository.PrendasRepository;

@Service
public class PrendasService {

    private final PrendasRepository prendasRepository;

    public PrendasService(PrendasRepository prendasRepository) {
        this.prendasRepository = prendasRepository;
    }

    // Obtener todas las prendas
    public List<Prendas> obtenerTodasLasPrendas() {
        return prendasRepository.findAll();
    }

    // Obtener prenda por ID
    public Optional<Prendas> obtenerPrendaPorId(int id) {
        return prendasRepository.findById(id);
    }

    // Guardar nueva prenda
    public Prendas guardarPrenda(Prendas prenda) {
        return prendasRepository.save(prenda);
    }

    // Actualizar prenda existente
    public Prendas actualizarPrenda(Prendas prenda) {
        if (prendasRepository.existsById(prenda.getId_prenda())) {
            return prendasRepository.save(prenda);
        }
        throw new RuntimeException("Prenda no encontrada con id " + prenda.getId_prenda());
    }

    // Eliminar prenda por ID
    public void eliminarPrenda(int id) {
        prendasRepository.deleteById(id);
    }
}
