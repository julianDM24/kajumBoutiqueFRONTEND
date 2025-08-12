package com.kajumboutique.kajumboutique.service;

import com.kajumboutique.kajumboutique.model.EntradaMercancia;
import com.kajumboutique.kajumboutique.repository.EntradaMercanciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntradaMercanciaService {

    @Autowired
    private EntradaMercanciaRepository entradaMercanciaRepository;

    // Guardar o actualizar una entrada
    public EntradaMercancia guardarEntrada(EntradaMercancia entrada) {
        return entradaMercanciaRepository.save(entrada);
    }

    // Listar todas las entradas
    public List<EntradaMercancia> listarEntradas() {
        return entradaMercanciaRepository.findAll();
    }

    // Buscar por ID
    public Optional<EntradaMercancia> buscarPorId(int id) {
        return entradaMercanciaRepository.findById(id);
    }

    // Eliminar por ID
    public void eliminarEntrada(int id) {
        entradaMercanciaRepository.deleteById(id);
    }
}
