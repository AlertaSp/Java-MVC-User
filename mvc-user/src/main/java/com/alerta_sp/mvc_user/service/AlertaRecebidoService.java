package com.alerta_sp.mvc_user.service;

import com.alerta_sp.mvc_user.dto.AlertaRecebidoDTO;

import java.util.List;

public interface AlertaRecebidoService {
    List<AlertaRecebidoDTO> listarAlertasRecebidos(Long idUsuario);
    void marcarComoVisto(Long idUsuario, Long idAlerta);
}
