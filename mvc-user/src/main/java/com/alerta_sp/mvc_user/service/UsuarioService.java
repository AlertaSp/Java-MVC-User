package com.alerta_sp.mvc_user.service;

import com.alerta_sp.mvc_user.model.Usuario;
import com.alerta_sp.mvc_user.dto.UsuarioDTO;

public interface UsuarioService {
    void cadastrarUsuario(UsuarioDTO usuario);
    boolean emailJaCadastrado(String email);
    Usuario autenticar(String email, String senha);
}
