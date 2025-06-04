package com.alerta_sp.mvc_user.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AlertaRecebidoId implements Serializable {

    @Column(name = "id_usuario", nullable = false)
    private Long idUsuario;

    @Column(name = "id_alerta", nullable = false)
    private Long idAlerta;

    public AlertaRecebidoId() {}

    public AlertaRecebidoId(Long idUsuario, Long idAlerta) {
        this.idUsuario = idUsuario;
        this.idAlerta = idAlerta;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdAlerta() {
        return idAlerta;
    }

    public void setIdAlerta(Long idAlerta) {
        this.idAlerta = idAlerta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AlertaRecebidoId)) return false;
        AlertaRecebidoId that = (AlertaRecebidoId) o;
        return Objects.equals(idUsuario, that.idUsuario) &&
                Objects.equals(idAlerta, that.idAlerta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, idAlerta);
    }
}
