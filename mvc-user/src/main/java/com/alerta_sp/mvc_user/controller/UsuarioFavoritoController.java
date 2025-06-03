package com.alerta_sp.mvc_user.controller;

import com.alerta_sp.mvc_user.model.Corrego;
import com.alerta_sp.mvc_user.model.Usuario;
import com.alerta_sp.mvc_user.repository.CorregoRepository;
import com.alerta_sp.mvc_user.repository.UsuarioRepository;
import com.alerta_sp.mvc_user.service.FavoritoUsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/usuario/favoritos")
public class UsuarioFavoritoController {

    private final UsuarioRepository usuarioRepository;
    private final CorregoRepository corregoRepository;
    private final FavoritoUsuarioService favoritoService;

    public UsuarioFavoritoController(UsuarioRepository usuarioRepository,
                                     CorregoRepository corregoRepository,
                                     FavoritoUsuarioService favoritoService) {
        this.usuarioRepository = usuarioRepository;
        this.corregoRepository = corregoRepository;
        this.favoritoService = favoritoService;
    }

    @GetMapping
    public String exibirFormulario(Model model, Principal principal) {
        Usuario usuario = usuarioRepository.findByEmail(principal.getName())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        List<Corrego> corregos = corregoRepository.findAll();
        Set<Long> favoritos = favoritoService.listarIdsCorregosFavoritos(usuario.getId())
                .stream().collect(Collectors.toSet());

        corregos.forEach(c -> c.setFavorito(favoritos.contains(c.getId())));
        model.addAttribute("corregos", corregos);
        return "favoritos";
    }

    @PostMapping("/salvar")
    public String salvarFavoritos(@RequestParam(required = false, name = "favoritos") List<Long> idsFavoritos,
                                  Principal principal) {
        Usuario usuario = usuarioRepository.findByEmail(principal.getName())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        // Remove todos os favoritos anteriores
        List<Long> favoritosAtuais = favoritoService.listarIdsCorregosFavoritos(usuario.getId());
        for (Long id : favoritosAtuais) {
            favoritoService.removerFavorito(usuario.getId(), id);
        }

        // Adiciona os novos selecionados (se houver)
        if (idsFavoritos != null) {
            for (Long id : idsFavoritos) {
                favoritoService.adicionarFavorito(usuario.getId(), id);
            }
        }

        return "redirect:/usuario/dashboard";
    }
}
