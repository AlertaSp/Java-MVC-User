package com.alerta_sp.mvc_user.service;

import com.alerta_sp.mvc_user.dto.AlertaDTO;

import java.util.List;

public interface AlertaService {
    List<AlertaDTO> listarAlertasPorCorrego(Long idCorrego);
    List<AlertaDTO> listarAlertasAtivos();
}
