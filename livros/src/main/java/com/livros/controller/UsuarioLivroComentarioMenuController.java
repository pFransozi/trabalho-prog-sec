package com.livros.controller;

import com.livros.view.UsuarioLivroComentarioMenuView;

import java.util.Scanner;

public class UsuarioLivroComentarioMenuController {
    private UsuarioLivroComentarioController comentarioController;
    private UsuarioLivroComentarioMenuView menuView;

    public UsuarioLivroComentarioMenuController() {
        this.comentarioController = new UsuarioLivroComentarioController();
        this.menuView = new UsuarioLivroComentarioMenuView();
    }

    public void run(Scanner scanner) {
        boolean keepRunning = true;
        while (keepRunning) {
            int option = menuView.getOption(scanner);
            switch (option) {
                case 1:
                    comentarioController.inserirComentario(scanner);
                    break;
                case 2:
                    comentarioController.atualizarComentario(scanner);
                    break;
                case 3:
                    comentarioController.deletarComentario(scanner);
                    break;
                case 4:
                    comentarioController.listarTodosComentarios();
                    break;
                case 5:
                    System.out.println("Saindo do menu de comentários...");
                    keepRunning = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
