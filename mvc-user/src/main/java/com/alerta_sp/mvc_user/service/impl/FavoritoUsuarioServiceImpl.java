package com.alerta_sp.mvc_user.service.impl;

import com.alerta_sp.mvc_user.model.FavoritoUsuario;
import com.alerta_sp.mvc_user.model.FavoritoUsuarioId;
import com.alerta_sp.mvc_user.model.Usuario;
import com.alerta_sp.mvc_user.model.Corrego;
import com.alerta_sp.mvc_user.repository.FavoritoUsuarioRepository;
import com.alerta_sp.mvc_user.repository.UsuarioRepository;
import com.alerta_sp.mvc_user.repository.CorregoRepository;
import com.alerta_sp.mvc_user.service.FavoritoUsuarioService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FavoritoUsuarioServiceImpl implements FavoritoUsuarioService {

    private final FavoritoUsuarioRepository favoritoRepo;
    private final UsuarioRepository usuarioRepo;
    private final CorregoRepository corregoRepo;

    public FavoritoUsuarioServiceImpl(FavoritoUsuarioRepository favoritoRepo,
                                      UsuarioRepository usuarioRepo,
                                      CorregoRepository corregoRepo) {
        this.favoritoRepo = favoritoRepo;
        this.usuarioRepo = usuarioRepo;
        this.corregoRepo = corregoRepo;
    }

    @Override
    public List<Long> listarIdsCorregosFavoritos(Long idUsuario) {
        return favoritoRepo.findByUsuarioId(idUsuario)
                .stream()
                .map(fav -> fav.getCorrego().getId())
                .collect(Collectors.toList());
    }

    @Override
    public void adicionarFavorito(Long idUsuario, Long idCorrego) {
        FavoritoUsuarioId id = new FavoritoUsuarioId(idUsuario, idCorrego);
        if (!favoritoRepo.existsById(id)) {
            FavoritoUsuario favorito = new FavoritoUsuario();
            favorito.setId(id);
            favorito.setUsuario(usuarioRepo.findById(idUsuario).orElseThrow());
            favorito.setCorrego(corregoRepo.findById(idCorrego).orElseThrow());
            favoritoRepo.save(favorito);
        }
    }

    @Override
    public void removerFavorito(Long idUsuario, Long idCorrego) {
        FavoritoUsuarioId id = new FavoritoUsuarioId(idUsuario, idCorrego);
        favoritoRepo.deleteById(id);
    }

    @Override
    public boolean isFavorito(Long idUsuario, Long idCorrego) {
        return favoritoRepo.existsById(new FavoritoUsuarioId(idUsuario, idCorrego));
    }
}
