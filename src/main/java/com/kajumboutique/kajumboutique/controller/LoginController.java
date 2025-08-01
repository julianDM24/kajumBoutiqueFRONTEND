package com.kajumboutique.kajumboutique.controller;

import com.kajumboutique.kajumboutique.model.Usuario;
import com.kajumboutique.kajumboutique.repository.UsuarioRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/login")
    public String mostrarFormularioLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam Long id_usuario,
                        @RequestParam String contrasena,
                        HttpSession session,
                        Model model) {

        Usuario user = usuarioRepository.findById(id_usuario).orElse(null);

        if (user != null && user.getContrasena().equals(contrasena)) {
            session.setAttribute("usuario", user);
            return "redirect:/menu";
        } else {
            model.addAttribute("error", "Credenciales incorrectas");
            return "login";
        }
    }

    @GetMapping("/menu")
    public String mostrarMenu(HttpSession session, Model model) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario == null) {
            return "redirect:/login";
        }

        model.addAttribute("usuario", usuario); // envía al modelo
        return "menu";
    }
 

    @GetMapping("/usuario/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}

