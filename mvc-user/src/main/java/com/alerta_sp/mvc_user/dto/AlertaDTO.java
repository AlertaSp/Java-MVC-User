package com.alerta_sp.mvc_user.dto;

import com.alerta_sp.mvc_user.model.TipoAlerta;

import java.time.LocalDateTime;

public class AlertaDTO {
    private Long id;
    private Long idCorrego;
    private TipoAlerta tipo;
    private String mensagem;
    private String status;
    private LocalDateTime dataHora;

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getIdCorrego() { return idCorrego; }
    public void setIdCorrego(Long idCorrego) { this.idCorrego = idCorrego; }

    public TipoAlerta getTipo() { return tipo; }
    public void setTipo(TipoAlerta tipo) { this.tipo = tipo; }

    public String getMensagem() { return mensagem; }
    public void setMensagem(String mensagem) { this.mensagem = mensagem; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getDataHora() { return dataHora; }
    public void setDataHora(LocalDateTime dataHora) { this.dataHora = dataHora; }
}
