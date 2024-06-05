package com.livros.view;

import java.util.Scanner;

public class DeleteLivroView {

    public int getIdFromUser(Scanner scanner) {
        System.out.print("Informe o ID do livro a ser excluído: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, insira um número inteiro válido.");
            scanner.next(); // Descartar entrada inválida
            System.out.print("Informe o ID do livro a ser excluído: ");
        }
        int id = scanner.nextInt();
        scanner.nextLine();  // Limpar o buffer
        return id;
    }

    public void displayResult(boolean result) {
        if (result) {
            System.out.println("Livro excluído com sucesso.");
        } else {
            System.out.println("Erro ao excluir o livro.");
        }
    }
}
