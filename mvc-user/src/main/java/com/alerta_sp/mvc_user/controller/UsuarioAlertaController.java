package com.alerta_sp.mvc_user.controller;

import org.springframework.ui.Model;
import com.alerta_sp.mvc_user.dto.AlertaRecebidoDTO;
import com.alerta_sp.mvc_user.model.Usuario;
import com.alerta_sp.mvc_user.repository.UsuarioRepository;
import com.alerta_sp.mvc_user.service.AlertaRecebidoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/usuario")
public class UsuarioAlertaController {

    private final AlertaRecebidoService alertaRecebidoService;
    private final UsuarioRepository usuarioRepository;

    public UsuarioAlertaController(AlertaRecebidoService alertaRecebidoService,
                                   UsuarioRepository usuarioRepository) {
        this.alertaRecebidoService = alertaRecebidoService;
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping("/alertas")
    public String exibirAlertasRecebidos(Model model, Principal principal) {
        // Obtém o usuário logado via e-mail (principal.getName())
        Usuario usuario = usuarioRepository.findByEmail(principal.getName())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        // Usa o método já implementado
        List<AlertaRecebidoDTO> alertas = alertaRecebidoService.listarAlertasRecebidos(usuario.getId());

        model.addAttribute("alertas", alertas);
        return "alertas";
    }
}
