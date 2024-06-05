package com.livros.view;

import java.util.Scanner;

public class LivroMenuView {
    public int getOption(Scanner scanner) {
        System.out.println("\n--- Menu de Livros ---");
        System.out.println("1. Cadastrar Livro");
        System.out.println("2. Listar Todos os Livros");
        System.out.println("3. Buscar Livro por ID");
        System.out.println("4. Buscar Livro por ISBN");
        System.out.println("5. Listar Livros por Gênero");
        System.out.println("6. Listar Livros por Autor");
        System.out.println("7. Atualizar Autor");
        System.out.println("8. Atualizar Título");
        System.out.println("9. Atualizar Gênero");
        System.out.println("10. Deletar Livro");
        System.out.println("11. Voltar ao Menu Principal");
        System.out.print("Escolha uma opção: ");
        int option = scanner.nextInt();
        return option;
    }
}
