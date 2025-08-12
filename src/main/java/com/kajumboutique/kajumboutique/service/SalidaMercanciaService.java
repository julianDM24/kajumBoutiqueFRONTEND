package com.kajumboutique.kajumboutique.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kajumboutique.kajumboutique.model.SalidaMercancia;
import com.kajumboutique.kajumboutique.repository.SalidaMercanciaRepository;

@Service
public class SalidaMercanciaService {

    private final SalidaMercanciaRepository salidaMercanciaRepository;

    public SalidaMercanciaService(SalidaMercanciaRepository salidaMercanciaRepository) {
        this.salidaMercanciaRepository = salidaMercanciaRepository;
    }

    // Obtener todas las salidas
    public List<SalidaMercancia> obtenerTodasLasSalidas() {
        return salidaMercanciaRepository.findAll();
    }

    // Obtener salida por ID
    public Optional<SalidaMercancia> obtenerSalidaPorId(int id) {
        return salidaMercanciaRepository.findById(id);
    }

    // Guardar nueva salida
    public SalidaMercancia guardarSalida(SalidaMercancia salida) {
        return salidaMercanciaRepository.save(salida);
    }

    // Actualizar salida existente
    public SalidaMercancia actualizarSalida(SalidaMercancia salida) {
        if (salidaMercanciaRepository.existsById(salida.getId_salida())) {
            return salidaMercanciaRepository.save(salida);
        }
        throw new RuntimeException("Salida de mercancia no encontrada con id " + salida.getId_salida());
    }

    // Eliminar salida por ID
    public void eliminarSalida(int id) {
        salidaMercanciaRepository.deleteById(id);
    }
}
