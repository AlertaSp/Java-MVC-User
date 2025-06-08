package com.alerta_sp.mvc_user.repository;

import com.alerta_sp.mvc_user.model.Usuario;
import com.alerta_sp.mvc_user.model.FavoritoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);

    @Query("""
        SELECT DISTINCT u FROM Usuario u
        LEFT JOIN u.corregosFavoritos c
        LEFT JOIN FavoritoUsuario fu ON fu.usuario = u
        WHERE c.id = :idCorrego OR fu.corrego.id = :idCorrego
    """)
    java.util.List<Usuario> findUsuariosByCorrego(@Param("idCorrego") Long idCorrego);
}
