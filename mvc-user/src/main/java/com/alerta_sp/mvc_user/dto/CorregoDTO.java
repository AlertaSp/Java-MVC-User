package com.alerta_sp.mvc_user.dto;

public class CorregoDTO {

    private Long id;
    private String nome;
    private String latitude;
    private String longitude;
    private Double nivelAlerta;
    private Double nivelCritico;

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
}
