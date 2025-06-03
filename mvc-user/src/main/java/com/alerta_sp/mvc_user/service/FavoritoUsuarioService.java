package com.alerta_sp.mvc_user.service;

import java.util.List;

public interface FavoritoUsuarioService {
    List<Long> listarIdsCorregosFavoritos(Long idUsuario);
    void adicionarFavorito(Long idUsuario, Long idCorrego);
    void removerFavorito(Long idUsuario, Long idCorrego);
    boolean isFavorito(Long idUsuario, Long idCorrego);
}
