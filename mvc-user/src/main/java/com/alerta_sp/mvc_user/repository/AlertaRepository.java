package com.alerta_sp.mvc_user.repository;

import com.alerta_sp.mvc_user.model.Alerta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlertaRepository extends JpaRepository<Alerta, Long> {
    List<Alerta> findByCorregoId(Long idCorrego);
    List<Alerta> findByStatus(String status);
}
