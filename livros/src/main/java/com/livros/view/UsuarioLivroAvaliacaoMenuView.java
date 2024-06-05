package com.livros.view;

import java.util.Scanner;

public class UsuarioLivroAvaliacaoMenuView {
    public int getOption(Scanner scanner) {
        System.out.println("\n--- Menu de Avaliações de Livros ---");
        System.out.println("1. Cadastrar Avaliação");
        System.out.println("2. Listar Todas Avaliações");
        System.out.println("3. Buscar Avaliação por ID");
        System.out.println("4. Atualizar Comentário de Avaliação");
        System.out.println("5. Atualizar Nota de Avaliação");
        System.out.println("6. Deletar Avaliação");
        System.out.println("7. Sair");
        System.out.print("Escolha uma opção: ");
        int option = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer após leitura de número
        return option;
    }
}
