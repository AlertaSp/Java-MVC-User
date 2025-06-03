package com.alerta_sp.mvc_user.service.impl;

import com.alerta_sp.mvc_user.dto.AlertaDTO;
import com.alerta_sp.mvc_user.model.Alerta;
import com.alerta_sp.mvc_user.repository.AlertaRepository;
import com.alerta_sp.mvc_user.service.AlertaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlertaServiceImpl implements AlertaService {

    private final AlertaRepository alertaRepository;

    public AlertaServiceImpl(AlertaRepository alertaRepository) {
        this.alertaRepository = alertaRepository;
    }

    private AlertaDTO toDTO(Alerta alerta) {
        AlertaDTO dto = new AlertaDTO();
        dto.setId(alerta.getId());
        dto.setIdCorrego(alerta.getCorrego().getId());
        dto.setTipo(alerta.getTipo());
        dto.setMensagem(alerta.getMensagem());
        dto.setStatus(alerta.getStatus());
        dto.setDataHora(alerta.getDataHora());
        return dto;
    }

    @Override
    public List<AlertaDTO> listarAlertasPorCorrego(Long idCorrego) {
        return alertaRepository.findByCorregoId(idCorrego)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<AlertaDTO> listarAlertasAtivos() {
        return alertaRepository.findByStatus("ATIVO")
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}
