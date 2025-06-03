package com.alerta_sp.mvc_user.model;

import jakarta.persistence.*;

@Entity
@Table(name = "corrego")
public class Corrego {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_corrego")
    private Long id;

    @Column(nullable = false)
    private String nome;

    private String latitude;
    private String longitude;

    @Column(name = "nivel_alerta")
    private Double nivelAlerta;

    @Column(name = "nivel_critico")
    private Double nivelCritico;

    @Transient
    private boolean favorito; // <-- usado apenas para exibir na view

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getLatitude() { return latitude; }
    public void setLatitude(String latitude) { this.latitude = latitude; }

    public String getLongitude() { return longitude; }
    public void setLongitude(String longitude) { this.longitude = longitude; }

    public Double getNivelAlerta() { return nivelAlerta; }
    public void setNivelAlerta(Double nivelAlerta) { this.nivelAlerta = nivelAlerta; }

    public Double getNivelCritico() { return nivelCritico; }
    public void setNivelCritico(Double nivelCritico) { this.nivelCritico = nivelCritico; }

    public boolean isFavorito() { return favorito; }
    public void setFavorito(boolean favorito) { this.favorito = favorito; }
}
