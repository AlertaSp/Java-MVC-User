package com.alerta_sp.mvc_user.messaging;

import com.alerta_sp.mvc_user.dto.MensagemAlertaDTO;
import com.alerta_sp.mvc_user.model.*;
import com.alerta_sp.mvc_user.repository.AlertaRecebidoRepository;
import com.alerta_sp.mvc_user.repository.AlertaRepository;
import com.alerta_sp.mvc_user.repository.CorregoRepository;
import com.alerta_sp.mvc_user.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public void consumirAlerta(MensagemAlertaDTO dto) {
        System.out.println("✅ Alerta recebido: " + dto);

        if (dto.getIdCorrego() == null) {
            System.err.println("❌ Mensagem recebida sem id do córrego: " + dto);
            return;
        }

        // 1. Buscar córrego
        Corrego corrego = corregoRepository.findById(dto.getIdCorrego())
                .orElseThrow(() -> new EntityNotFoundException("Córrego não encontrado: ID=" + dto.getIdCorrego()));

        // 2. Salvar alerta
        Alerta alerta = new Alerta();
        alerta.setMensagem(dto.getMensagem());

        String tipo = dto.getTipo() != null
                ? dto.getTipo().toUpperCase()
                : "DESCONHECIDO";

        alerta.setTipo(TipoAlerta.valueOf(tipo));
        alerta.setCorrego(corrego);
        alerta.setStatus("ATIVO");
        alerta.setResolvido(false);

        alerta = alertaRepository.save(alerta);

        // 3. Buscar usuários que acompanham ou favoritaram este córrego
        java.util.List<Usuario> usuarios = usuarioRepository.findUsuariosByCorrego(corrego.getId());

        for (Usuario usuario : usuarios) {
            if (usuario == null) continue;

            AlertaRecebido recebido = new AlertaRecebido();
            recebido.setUsuario(usuario);
            recebido.setAlerta(alerta);
            recebido.setId(new AlertaRecebidoId(usuario.getId(), alerta.getId()));
            recebido.setVisto("N");

            alertaRecebidoRepository.save(recebido);
        }

        System.out.println("📌 Alerta entregue aos usuários que acompanham o córrego.");
    }
}
