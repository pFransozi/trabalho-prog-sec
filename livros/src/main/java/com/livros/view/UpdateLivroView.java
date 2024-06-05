package com.livros.view;

import java.util.Scanner;

public class UpdateLivroView {

    public int getIdFromUser(Scanner scanner) {
        System.out.print("Informe o ID do livro a ser atualizado: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, insira um número inteiro válido.");
            scanner.next(); // Descartar entrada inválida
            System.out.print("Informe o ID do livro a ser atualizado: ");
        }
        int id = scanner.nextInt();
        scanner.nextLine();  // Limpar o buffer
        return id;
    }

    public String getNewTituloFromUser(Scanner scanner) {
        System.out.print("Informe o novo título do livro: ");
        return scanner.nextLine();
    }

    public String getNewAutorFromUser(Scanner scanner) {
        System.out.print("Informe o novo autor do livro: ");
        return scanner.nextLine();
    }

    public int getNewGeneroFromUser(Scanner scanner) {
        System.out.print("Informe o novo ID do gênero do livro: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, insira um número inteiro válido.");
            scanner.next(); // Descartar entrada inválida
            System.out.print("Informe o novo ID do gênero do livro: ");
        }
        int genero = scanner.nextInt();
        scanner.nextLine();  // Limpar o buffer
        return genero;
    }

    public void displayResult(boolean result) {
        if (result) {
            System.out.println("Livro atualizado com sucesso.");
        } else {
            System.out.println("Erro ao atualizar o livro.");
        }
    }
}
