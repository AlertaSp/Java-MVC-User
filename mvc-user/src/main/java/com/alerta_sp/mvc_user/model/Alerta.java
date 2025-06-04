package com.alerta_sp.mvc_user.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "alerta")
public class Alerta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_corrego", nullable = false)
    private Corrego corrego;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false)
    private TipoAlerta tipo;

    @Column(name = "mensagem", length = 300)
    private String mensagem;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "data_hora", columnDefinition = "TIMESTAMP")
    private LocalDateTime dataHora;

    @Column(nullable = false)
    private boolean resolvido;

    public Alerta() {
        this.dataHora = LocalDateTime.now(); // sempre define a hora atual
        this.status = "ATIVO";               // define status padrão
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Corrego getCorrego() { return corrego; }
    public void setCorrego(Corrego corrego) { this.corrego = corrego; }

    public TipoAlerta getTipo() { return tipo; }
    public void setTipo(TipoAlerta tipo) { this.tipo = tipo; }

    public String getMensagem() { return mensagem; }
    public void setMensagem(String mensagem) { this.mensagem = mensagem; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getDataHora() { return dataHora; }
    public void setDataHora(LocalDateTime dataHora) { this.dataHora = dataHora; }

    public boolean isResolvido() {
        return resolvido;
    }

    public void setResolvido(boolean resolvido) {
        this.resolvido = resolvido;
    }
}
