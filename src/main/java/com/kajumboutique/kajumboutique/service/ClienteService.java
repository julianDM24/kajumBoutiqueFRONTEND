package com.kajumboutique.kajumboutique.service;

import com.kajumboutique.kajumboutique.model.Cliente;
import com.kajumboutique.kajumboutique.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    // Crear o actualizar cliente
    public Cliente guardarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // Listar todos los clientes
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    // Buscar cliente por ID
    public Optional<Cliente> buscarClientePorId(int id) {
        return clienteRepository.findById(id);
    }

    // Eliminar cliente por ID
    public void eliminarCliente(int id) {
        clienteRepository.deleteById(id);
    }
}
