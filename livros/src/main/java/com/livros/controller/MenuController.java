package com.livros.controller;

import com.livros.view.MenuView;
import com.livros.view.UsuarioGrupoMenuView;
import com.livros.view.UsuarioGrupoView;
import com.livros.view.UsuarioLivroComentarioMenuView;

import java.util.Scanner;

public class MenuController {
    private final LivroGeneroMenuController livroGeneroMenuController;
    private final LivroMenuController livroMenuController;
    private final UsuarioGrupoMenuController usuarioGrupoMenuController;
    private final UsuarioMenuController usuarioMenuController;
    private final UsuarioLivroAvaliacaoMenuController usuarioLivroAvaliacaoMenuController;
    private final UsuarioLivroComentarioMenuController usuarioLivroComentarioMenuController;
    private final MenuView menuView;

    public MenuController() {
        this.livroGeneroMenuController = new LivroGeneroMenuController();
        this.livroMenuController = new LivroMenuController();
        this.usuarioGrupoMenuController = new UsuarioGrupoMenuController();
        this.usuarioMenuController = new UsuarioMenuController();
        this.usuarioLivroAvaliacaoMenuController = new UsuarioLivroAvaliacaoMenuController();
        this.usuarioLivroComentarioMenuController = new UsuarioLivroComentarioMenuController();

        this.menuView = new MenuView();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean keepRunning = true;
        while (keepRunning) {
            int option = menuView.getMainOption(scanner);
            switch (option) {
                case 1:
                    livroGeneroMenuController.run(scanner);  // Executa o submenu de LivroGenero
                    break;
                case 2:
                    livroMenuController.run(scanner);  // Executa o submenu de Livro
                    break;
                case 3:
                    usuarioGrupoMenuController.run(scanner);
                    break;
                case 4:
                    usuarioMenuController.run(scanner);
                    break;
                case 5:
                    usuarioLivroAvaliacaoMenuController.run(scanner);
                    break;
                case 6:
                    usuarioLivroComentarioMenuController.run(scanner);
                    break;
                case 7:
                    System.out.println("Saindo do sistema...");
                    keepRunning = false;
                    scanner.close();
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, tente novamente.");
                    break;
            }
        }
    }
}
