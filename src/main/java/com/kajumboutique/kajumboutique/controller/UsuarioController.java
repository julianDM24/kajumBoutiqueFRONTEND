package com.kajumboutique.kajumboutique.controller;
import com.kajumboutique.kajumboutique.model.Usuario;
import com.kajumboutique.kajumboutique.repository.UsuarioRepository;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/usuario")
@SessionAttributes("usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Mostrar formulario para crear un nuevo usuario
    @GetMapping("/formulario")
    public String mostrarFormulario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "formulario_usuario";
    }

    // Guardar usuario (POST)
    @PostMapping("/guardar")
    public String guardarUsuario(@ModelAttribute Usuario usuario) {
        usuarioRepository.save(usuario);
        return "redirect:/usuario/listar"; 
    }

    // Listar usuarios
    @GetMapping("/listar")
    public String listarUsuarios(Model model) {
        List<Usuario> usuarios = usuarioRepository.findAll();
        model.addAttribute("usuarios", usuarios);
        return "listar_usuarios"; 
    }
    
    @GetMapping("/buscar")
    public String buscar(@RequestParam("idUsuario") Long idUsuario, Model model) {
        Usuario usuario = usuarioRepository.findById(idUsuario).orElse(null);
        model.addAttribute("usuario", usuario);
        return "detalle_usuario"; // Crea este HTML si no lo tienes
    }
    
    @PostMapping("/login")
    public String login(@RequestParam("id_usuario") Long idUsuario,
                        @RequestParam("contrasena") String contrasena,
                        Model model) {
        Usuario usuario = usuarioRepository.findByIdUsuarioAndContrasena(idUsuario, contrasena);

        if (usuario != null) {
            model.addAttribute("usuario", usuario); // guarda en sesión
            return "redirect:/menu";
        } else {
            return "redirect:/login?error=true";
        }
    }


    @GetMapping("/menu")
    public String mostrarMenu(HttpSession session, Model model) {
        String id_usuario = (String) session.getAttribute("usuarioLogueado");
        if(id_usuario != null) {
        	model.addAttribute("id_usuario", new Usuario());
        	return"menu";
        }
        else{
        	return "redirect:/login";
        }
        
        }


 }


