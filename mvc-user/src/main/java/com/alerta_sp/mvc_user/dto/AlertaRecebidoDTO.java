package com.alerta_sp.mvc_user.dto;

import java.time.LocalDateTime;

public class AlertaRecebidoDTO {
    private Long idUsuario;
    private Long idAlerta;
    private String tipo;
    private String mensagem;
    private String status;
    private LocalDateTime dataHora;
    private String visto;

    // Getters e Setters
    public Long getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Long idUsuario) { this.idUsuario = idUsuario; }

    public Long getIdAlerta() { return idAlerta; }
    public void setIdAlerta(Long idAlerta) { this.idAlerta = idAlerta; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getMensagem() { return mensagem; }
    public void setMensagem(String mensagem) { this.mensagem = mensagem; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getDataHora() { return dataHora; }
    public void setDataHora(LocalDateTime dataHora) { this.dataHora = dataHora; }

    public String getVisto() { return visto; }
    public void setVisto(String visto) { this.visto = visto; }
}
