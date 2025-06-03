package com.alerta_sp.mvc_user.service.impl;

import com.alerta_sp.mvc_user.dto.CorregoDTO;
import com.alerta_sp.mvc_user.model.Corrego;
import com.alerta_sp.mvc_user.repository.CorregoRepository;
import com.alerta_sp.mvc_user.service.CorregoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CorregoServiceImpl implements CorregoService {

    private final CorregoRepository corregoRepository;

    public CorregoServiceImpl(CorregoRepository corregoRepository) {
        this.corregoRepository = corregoRepository;
    }

    @Override
    public List<CorregoDTO> listarTodos() {
        List<Corrego> corregos = corregoRepository.findAll();
        return corregos.stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public CorregoDTO buscarPorId(Long id) {
        Corrego corrego = corregoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Córrego não encontrado"));
        return toDTO(corrego);
    }

    private CorregoDTO toDTO(Corrego entity) {
        CorregoDTO dto = new CorregoDTO();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setLatitude(entity.getLatitude());
        dto.setLongitude(entity.getLongitude());
        dto.setNivelAlerta(entity.getNivelAlerta());
        dto.setNivelCritico(entity.getNivelCritico());
        return dto;
    }
}
