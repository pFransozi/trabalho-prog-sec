package com.livros.model;

public class UsuarioGrupo {
    private int id;
    private String descricao;

    public UsuarioGrupo() {
    }

    public UsuarioGrupo(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
