package com.alerta_sp.mvc_user.repository;

import com.alerta_sp.mvc_user.model.FavoritoUsuario;
import com.alerta_sp.mvc_user.model.FavoritoUsuarioId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavoritoUsuarioRepository extends JpaRepository<FavoritoUsuario, FavoritoUsuarioId> {
    List<FavoritoUsuario> findByUsuarioId(Long idUsuario);
    boolean existsById(FavoritoUsuarioId id);
    void deleteById(FavoritoUsuarioId id);
}
