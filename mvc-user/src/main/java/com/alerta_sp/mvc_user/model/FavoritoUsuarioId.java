package com.alerta_sp.mvc_user.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class FavoritoUsuarioId implements Serializable {

    private Long idUsuario;
    private Long idCorrego;

    public FavoritoUsuarioId() {}

    public FavoritoUsuarioId(Long idUsuario, Long idCorrego) {
        this.idUsuario = idUsuario;
        this.idCorrego = idCorrego;
    }

    public Long getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Long idUsuario) { this.idUsuario = idUsuario; }

    public Long getIdCorrego() { return idCorrego; }
    public void setIdCorrego(Long idCorrego) { this.idCorrego = idCorrego; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FavoritoUsuarioId)) return false;
        FavoritoUsuarioId that = (FavoritoUsuarioId) o;
        return Objects.equals(idUsuario, that.idUsuario) &&
                Objects.equals(idCorrego, that.idCorrego);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, idCorrego);
    }
}
