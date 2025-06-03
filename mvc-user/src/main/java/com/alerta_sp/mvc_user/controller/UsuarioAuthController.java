package com.alerta_sp.mvc_user.controller;

import com.alerta_sp.mvc_user.dto.UsuarioDTO;
import com.alerta_sp.mvc_user.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/usuario")
public class UsuarioAuthController {

    private final UsuarioService usuarioService;

    public UsuarioAuthController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/login")
    public String exibirLogin() {
        return "index"; // index.html é o login do usuário
    }

    @GetMapping("/registro")
    public String exibirRegistro(Model model) {
        model.addAttribute("usuario", new UsuarioDTO());
        return "cadastro"; // cadastro.html
    }

    @PostMapping("/registro")
    public String processarCadastro(@ModelAttribute("usuario") UsuarioDTO usuario,
                                    RedirectAttributes redirectAttributes) {

        if (usuarioService.emailJaCadastrado(usuario.getEmail())) {
            redirectAttributes.addFlashAttribute("erroEmail", true);
            return "redirect:/usuario/registro";
        }

        usuario.setTelefone(usuario.getTelefone().replaceAll("[^\\d]", "")); // Remove máscara
        usuarioService.cadastrarUsuario(usuario);
        redirectAttributes.addFlashAttribute("sucesso", true);

        return "redirect:/usuario/registro"; // para exibir a mensagem antes de redirecionar via JS
    }
}
