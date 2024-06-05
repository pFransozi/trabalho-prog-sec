package com.livros.controller;

import com.livros.dao.LivroGeneroDAO;
import com.livros.model.LivroGenero;
import com.livros.view.InsertLivroGeneroView;

import java.util.Scanner;

public class InsertLivroGeneroController {
    private LivroGeneroDAO livroGeneroDAO;
    private InsertLivroGeneroView view;

    public InsertLivroGeneroController() {
        this.livroGeneroDAO = new LivroGeneroDAO();
        this.view = new InsertLivroGeneroView();
    }

    public boolean cadastrarLivroGenero(Scanner scanner) {
        LivroGenero livroGenero = view.cadastro(scanner); // Obter os dados necessários do usuário
        return livroGeneroDAO.insertLivroGenero(livroGenero);
    }
}
