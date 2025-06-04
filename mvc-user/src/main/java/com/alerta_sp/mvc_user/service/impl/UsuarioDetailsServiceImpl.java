package com.alerta_sp.mvc_user.service.impl;

import com.alerta_sp.mvc_user.model.Usuario;
import com.alerta_sp.mvc_user.repository.UsuarioRepository;
import com.alerta_sp.mvc_user.service.UsuarioDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("usuarioDetailsService")
public class UsuarioDetailsServiceImpl implements UsuarioDetailsService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioDetailsServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado com e-mail: " + email));
    }
}
