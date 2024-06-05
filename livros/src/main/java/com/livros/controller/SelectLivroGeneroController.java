package com.livros.controller;

import com.livros.dao.LivroGeneroDAO;
import com.livros.model.LivroGenero;
import com.livros.view.SelectLivroGeneroView;
import java.util.List;
import java.util.Scanner;

public class SelectLivroGeneroController {
    private LivroGeneroDAO livroGeneroDAO;
    private SelectLivroGeneroView view;

    public SelectLivroGeneroController() {
        this.livroGeneroDAO = new LivroGeneroDAO();
        this.view = new SelectLivroGeneroView();
    }

    public void selectLivroGeneroPorId(Scanner scanner) {
        int id = view.getIdFromUser(scanner);
        LivroGenero livroGenero = livroGeneroDAO.selectLivroGenero(id);
        view.displayLivroGenero(livroGenero);
    }

    public void listarTodosLivroGeneros() {
        List<LivroGenero> livroGeneros = livroGeneroDAO.selectAllLivroGeneros();
        view.displayAllLivroGeneros(livroGeneros);
    }
}
