package com.alerta_sp.mvc_user.config;

import com.alerta_sp.mvc_user.service.UsuarioDetailsService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UserSecurityConfig {

    private final UsuarioDetailsService usuarioDetailsService;

    public UserSecurityConfig(@Qualifier("usuarioDetailsService") UsuarioDetailsService usuarioDetailsService) {
        this.usuarioDetailsService = usuarioDetailsService;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .userDetailsService(usuarioDetailsService) // usa seu serviço personalizado
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/usuario/login", "/usuario/registro", "/css/**", "/js/**", "/images/**", "/lang/**").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/usuario/login")
                        .loginProcessingUrl("/usuario/login")
                        .defaultSuccessUrl("/usuario/dashboard", true)
                        .failureUrl("/usuario/login?error=true")
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/usuario/login?logout")
                        .permitAll()
                );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}




