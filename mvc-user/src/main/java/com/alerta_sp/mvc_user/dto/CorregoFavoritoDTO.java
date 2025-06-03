package com.alerta_sp.mvc_user.dto;

public class CorregoFavoritoDTO {
    private Long id;
    private String nome;
    private boolean favorito;

    public CorregoFavoritoDTO() {}

    public CorregoFavoritoDTO(Long id, String nome, boolean favorito) {
        this.id = id;
        this.nome = nome;
        this.favorito = favorito;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isFavorito() {
        return favorito;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }
}
