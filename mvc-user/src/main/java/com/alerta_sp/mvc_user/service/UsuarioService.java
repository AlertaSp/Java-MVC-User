package com.alerta_sp.mvc_user.service;

import com.alerta_sp.mvc_user.dto.UsuarioDTO;

public interface UsuarioService {
    void cadastrarUsuario(UsuarioDTO dto);

    boolean emailJaCadastrado(String email); // Novo método
}
