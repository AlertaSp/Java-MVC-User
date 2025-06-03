package com.alerta_sp.mvc_user.model;

import jakarta.persistence.*;

@Entity
@Table(name = "alerta_recebido")
public class AlertaRecebido {

    @EmbeddedId
    private AlertaRecebidoId id = new AlertaRecebidoId();

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idUsuario")
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idAlerta")
    @JoinColumn(name = "id_alerta")
    private Alerta alerta;

    @Column(name = "visto", length = 1)
    private String visto = "N"; // 'S' ou 'N'

    // Getters e Setters
    public AlertaRecebidoId getId() { return id; }
    public void setId(AlertaRecebidoId id) { this.id = id; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public Alerta getAlerta() { return alerta; }
    public void setAlerta(Alerta alerta) { this.alerta = alerta; }

    public String getVisto() { return visto; }
    public void setVisto(String visto) { this.visto = visto; }
}
