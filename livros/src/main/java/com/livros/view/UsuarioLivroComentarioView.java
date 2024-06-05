package view;

import common.StringSanitizer;
import common.StringNormalizer;
import model.UsuarioLivroComentario;
import java.util.List;
import java.util.Scanner;

public class UsuarioLivroComentarioView {
    public UsuarioLivroComentario getComentarioDetails(Scanner scanner) {
        System.out.print("Informe o ID da avaliação: ");
        int idAvaliacao = scanner.nextInt();
        System.out.print("Informe o ID do usuário: ");
        int usuario = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer
        System.out.print("Digite o comentário: ");
        String comentario = StringNormalizer.normalizeString(StringSanitizer.sanitizeText(scanner.nextLine()));
        return new UsuarioLivroComentario(0, idAvaliacao, usuario, comentario);
    }

    public int getComentarioId(Scanner scanner) {
        System.out.print("Informe o ID do comentário: ");
        int comentario = scanner.nextInt();
        return comentario;
    }

    public String getUpdatedComentario(Scanner scanner) {
        System.out.print("Digite o novo comentário: ");
        scanner.nextLine(); // Limpar buffer
        String comentario = StringNormalizer.normalizeString(StringSanitizer.sanitizeText(scanner.nextLine()));
        return comentario;
    }

    public void displayComentario(UsuarioLivroComentario comentario) {
        if (comentario != null) {
            System.out.println("Comentário Encontrado:");
            System.out.println("ID: " + comentario.getId() + ", ID Avaliação: " + comentario.getIdUsuarioLivroAvaliacao() +
                    ", Usuário: " + comentario.getUsuario() + ", Comentário: " + comentario.getComentario());
        } else {
            System.out.println("Nenhum comentário encontrado.");
        }
    }

    public void displayAllComentarios(List<UsuarioLivroComentario> comentarios) {
        if (comentarios.isEmpty()) {
            System.out.println("Nenhum comentário encontrado.");
        } else {
            System.out.println("Lista de Comentários:");
            for (UsuarioLivroComentario c : comentarios) {
                System.out.println("ID: " + c.getId() + ", ID Avaliação: " + c.getIdUsuarioLivroAvaliacao() +
                        ", Usuário: " + c.getUsuario() + ", Comentário: " + c.getComentario());
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
