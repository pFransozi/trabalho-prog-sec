package controller;

import view.LivroGeneroMenuView;

import java.util.Scanner;

public class LivroGeneroMenuController {
    private final InsertLivroGeneroController insertLivroGeneroController;
    private final SelectLivroGeneroController selectLivroGeneroController;
    private final UpdateLivroGeneroController updateLivroGeneroController;
    private final DeleteLivroGeneroController deleteLivroGeneroController;
    private final LivroGeneroMenuView menuView;

    public LivroGeneroMenuController() {
        this.insertLivroGeneroController = new InsertLivroGeneroController();
        this.selectLivroGeneroController = new SelectLivroGeneroController();
        this.updateLivroGeneroController = new UpdateLivroGeneroController();
        this.deleteLivroGeneroController = new DeleteLivroGeneroController();

        this.menuView = new LivroGeneroMenuView();
    }

    public void run(Scanner scanner) {
        boolean keepRunning = true;
        while (keepRunning) {
            int option = menuView.getOption(scanner);
            switch (option) {
                case 1:
                    insertLivroGeneroController.cadastrarLivroGenero(scanner);
                    break;
                case 2:
                    selectLivroGeneroController.listarTodosLivroGeneros();
                    break;
                case 3:
                    selectLivroGeneroController.selectLivroGeneroPorId(scanner);
                    break;
                case 4:
                    updateLivroGeneroController.atualizarLivroGenero(scanner);
                    break;
                case 5:
                    deleteLivroGeneroController.deletarLivroGenero(scanner);
                    break;
                case 6:
                    keepRunning = false;
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
