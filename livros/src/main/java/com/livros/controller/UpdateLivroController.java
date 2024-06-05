package controller;

import dao.LivroDAO;
import view.UpdateLivroView;

import java.util.Scanner;

public class UpdateLivroController {
    private LivroDAO livroDAO;
    private UpdateLivroView view;

    public UpdateLivroController() {
        this.livroDAO = new LivroDAO();
        this.view = new UpdateLivroView();
    }

    public void atualizarTitulo(Scanner scanner) {
        int id = view.getIdFromUser(scanner);
        String novoTitulo = view.getNewTituloFromUser(scanner);
        boolean result = livroDAO.updateTitulo(id, novoTitulo);
        view.displayResult(result);
    }

    public void atualizarAutor(Scanner scanner) {
        int id = view.getIdFromUser(scanner);
        String novoAutor = view.getNewAutorFromUser(scanner);
        boolean result = livroDAO.updateAutor(id, novoAutor);
        view.displayResult(result);
    }

    public void atualizarGenero(Scanner scanner) {
        int id = view.getIdFromUser(scanner);
        int novoGenero = view.getNewGeneroFromUser(scanner);
        boolean result = livroDAO.updateGenero(id, novoGenero);
        view.displayResult(result);
    }
}
