package com.alerta_sp.mvc_user.messaging;

import com.alerta_sp.mvc_user.dto.AlertaMensagemDTO;
import com.alerta_sp.mvc_user.model.Alerta;
import com.alerta_sp.mvc_user.model.Corrego;
import com.alerta_sp.mvc_user.model.TipoAlerta;
import com.alerta_sp.mvc_user.repository.AlertaRepository;
import com.alerta_sp.mvc_user.repository.CorregoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class AlertaConsumer {

    private final AlertaRepository alertaRepository;
    private final CorregoRepository corregoRepository;

    public AlertaConsumer(AlertaRepository alertaRepository, CorregoRepository corregoRepository) {
        this.alertaRepository = alertaRepository;
        this.corregoRepository = corregoRepository;
    }

    @RabbitListener(queues = "alertas.queue")
    public void consumirAlerta(AlertaMensagemDTO dto) {
        Corrego corrego = corregoRepository.findByNome(dto.getCorrego())
                .orElseThrow(() -> new EntityNotFoundException("Córrego não encontrado: " + dto.getCorrego()));

        TipoAlerta tipo = TipoAlerta.valueOf(dto.getNivel().toUpperCase());

        Alerta alerta = new Alerta();
        alerta.setMensagem(dto.getMensagem());
        alerta.setCorrego(corrego);
        alerta.setTipo(tipo);
        alerta.setDataHora(LocalDateTime.now());
        alerta.setResolvido(false);

        alertaRepository.save(alerta);
        System.out.println("✅ Alerta recebido e salvo: " + dto.getMensagem());
    }
}
