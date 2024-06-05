package com.livros.controller;

import com.livros.dao.LivroDAO;
import com.livros.model.Livro;
import com.livros.view.SelectLivroView;
import java.util.List;
import java.util.Scanner;

public class SelectLivroController {
    private LivroDAO livroDAO;
    private SelectLivroView view;

    public SelectLivroController() {
        this.livroDAO = new LivroDAO();
        this.view = new SelectLivroView();
    }

    public void selectLivroPorId(Scanner scanner) {
        int id = view.getIdFromUser(scanner);
        Livro livro = livroDAO.selectLivroById(id);
        view.displayLivro(livro);
    }

    public void selectLivroPorISBN(Scanner scanner) {
        String isbn = view.getISBNFromUser(scanner);
        Livro livro = livroDAO.selectLivroByISBN(isbn);
        view.displayLivro(livro);
    }

    public void selectLivrosPorGenero(Scanner scanner) {
        int genero = view.getGeneroFromUser(scanner);
        List<Livro> livros = livroDAO.selectAllLivrosByGenero(genero);
        view.displayLivros(livros);
    }

    public void selectLivrosPorAutor(Scanner scanner) {
        String autor = view.getAutorFromUser(scanner);
        List<Livro> livros = livroDAO.selectAllLivrosByAutor(autor);
        view.displayLivros(livros);
    }

    public void selectTodosOsLivros() {
        List<Livro> livros = livroDAO.selectAllLivros();
        view.displayLivros(livros);
    }
}
