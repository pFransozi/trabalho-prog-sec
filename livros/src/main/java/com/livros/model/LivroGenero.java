package model;

public class LivroGenero {
    private int id;
    private String descricao;

    public LivroGenero(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public LivroGenero() {

    }

    // Getters e Setters
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
