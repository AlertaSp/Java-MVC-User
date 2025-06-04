package com.alerta_sp.mvc_user.controller;

import com.alerta_sp.mvc_user.model.AlertaRecebido;
import com.alerta_sp.mvc_user.model.Usuario;
import com.alerta_sp.mvc_user.repository.AlertaRecebidoRepository;
import com.alerta_sp.mvc_user.repository.UsuarioRepository;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/usuario/alertas")
public class UsuarioAlertaController {

    private final AlertaRecebidoRepository alertaRecebidoRepository;
    private final UsuarioRepository usuarioRepository;

    public UsuarioAlertaController(AlertaRecebidoRepository alertaRecebidoRepository,
                                   UsuarioRepository usuarioRepository) {
        this.alertaRecebidoRepository = alertaRecebidoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping
    public String listarAlertasRecebidos(Model model, @AuthenticationPrincipal Usuario usuario) {
        List<AlertaRecebido> recebidos = alertaRecebidoRepository.findByUsuarioId(usuario.getId());
        model.addAttribute("alertas", recebidos.stream().map(AlertaRecebido::getAlerta).toList());
        return "alertas";
    }
}
