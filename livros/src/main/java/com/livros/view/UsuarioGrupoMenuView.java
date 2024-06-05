package com.livros.view;

import java.util.Scanner;

public class UsuarioGrupoMenuView {
    public int getOption(Scanner scanner) {
        System.out.println("\n--- Menu de Grupos de Usuários ---");
        System.out.println("1. Cadastrar Grupo de Usuários");
        System.out.println("2. Listar Todos os Grupos de Usuários");
        System.out.println("3. Buscar Grupo de Usuários por ID");
        System.out.println("4. Atualizar Grupo de Usuários");
        System.out.println("5. Deletar Grupo de Usuários");
        System.out.println("6. Voltar ao Menu Principal");
        System.out.print("Escolha uma opção: ");
        int option = scanner.nextInt();
        scanner.nextLine(); // Clear the scanner buffer
        return option;
    }

}
