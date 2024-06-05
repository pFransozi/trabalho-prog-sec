package controller;

import view.LivroMenuView;

import java.util.Scanner;

public class LivroMenuController {
    private final InsertLivroController insertLivroController;
    private final SelectLivroController selectLivroController;
    private final UpdateLivroController updateLivroController;
    private final DeleteLivroController deleteLivroController;
    private LivroMenuView menuView;

    public LivroMenuController() {

        insertLivroController = new InsertLivroController();
        selectLivroController = new SelectLivroController();
        updateLivroController = new UpdateLivroController();
        deleteLivroController = new DeleteLivroController();

        this.menuView = new LivroMenuView();
    }

    public void run(Scanner scanner) {
        boolean keepRunning = true;
        while (keepRunning) {
            int option = menuView.getOption(scanner);
            switch (option) {
                case 1:
                    insertLivroController.inserirLivro(scanner);
                    break;
                case 2:
                    selectLivroController.selectTodosOsLivros();
                    break;
                case 3:
                    selectLivroController.selectLivroPorId(scanner);
                    break;
                case 4:
                    selectLivroController.selectLivroPorISBN(scanner);
                    break;
                case 5:
                    selectLivroController.selectLivrosPorGenero(scanner);
                    break;
                case 6:
                    selectLivroController.selectLivrosPorAutor(scanner);
                    break;
                case 7:
                    updateLivroController.atualizarAutor(scanner);
                    break;
                case 8:
                    updateLivroController.atualizarTitulo(scanner);
                    break;
                case 9:
                    updateLivroController.atualizarGenero(scanner);
                    break;
                case 10:
                    deleteLivroController.deletarLivro(scanner);
                    break;
                case 11:
                    keepRunning = false;
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
