package com.kajumboutique.kajumboutique.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kajumboutique.kajumboutique.model.Usuario;
import com.kajumboutique.kajumboutique.repository.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // Obtener todos los usuarios
    public List<Usuario> obtenerTodosLosUsuarios() {
        return usuarioRepository.findAll();
    }

    // Obtener usuario por ID
    public Optional<Usuario> obtenerUsuarioPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    // Guardar nuevo usuario
    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Actualizar usuario existente
    public Usuario actualizarUsuario(Usuario usuario) {
        if (usuarioRepository.existsById(usuario.getIdUsuario())) {
            return usuarioRepository.save(usuario);
        }
        throw new RuntimeException("Usuario no encontrado con id " + usuario.getIdUsuario());
    }

    // Eliminar usuario por ID
    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    // Método para buscar usuario por id y contraseña
    public Usuario buscarPorIdYContrasena(Long idUsuario, String contrasena) {
        return usuarioRepository.findByIdUsuarioAndContrasena(idUsuario, contrasena);
    }
}
