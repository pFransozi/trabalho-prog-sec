package com.livros.view;

import com.livros.common.StringSanitizer;
import com.livros.common.StringNormalizer;
import com.livros.model.UsuarioLivroAvaliacao;
import java.util.List;
import java.util.Scanner;

public class UsuarioLivroAvaliacaoView {
    public UsuarioLivroAvaliacao getAvaliacaoDetails(Scanner scanner) {
        System.out.println("Digite os detalhes da avaliação:");
        System.out.print("ID do usuário: ");
        int usuario = scanner.nextInt();
        System.out.print("ID do livro: ");
        int livro = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer
        System.out.print("Comentário: ");
        String comentario = StringNormalizer.normalizeString(StringSanitizer.sanitizeText(scanner.nextLine()));
        System.out.print("Nota (0.0 a 10.0): ");
        double nota = scanner.nextDouble();
        scanner.nextLine(); // Limpar buffer
        return new UsuarioLivroAvaliacao(0, usuario, livro, comentario, nota); // ID será definido pelo DB
    }

    public int getId(Scanner scanner) {
        System.out.print("Informe o ID da avaliação: ");
        Integer id = scanner.nextInt();
        return id;
    }

    public String getNewComentario(Scanner scanner) {
        System.out.print("Informe o novo comentário: ");
        scanner.nextLine(); // Limpar buffer
        String comentario = scanner.nextLine();
        return comentario;
    }

    public double getNewNota(Scanner scanner) {
        System.out.print("Informe a nova nota: ");
        Double nota = scanner.nextDouble();
        return nota;
    }

    public void displayAvaliacao(UsuarioLivroAvaliacao avaliacao) {
        if (avaliacao != null) {
            System.out.println("Avaliação Encontrada:");
            System.out.println("ID: " + avaliacao.getId() + ", Usuário: " + avaliacao.getUsuario() +
                    ", Livro: " + avaliacao.getLivro() + ", Comentário: " + avaliacao.getComentario() +
                    ", Nota: " + avaliacao.getNota());
        } else {
            System.out.println("Nenhuma avaliação encontrada.");
        }
    }

    public void displayAvaliacoes(List<UsuarioLivroAvaliacao> avaliacoes) {
        if (avaliacoes.isEmpty()) {
            System.out.println("Nenhuma avaliação encontrada.");
        } else {
            System.out.println("Lista de Avaliações:");
            for (UsuarioLivroAvaliacao aval : avaliacoes) {
                System.out.println("ID: " + aval.getId() + ", Usuário: " + aval.getUsuario() +
                        ", Livro: " + aval.getLivro() + ", Comentário: " + aval.getComentario() +
                        ", Nota: " + aval.getNota());
            }
        }
    }

    public void displaySuccess(String message) {
        System.out.println(message);
    }

    public void displayError(String message) {
        System.out.println(message);
    }
}
