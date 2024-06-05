package com.livros.controller;

import com.livros.dao.LivroGeneroDAO;
import com.livros.view.DeleteLivroGeneroView;

import java.util.Scanner;

public class DeleteLivroGeneroController {
    private LivroGeneroDAO livroGeneroDAO;
    private DeleteLivroGeneroView view;

    public DeleteLivroGeneroController() {
        this.livroGeneroDAO = new LivroGeneroDAO();
        this.view = new DeleteLivroGeneroView();
    }

    public void deletarLivroGenero(Scanner scanner) {
        int id = view.getIdFromUser(scanner);
        boolean result = livroGeneroDAO.deleteLivroGenero(id);
        view.showResult(result);
    }
}
