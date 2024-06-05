package controller;

import dao.LivroDAO;
import view.DeleteLivroView;

import java.util.Scanner;

public class DeleteLivroController {
    private LivroDAO livroDAO;
    private DeleteLivroView view;

    public DeleteLivroController() {
        this.livroDAO = new LivroDAO();
        this.view = new DeleteLivroView();
    }

    public void deletarLivro(Scanner scanner) {
        int id = view.getIdFromUser(scanner);
        boolean result = livroDAO.deleteLivro(id);
        view.displayResult(result);
    }
}
