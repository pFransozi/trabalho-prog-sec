package controller;

import dao.UsuarioLivroAvaliacaoDAO;
import model.UsuarioLivroAvaliacao;
import view.UsuarioLivroAvaliacaoView;
import java.util.List;
import java.util.Scanner;

public class UsuarioLivroAvaliacaoController {
    private UsuarioLivroAvaliacaoDAO dao;
    private UsuarioLivroAvaliacaoView view;

    public UsuarioLivroAvaliacaoController() {
        this.dao = new UsuarioLivroAvaliacaoDAO();
        this.view = new UsuarioLivroAvaliacaoView();
    }

    public void cadastrarAvaliacao(Scanner scanner) {
        UsuarioLivroAvaliacao avaliacao = view.getAvaliacaoDetails(scanner);
        boolean result = dao.insertAvaliacao(avaliacao);
        if (result) {
            view.displaySuccess("Avaliação cadastrada com sucesso!");
        } else {
            view.displayError("Erro ao cadastrar avaliação.");
        }
    }

    public void listarTodasAvaliacoes() {
        List<UsuarioLivroAvaliacao> avaliacoes = dao.selectAllAvaliacoes();
        view.displayAvaliacoes(avaliacoes);
    }

    public void buscarAvaliacaoPorId(Scanner scanner) {
        int id = view.getId(scanner);
        UsuarioLivroAvaliacao avaliacao = dao.selectAvaliacao(id);
        view.displayAvaliacao(avaliacao);
    }

    public void atualizarComentario(Scanner scanner) {
        int id = view.getId(scanner);
        String novoComentario = view.getNewComentario(scanner);
        boolean result = dao.updateAvaliacaoComentario(id, novoComentario);
        if (result) {
            view.displaySuccess("Comentário atualizado com sucesso!");
        } else {
            view.displayError("Erro ao atualizar comentário.");
        }
    }

    public void atualizarNota(Scanner scanner) {
        int id = view.getId(scanner);
        double novaNota = view.getNewNota(scanner);
        boolean result = dao.updateAvaliacaoNota(id, novaNota);
        if (result) {
            view.displaySuccess("Nota atualizada com sucesso!");
        } else {
            view.displayError("Erro ao atualizar nota.");
        }
    }

    public void deletarAvaliacao(Scanner scanner) {
        int id = view.getId(scanner);
        boolean result = dao.deleteAvaliacao(id);
        if (result) {
            view.displaySuccess("Avaliação deletada com sucesso!");
        } else {
            view.displayError("Erro ao deletar avaliação.");
        }
    }
}
