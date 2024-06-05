package com.livros.model;

public class UsuarioLivroAvaliacao {
    private int id;
    private int usuario;
    private int livro;
    private String comentario;
    private double nota;

    public UsuarioLivroAvaliacao() {
    }

    public UsuarioLivroAvaliacao(int id, int usuario, int livro, String comentario, double nota) {
        this.id = id;
        this.usuario = usuario;
        this.livro = livro;
        this.comentario = comentario;
        this.nota = nota;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public int getLivro() {
        return livro;
    }

    public void setLivro(int livro) {
        this.livro = livro;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
}
