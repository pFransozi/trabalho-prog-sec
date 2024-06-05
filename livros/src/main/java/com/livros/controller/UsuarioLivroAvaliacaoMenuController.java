package com.livros.controller;

import com.livros.view.UsuarioLivroAvaliacaoMenuView;

import java.util.Scanner;

public class UsuarioLivroAvaliacaoMenuController {
    private UsuarioLivroAvaliacaoController avaliacaoController;
    private UsuarioLivroAvaliacaoMenuView menuView;

    public UsuarioLivroAvaliacaoMenuController() {
        this.avaliacaoController = new UsuarioLivroAvaliacaoController();
        this.menuView = new UsuarioLivroAvaliacaoMenuView();
    }

    public void run(Scanner scanner) {
        boolean keepRunning = true;
        while (keepRunning) {
            int option = menuView.getOption(scanner);
            switch (option) {
                case 1:
                    avaliacaoController.cadastrarAvaliacao(scanner);
                    break;
                case 2:
                    avaliacaoController.listarTodasAvaliacoes();
                    break;
                case 3:
                    avaliacaoController.buscarAvaliacaoPorId(scanner);
                    break;
                case 4:
                    avaliacaoController.atualizarComentario(scanner);
                    break;
                case 5:
                    avaliacaoController.atualizarNota(scanner);
                    break;
                case 6:
                    avaliacaoController.deletarAvaliacao(scanner);
                    break;
                case 7:
                    System.out.println("Saindo do menu de avaliações...");
                    keepRunning = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
