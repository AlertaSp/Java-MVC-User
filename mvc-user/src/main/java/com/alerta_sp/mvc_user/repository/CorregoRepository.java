package com.alerta_sp.mvc_user.repository;

import com.alerta_sp.mvc_user.model.Corrego;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CorregoRepository extends JpaRepository<Corrego, Long> {
    Optional<Corrego> findByNome(String nome);
}

