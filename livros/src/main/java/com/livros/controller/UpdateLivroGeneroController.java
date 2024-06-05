package com.livros.controller;

import com.livros.dao.LivroGeneroDAO;
import com.livros.model.LivroGenero;
import com.livros.view.UpdateLivroGeneroView;

import java.util.Scanner;

public class UpdateLivroGeneroController {
    private LivroGeneroDAO livroGeneroDAO;
    private UpdateLivroGeneroView view;

    public UpdateLivroGeneroController() {
        this.livroGeneroDAO = new LivroGeneroDAO();
        this.view = new UpdateLivroGeneroView();
    }

    public void atualizarLivroGenero(Scanner scanner) {
        int id = view.getIdFromUser(scanner);
        String newDescription = view.getNewDescriptionFromUser(scanner);
        LivroGenero livroGenero = new LivroGenero(id, newDescription);
        boolean result = livroGeneroDAO.updateLivroGenero(livroGenero);
        view.showResult(result);
    }
}
