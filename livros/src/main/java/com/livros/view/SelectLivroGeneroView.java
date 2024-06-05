package view;

import model.LivroGenero;
import java.util.List;
import java.util.Scanner;

public class SelectLivroGeneroView {
    public int getIdFromUser(Scanner scanner) {
        System.out.print("Informe o ID do gênero: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, insira um número inteiro válido.");
            scanner.next(); // Descarta a entrada inválida
            System.out.print("Informe o ID do gênero: ");
        }
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer após a leitura do número
        return id;
    }

    public void displayLivroGenero(LivroGenero livroGenero) {
        if (livroGenero != null) {
            System.out.println("Gênero encontrado: ID: " + livroGenero.getId() + ", Descrição: " + livroGenero.getDescricao());
        } else {
            System.out.println("Nenhum gênero encontrado com o ID fornecido.");
        }
    }

    public void displayAllLivroGeneros(List<LivroGenero> livroGeneros) {
        if (livroGeneros == null || livroGeneros.isEmpty()) {
            System.out.println("Nenhum gênero de livro encontrado.");
        } else {
            System.out.println("Todos os gêneros de livros:");
            for (LivroGenero lg : livroGeneros) {
                System.out.println("ID: " + lg.getId() + ", Descrição: " + lg.getDescricao());
            }
        }
    }
}
