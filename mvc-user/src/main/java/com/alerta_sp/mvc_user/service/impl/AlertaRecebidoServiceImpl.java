package com.alerta_sp.mvc_user.service.impl;

import com.alerta_sp.mvc_user.dto.AlertaRecebidoDTO;
import com.alerta_sp.mvc_user.model.AlertaRecebido;
import com.alerta_sp.mvc_user.model.AlertaRecebidoId;
import com.alerta_sp.mvc_user.repository.AlertaRecebidoRepository;
import com.alerta_sp.mvc_user.service.AlertaRecebidoService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlertaRecebidoServiceImpl implements AlertaRecebidoService {

    private final AlertaRecebidoRepository repository;

    public AlertaRecebidoServiceImpl(AlertaRecebidoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<AlertaRecebidoDTO> listarAlertasRecebidos(Long idUsuario) {
        return repository.findByUsuarioId(idUsuario).stream().map(alerta -> {
            var dto = new AlertaRecebidoDTO();
            dto.setIdUsuario(alerta.getUsuario().getId());
            dto.setIdAlerta(alerta.getAlerta().getId());
            dto.setTipo(alerta.getAlerta().getTipo().name());
            dto.setMensagem(alerta.getAlerta().getMensagem());
            dto.setStatus(alerta.getAlerta().getStatus());
            dto.setDataHora(alerta.getAlerta().getDataHora());
            dto.setVisto(alerta.getVisto());
            dto.setCorrego(alerta.getAlerta().getCorrego().getNome());
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public void marcarComoVisto(Long idUsuario, Long idAlerta) {
        AlertaRecebidoId id = new AlertaRecebidoId(idUsuario, idAlerta);
        repository.findById(id).ifPresent(alerta -> {
            alerta.setVisto("S");
            repository.save(alerta);
        });
    }

    @Override
    public List<AlertaRecebidoDTO> listarUltimosAlertasRecebidos(Long idUsuario, int limite) {
        List<AlertaRecebido> ultimos = repository
                .findTop5ById_IdUsuarioOrderByAlerta_DataHoraDesc(idUsuario);

        return ultimos.stream().map(alerta -> {
            var dto = new AlertaRecebidoDTO();
            dto.setIdUsuario(alerta.getId().getIdUsuario());
            dto.setIdAlerta(alerta.getId().getIdAlerta());
            dto.setTipo(alerta.getAlerta().getTipo().name());
            dto.setMensagem(alerta.getAlerta().getMensagem());
            dto.setStatus(alerta.getAlerta().getStatus());
            dto.setDataHora(alerta.getAlerta().getDataHora());
            dto.setVisto(alerta.getVisto());
            dto.setCorrego(alerta.getAlerta().getCorrego().getNome());
            return dto;
        }).collect(Collectors.toList());
    }
}
