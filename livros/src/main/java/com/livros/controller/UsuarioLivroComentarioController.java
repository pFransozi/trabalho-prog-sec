package controller;

import dao.UsuarioLivroComentarioDAO;
import model.UsuarioLivroComentario;
import view.UsuarioLivroComentarioView;
import java.util.List;
import java.util.Scanner;

public class UsuarioLivroComentarioController {
    private UsuarioLivroComentarioDAO dao;
    private UsuarioLivroComentarioView view;

    public UsuarioLivroComentarioController() {
        this.dao = new UsuarioLivroComentarioDAO();
        this.view = new UsuarioLivroComentarioView();
    }

    public void inserirComentario(Scanner scanner) {
        UsuarioLivroComentario comentario = view.getComentarioDetails(scanner);
        if (comentario.getId() == 0) { // Novo comentário
            boolean result = dao.insertComentario(comentario);
            if (result) {
                view.displaySuccess("Comentário inserido com sucesso!");
            } else {
                view.displayError("Erro ao inserir comentário.");
            }
        } else {
            view.displayError("ID deve ser 0 para novos comentários.");
        }
    }

    public void atualizarComentario(Scanner scanner) {
        int id = view.getComentarioId(scanner);
        String novoComentario = view.getUpdatedComentario(scanner);
        boolean result = dao.updateComentario(id, novoComentario);
        if (result) {
            view.displaySuccess("Comentário atualizado com sucesso!");
        } else {
            view.displayError("Erro ao atualizar comentário.");
        }
    }

    public void deletarComentario(Scanner scanner) {
        int id = view.getComentarioId(scanner);
        boolean result = dao.deleteComentario(id);
        if (result) {
            view.displaySuccess("Comentário deletado com sucesso!");
        } else {
            view.displayError("Erro ao deletar comentário.");
        }
    }

    public void listarTodosComentarios() {
        List<UsuarioLivroComentario> comentarios = dao.selectAllComentarios();
        view.displayAllComentarios(comentarios);
    }
}
