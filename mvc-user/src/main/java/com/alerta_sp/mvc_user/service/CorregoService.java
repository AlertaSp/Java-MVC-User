package com.alerta_sp.mvc_user.service;

import com.alerta_sp.mvc_user.dto.CorregoDTO;

import java.util.List;

public interface CorregoService {
    List<CorregoDTO> listarTodos();
    CorregoDTO buscarPorId(Long id);
}
