package controller;

import dao.LivroGeneroDAO;
import model.LivroGenero;
import view.InsertLivroGeneroView;

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
