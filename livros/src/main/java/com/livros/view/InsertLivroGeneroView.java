package com.livros.view;

import com.livros.common.StringSanitizer;
import java.util.Scanner;
import com.livros.model.LivroGenero;

public class InsertLivroGeneroView {

    public LivroGenero cadastro(Scanner scanner) {

        System.out.print("Informe a descrição do gênero: ");
        String descricao = StringSanitizer.sanitizeText(scanner.nextLine());

        return new LivroGenero(0, descricao);
    }
}
