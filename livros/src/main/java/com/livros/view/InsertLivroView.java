package view;

import common.StringSanitizer;
import common.StringNormalizer;
import common.DataValidate;
import model.Livro;
import java.util.Scanner;

public class InsertLivroView {

    public Livro getLivroFromUser(Scanner scanner) {


        System.out.print("Informe o título do livro: ");
        String titulo = StringNormalizer.normalizeString(StringSanitizer.sanitizeText(scanner.nextLine()));

        System.out.print("Informe o autor do livro: ");
        String autor = StringNormalizer.normalizeString(StringSanitizer.sanitizeText(scanner.nextLine()));

        System.out.print("Informe o ISBN do livro: ");
        String isbn = getISBNFromUser(scanner);

        System.out.print("Informe o gênero do livro (ID): ");
        int genero = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        return new Livro(0, titulo, autor, isbn, genero);
    }

    private String getISBNFromUser(Scanner scanner) {
        String isbn;
        boolean isValid;
        do {
            System.out.print("Informe o ISBN do livro: ");
            isbn = scanner.nextLine();
            isValid = DataValidate.isValidISBN(isbn);
            if (!isValid) {
                System.out.println("ISBN inválido. Por favor, tente novamente.");
            }
        } while (!isValid);
        return isbn;
    }

    public void displayResult(boolean result) {
        if (result) {
            System.out.println("Livro inserido com sucesso.");
        } else {
            System.out.println("Erro ao inserir livro.");
        }
    }
}
