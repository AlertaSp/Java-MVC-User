package com.alerta_sp.mvc_user.controller;

import com.alerta_sp.mvc_user.dto.UsuarioDTO;
import com.alerta_sp.mvc_user.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/usuario")
public class UsuarioAuthController {

    private final UsuarioService usuarioService;

    public UsuarioAuthController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/login")
    public String exibirLogin(@RequestParam(required = false) String error, Model model) {
        if (error != null) {
            model.addAttribute("erro", "E-mail ou senha inválidos.");
        }
        return "index"; // página de login
    }

    @GetMapping("/registro")
    public String exibirRegistro(Model model) {
        model.addAttribute("usuario", new UsuarioDTO());
        return "cadastro";
    }

    @PostMapping("/registro")
    public String processarCadastro(@ModelAttribute("usuario") @Valid UsuarioDTO usuario,
                                    BindingResult result,
                                    RedirectAttributes redirectAttributes) {

        if (usuarioService.emailJaCadastrado(usuario.getEmail())) {
            result.rejectValue("email", "error.usuario", "E-mail já cadastrado");
        }

        if (result.hasErrors()) {
            return "cadastro";
        }

        usuario.setTelefone(usuario.getTelefone().replaceAll("[^\\d]", ""));
        usuarioService.cadastrarUsuario(usuario);
        redirectAttributes.addFlashAttribute("sucesso", true);

        return "redirect:/usuario/registro";
    }
}
