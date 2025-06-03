package com.alerta_sp.mvc_user.controller;

import com.alerta_sp.mvc_user.model.Usuario;
import com.alerta_sp.mvc_user.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/usuario/dados")
public class UsuarioDadosController {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioDadosController(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String exibirDados(Model model, Principal principal) {
        Usuario usuario = usuarioRepository.findByEmail(principal.getName())
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado"));

        model.addAttribute("usuario", usuario);
        return "meus_dados";
    }


    @PostMapping("/atualizar")
    public String atualizarDados(@RequestParam("email") String email,
                                 @RequestParam("telefone") String telefone,
                                 @RequestParam("senha") String senha,
                                 @RequestParam("confirmarSenha") String confirmarSenha,
                                 Model model,
                                 Principal principal) {

        Usuario usuario = usuarioRepository.findByEmail(principal.getName())
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado"));

        boolean alterado = false;

        if (!usuario.getTelefone().equals(telefone)) {
            usuario.setTelefone(telefone.replaceAll("[^\\d]", ""));
            alterado = true;
        }

        if (senha != null && !senha.isEmpty()) {
            if (!senha.equals(confirmarSenha)) {
                model.addAttribute("erro", "As senhas não coincidem");
                return "meus_dados";
            }
            usuario.setSenha(passwordEncoder.encode(senha));
            alterado = true;
        }

        if (alterado) {
            usuarioRepository.save(usuario);
            model.addAttribute("sucesso", true);
        }

        return "meus_dados";
    }

    @PostMapping("/cancelar")
    public String cancelarConta(Principal principal) {
        Usuario usuario = usuarioRepository.findByEmail(principal.getName())
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado"));

        usuarioRepository.delete(usuario);
        return "redirect:/usuario/login?cancelado";
    }
}
