package com.livros.controller;

import com.livros.view.UsuarioMenuView;

import java.util.Scanner;

public class UsuarioMenuController {
    private UsuarioController usuarioController;
    private UsuarioMenuView menuView;

    public UsuarioMenuController() {
        this.usuarioController = new UsuarioController();
        this.menuView = new UsuarioMenuView();
    }

    public void run(Scanner scanner) {
        boolean keepRunning = true;
        while (keepRunning) {
            int option = menuView.getOption(scanner);
            switch (option) {
                case 1:
                    usuarioController.cadastrarUsuario(scanner);
                    break;
                case 2:
                    usuarioController.listarTodosUsuarios();
                    break;
                case 3:
                    usuarioController.buscarUsuarioPorId(scanner);
                    break;
                case 4:
                    usuarioController.atualizarUsuarioCPF(scanner);
                    break;
                case 5:
                    usuarioController.atualizarUsuarioEmail(scanner);
                    break;
                case 6:
                    usuarioController.atualizarUsuarioGrupo(scanner);
                    break;
                case 7:
                    usuarioController.deletarUsuario(scanner);
                    break;
                case 8:
                    System.out.println("Voltando ao menu principal...");
                    keepRunning = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
