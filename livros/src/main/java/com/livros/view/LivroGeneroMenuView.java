package view;

import java.util.Scanner;

public class LivroGeneroMenuView {
    public int getOption(Scanner scanner) {
        System.out.println("\n--- Menu de Gêneros de Livros ---");
        System.out.println("1. Cadastrar Gênero");
        System.out.println("2. Listar Todos os Gêneros");
        System.out.println("3. Listar Gênero por ID");
        System.out.println("4. Atualizar Gênero");
        System.out.println("5. Deletar Gênero");
        System.out.println("6. Voltar ao Menu Principal");
        System.out.print("Escolha uma opção: ");
        int option = scanner.nextInt();
        return option;
    }
}
