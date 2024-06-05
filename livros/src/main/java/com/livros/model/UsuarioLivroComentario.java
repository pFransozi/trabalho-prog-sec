package model;

public class UsuarioLivroComentario {
    private int id;
    private int idUsuarioLivroAvaliacao;
    private int usuario;
    private String comentario;

    public UsuarioLivroComentario() {
    }

    public UsuarioLivroComentario(int id, int idUsuarioLivroAvaliacao, int usuario, String comentario) {
        this.id = id;
        this.idUsuarioLivroAvaliacao = idUsuarioLivroAvaliacao;
        this.usuario = usuario;
        this.comentario = comentario;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsuarioLivroAvaliacao() {
        return idUsuarioLivroAvaliacao;
    }

    public void setIdUsuarioLivroAvaliacao(int idUsuarioLivroAvaliacao) {
        this.idUsuarioLivroAvaliacao = idUsuarioLivroAvaliacao;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
