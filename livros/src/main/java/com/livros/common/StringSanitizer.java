package com.livros.common;

public class StringSanitizer {

    // Sanitização de comentários
    public static String sanitizeText(String input) {
        if (input == null) return null;
        // Remove tags HTML
        input = input.replaceAll("<[^>]*>", "");
        // Remove caracteres especiais específicos
        return input.replaceAll("[\\&\\\"\\'\\%]+", "");
    }

}
