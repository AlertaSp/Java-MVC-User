package com.alerta_sp.mvc_user.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "favorito_usuario")
public class FavoritoUsuario {

    @EmbeddedId
    private FavoritoUsuarioId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idUsuario")
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idCorrego")
    @JoinColumn(name = "id_corrego")
    private Corrego corrego;

    // Getters e Setters
    public FavoritoUsuarioId getId() { return id; }
    public void setId(FavoritoUsuarioId id) { this.id = id; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public Corrego getCorrego() { return corrego; }
    public void setCorrego(Corrego corrego) { this.corrego = corrego; }
}
