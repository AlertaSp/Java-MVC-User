package com.alerta_sp.mvc_user.messaging;

import com.alerta_sp.mvc_user.dto.AlertaMensagemDTO;
import com.alerta_sp.mvc_user.model.*;
import com.alerta_sp.mvc_user.repository.AlertaRecebidoRepository;
import com.alerta_sp.mvc_user.repository.AlertaRepository;
import com.alerta_sp.mvc_user.repository.CorregoRepository;
import com.alerta_sp.mvc_user.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class AlertaConsumer {

    private final AlertaRepository alertaRepository;
    private final CorregoRepository corregoRepository;
    private final UsuarioRepository usuarioRepository;
    private final AlertaRecebidoRepository alertaRecebidoRepository;

    public AlertaConsumer(AlertaRepository alertaRepository,
                          CorregoRepository corregoRepository,
                          UsuarioRepository usuarioRepository,
                          AlertaRecebidoRepository alertaRecebidoRepository) {
        this.alertaRepository = alertaRepository;
        this.corregoRepository = corregoRepository;
        this.usuarioRepository = usuarioRepository;
        this.alertaRecebidoRepository = alertaRecebidoRepository;
    }

    // 📩 Listener ativado por mensagens do RabbitMQ
    @RabbitListener(queues = "${rabbitmq.queue}")
    public void consumirAlerta(AlertaMensagemDTO dto) {
        System.out.println("✅ Alerta recebido: " + dto);

        // 1. Buscar córrego
        Corrego corrego = corregoRepository.findById(dto.getIdCorrego())
                .orElseThrow(() -> new EntityNotFoundException("Córrego não encontrado: ID=" + dto.getIdCorrego()));

        // 2. Salvar alerta
        Alerta alerta = new Alerta();
        alerta.setMensagem(dto.getMensagem());
        alerta.setTipo(TipoAlerta.valueOf(dto.getNivel().toUpperCase()));
        alerta.setCorrego(corrego);
        alerta.setStatus("ATIVO");
        alerta.setResolvido(false);

        alerta = alertaRepository.save(alerta);

        // 3. Buscar usuários que favoritaram este córrego
        for (Usuario usuario : corrego.getUsuariosFavoritaram()) {
            AlertaRecebido recebido = new AlertaRecebido();
            recebido.setUsuario(usuario);
            recebido.setAlerta(alerta);
            recebido.setId(new AlertaRecebidoId(usuario.getId(), alerta.getId()));
            recebido.setVisto("N");

            alertaRecebidoRepository.save(recebido);
        }

        System.out.println("📌 Alerta entregue aos usuários favoritos.");
    }
}
