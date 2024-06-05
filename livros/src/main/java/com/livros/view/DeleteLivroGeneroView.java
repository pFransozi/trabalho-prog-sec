package com.livros.view;

import java.util.Scanner;

public class DeleteLivroGeneroView {

    public int getIdFromUser(Scanner scanner) {
        System.out.print("Informe o ID do gênero a ser excluído: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, insira um número inteiro válido.");
            scanner.next(); // descartar entrada inválida
            System.out.print("Informe o ID do gênero a ser excluído: ");
        }
        int id = scanner.nextInt();
        scanner.nextLine();  // Clear the buffer.
        return id;
    }

    public void showResult(boolean result) {
        if (result) {
            System.out.println("Gênero excluído com sucesso.");
        } else {
            System.out.println("Falha ao excluir o gênero.");
        }
    }
}
