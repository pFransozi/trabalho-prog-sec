package com.livros.controller;

import com.livros.dao.LivroDAO;
import com.livros.model.Livro;
import com.livros.view.InsertLivroView;

import java.util.Scanner;

public class InsertLivroController {
    private LivroDAO livroDAO;
    private InsertLivroView view;

    public InsertLivroController() {
        this.livroDAO = new LivroDAO();
        this.view = new InsertLivroView();
    }

    public void inserirLivro(Scanner scanner) {
        Livro livro = view.getLivroFromUser(scanner);
        boolean result = livroDAO.insertLivro(livro);
        view.displayResult(result);
    }
}
