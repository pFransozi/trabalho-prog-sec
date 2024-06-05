package view;

import java.util.Scanner;

public class UsuarioLivroComentarioMenuView {
    public int getOption(Scanner scanner) {
        System.out.println("\n--- Menu de Comentários de Livros ---");
        System.out.println("1. Inserir Comentário");
        System.out.println("2. Atualizar Comentário");
        System.out.println("3. Deletar Comentário");
        System.out.println("4. Listar Todos os Comentários");
        System.out.println("5. Sair");
        System.out.print("Escolha uma opção: ");
        int option = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer após leitura de número
        return option;
    }

}
