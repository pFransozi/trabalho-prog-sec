package com.livros.common;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class StringNormalizer {
    // Método para normalizar uma string para a forma NFC
    public static String normalizeString(String input) {
        if (input == null) {
            return null;
        }
        return Normalizer.normalize(input, Normalizer.Form.NFC);
    }
}
