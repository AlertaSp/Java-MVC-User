package com.alerta_sp.mvc_user.dto;

public class AlertaMensagemDTO {
    private String mensagem;
    private String corrego;
    private String nivel;

    // Getters e setters

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getCorrego() {
        return corrego;
    }

    public void setCorrego(String corrego) {
        this.corrego = corrego;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
}
