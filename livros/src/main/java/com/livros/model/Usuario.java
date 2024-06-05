package com.livros.model;

public class Usuario {
    private int id;
    private String cpf;
    private String email;
    private int grupo;

    public Usuario() {
    }

    public Usuario(int id, String cpf, String email, int grupo) {
        this.id = id;
        this.cpf = cpf;
        this.email = email;
        this.grupo = grupo;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getGrupo() {
        return grupo;
    }

    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }
}
