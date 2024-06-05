package view;

import java.util.Scanner;

public class UpdateLivroGeneroView {
    public int getIdFromUser(Scanner scanner) {
        System.out.print("Informe o ID do gênero a ser atualizado: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, insira um número inteiro válido.");
            scanner.next(); // descartar entrada inválida
            System.out.print("Informe o ID do gênero a ser atualizado: ");
        }
        int id = scanner.nextInt();
        scanner.nextLine();  // Clear the buffer.
        return id;
    }

    public String getNewDescriptionFromUser(Scanner scanner) {
        System.out.print("Informe a nova descrição do gênero: ");
        String descricao = scanner.nextLine();
        return scanner.nextLine();
    }

    public void showResult(boolean result) {
        if (result) {
            System.out.println("Gênero atualizado com sucesso.");
        } else {
            System.out.println("Falha ao atualizar o gênero.");
        }
    }
}
