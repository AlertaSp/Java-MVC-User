package com.alerta_sp.mvc_user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsuarioDashboardController {

    @GetMapping("/usuario/dashboard")
    public String exibirDashboard() {
        return "dashboard";
    }

    @GetMapping("/usuario/logout")
    public String logout() {
        return "redirect:/usuario/login";
    }
}


