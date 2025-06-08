package com.alerta_sp.mvc_user.dto;

import java.io.Serializable;

public class MensagemAlertaDTO implements Serializable {
    private Long idCorrego;
    private String mensagem;
    private String tipo;

    public MensagemAlertaDTO() {
    }

    public Long getIdCorrego() {
        return idCorrego;
    }

    public void setIdCorrego(Long idCorrego) {
        this.idCorrego = idCorrego;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "MensagemAlertaDTO{" +
                "idCorrego=" + idCorrego +
                ", mensagem='" + mensagem + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
