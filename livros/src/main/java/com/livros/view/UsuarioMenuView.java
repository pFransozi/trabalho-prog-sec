package view;

import java.util.Scanner;

public class UsuarioMenuView {
    public int getOption(Scanner scanner) {
        System.out.println("\n--- Menu de Usuários ---");
        System.out.println("1. Cadastrar Usuário");
        System.out.println("2. Listar Todos os Usuários");
        System.out.println("3. Buscar Usuário por ID");
        System.out.println("4. Atualizar CPF do Usuário");
        System.out.println("5. Atualizar Email do Usuário");
        System.out.println("6. Atualizar Grupo do Usuário");
        System.out.println("7. Deletar Usuário");
        System.out.println("8. Voltar ao Menu Principal");
        System.out.print("Escolha uma opção: ");
        int option = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer
        return option;
    }

}
