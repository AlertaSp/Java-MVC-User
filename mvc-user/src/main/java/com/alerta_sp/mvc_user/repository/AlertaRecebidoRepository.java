package com.alerta_sp.mvc_user.repository;

import com.alerta_sp.mvc_user.model.AlertaRecebido;
import com.alerta_sp.mvc_user.model.AlertaRecebidoId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlertaRecebidoRepository extends JpaRepository<AlertaRecebido, AlertaRecebidoId> {
    List<AlertaRecebido> findByUsuarioId(Long idUsuario);
    List<AlertaRecebido> findByUsuarioIdAndVisto(Long idUsuario, String visto);
    List<AlertaRecebido> findTop5ByUsuarioIdOrderByAlerta_DataHoraDesc(Long usuarioId);

    // Busca os 5 alertas mais recentes de um usuário usando o campo do ID composto
    List<AlertaRecebido> findTop5ById_IdUsuarioOrderByAlerta_DataHoraDesc(Long idUsuario);
}
