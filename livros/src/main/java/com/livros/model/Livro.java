package com.livros.model;

public class Livro {
    private int id;
    private String titulo;
    private String autor;
    private String isbn;
    private int genero;

    // Construtor
    public Livro(int id, String titulo, String autor, String isbn, int genero) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.genero = genero;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getGenero() {
        return genero;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }
}
