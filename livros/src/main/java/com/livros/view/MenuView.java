package view;

import java.util.Scanner;

public class MenuView {
    public int getMainOption(Scanner scanner) {

        System.out.println("\n--- Menu Principal ---");
        System.out.println("1. Gêneros de Livros");
        System.out.println("2. Livros");
        System.out.println("3. Grupo Usuários");
        System.out.println("4. Usuario");
        System.out.println("5. Avaliação Livros");
        System.out.println("6. Comentários das Avaliações");
        System.out.println("7. Sair");
        System.out.print("Escolha uma opção: ");
        int option = scanner.nextInt();
        return option;
    }
}
