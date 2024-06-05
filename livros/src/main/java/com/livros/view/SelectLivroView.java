package com.livros.view;

import com.livros.model.Livro;
import java.util.List;
import java.util.Scanner;

public class SelectLivroView {

    public int getIdFromUser(Scanner scanner) {

        System.out.print("Informe o ID do livro: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, insira um número inteiro válido.");
            scanner.next(); // Descartar entrada inválida
            System.out.print("Informe o ID do livro: ");
        }
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer após a leitura do número
        return id;
    }

    public String getISBNFromUser(Scanner scanner) {

        System.out.print("Informe o ISBN do livro: ");
        String isbn = scanner.nextLine();

        return isbn;
    }

    public int getGeneroFromUser(Scanner scanner) {
        System.out.print("Informe o ID do gênero: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, insira um número inteiro válido.");
            scanner.next(); // Descartar entrada inválida
            System.out.print("Informe o ID do gênero: ");
        }
        int genero = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer após a leitura do número
        return genero;
    }

    public String getAutorFromUser(Scanner scanner) {
        System.out.print("Informe o nome do autor: ");
        String autor = scanner.nextLine();
        return autor;
    }

    public void displayLivro(Livro livro) {
        if (livro != null) {
            System.out.println("Livro encontrado:");
            System.out.println("ID: " + livro.getId() + ", Título: " + livro.getTitulo() + ", Autor: " + livro.getAutor() + ", ISBN: " + livro.getIsbn() + ", Gênero: " + livro.getGenero());
        } else {
            System.out.println("Nenhum livro encontrado com o ID fornecido.");
        }
    }

    public void displayLivros(List<Livro> livros) {
        if (livros == null || livros.isEmpty()) {
            System.out.println("Nenhum livro encontrado.");
        } else {
            System.out.println("Livros encontrados:");
            for (Livro livro : livros) {
                System.out.println("ID: " + livro.getId() + ", Título: " + livro.getTitulo() + ", Autor: " + livro.getAutor() + ", ISBN: " + livro.getIsbn() + ", Gênero: " + livro.getGenero());
            }
        }
    }
}
