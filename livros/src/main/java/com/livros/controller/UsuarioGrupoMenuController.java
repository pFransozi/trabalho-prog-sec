package controller;

import view.UsuarioGrupoMenuView;

import java.util.Scanner;

public class UsuarioGrupoMenuController {
    private UsuarioGrupoController usuarioGrupoController;
    private UsuarioGrupoMenuView menuView;

    public UsuarioGrupoMenuController() {
        this.usuarioGrupoController = new UsuarioGrupoController();
        this.menuView = new UsuarioGrupoMenuView();
    }

    public void run(Scanner scanner) {
        boolean keepRunning = true;
        while (keepRunning) {
            int option = menuView.getOption(scanner);
            switch (option) {
                case 1:
                    usuarioGrupoController.cadastrarUsuarioGrupo(scanner);
                    break;
                case 2:
                    usuarioGrupoController.listarTodosUsuarioGrupos();
                    break;
                case 3:
                    usuarioGrupoController.buscarUsuarioGrupoPorId(scanner);
                    break;
                case 4:
                    usuarioGrupoController.atualizarUsuarioGrupo(scanner);
                    break;
                case 5:
                    usuarioGrupoController.deletarUsuarioGrupo(scanner);
                    break;
                case 6:
                    System.out.println("Voltando ao menu principal...");
                    keepRunning = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
