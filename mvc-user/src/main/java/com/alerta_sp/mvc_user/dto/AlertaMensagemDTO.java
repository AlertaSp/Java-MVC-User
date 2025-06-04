package com.alerta_sp.mvc_user.dto;
import java.io.Serializable;

public class AlertaMensagemDTO implements Serializable {

    private String mensagem;
    private String nivel;
    private String corrego;
    private Long idCorrego;

    public AlertaMensagemDTO() {}

    public AlertaMensagemDTO(String mensagem, String nivel, String corrego) {
        this.mensagem = mensagem;
        this.nivel = nivel;
        this.corrego = corrego;
    }

    public String getMensagem() { return mensagem; }
    public void setMensagem(String mensagem) { this.mensagem = mensagem; }

    public String getNivel() { return nivel; }
    public void setNivel(String nivel) { this.nivel = nivel; }

    public String getCorrego() { return corrego; }
    public void setCorrego(String corrego) { this.corrego = corrego; }

    public Long getIdCorrego() { return idCorrego; }

    public void setIdCorrego(Long idCorrego) {
        this.idCorrego = idCorrego;
    }

    @Override
    public String toString() {
        return "AlertaMensagemDTO{" +
                "mensagem='" + mensagem + '\'' +
                ", nivel='" + nivel + '\'' +
                ", corrego='" + corrego + '\'' +
                ", idCorrego=" + idCorrego +
                '}';
    }
}