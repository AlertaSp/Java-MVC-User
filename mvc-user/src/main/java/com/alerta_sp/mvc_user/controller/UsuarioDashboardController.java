package com.alerta_sp.mvc_user.controller;

import com.alerta_sp.mvc_user.dto.AlertaRecebidoDTO;
import com.alerta_sp.mvc_user.model.Usuario;
import com.alerta_sp.mvc_user.service.AlertaRecebidoService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UsuarioDashboardController {

    private final AlertaRecebidoService alertaRecebidoService;

    public UsuarioDashboardController(AlertaRecebidoService alertaRecebidoService) {
        this.alertaRecebidoService = alertaRecebidoService;
    }

    @GetMapping("/usuario/dashboard")
    public String exibirDashboard(@AuthenticationPrincipal Usuario usuario, Model model) {
        if (usuario == null) {
            return "redirect:/usuario/login";
        }

        Long idUsuario = usuario.getId();
        List<AlertaRecebidoDTO> ultimosAlertas = alertaRecebidoService.listarUltimosAlertasRecebidos(idUsuario, 5);
        model.addAttribute("ultimosAlertas", ultimosAlertas);
        return "dashboard";
    }

    @GetMapping("/usuario/logout")
    public String logout() {
        return "redirect:/usuario/login";
    }
}
