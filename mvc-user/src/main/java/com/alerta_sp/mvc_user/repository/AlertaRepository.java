package com.alerta_sp.mvc_user.repository;

import com.alerta_sp.mvc_user.model.Alerta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AlertaRepository extends JpaRepository<Alerta, Long> {

    List<Alerta> findByCorregoId(Long idCorrego);

    List<Alerta> findByStatus(String status);

    @Query("""
        SELECT a FROM Alerta a
        WHERE a.corrego.id IN (
            SELECT c.id FROM Usuario u
            JOIN u.corregosFavoritos c
            WHERE u.id = :usuarioId
        )
        ORDER BY a.dataHora DESC
    """)
    List<Alerta> findAlertasFavoritosByUsuarioId(@Param("usuarioId") Long usuarioId);
}
