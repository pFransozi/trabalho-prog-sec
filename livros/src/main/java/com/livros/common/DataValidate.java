package common;

public class DataValidate {
    // Sanitização de e-mails
    public static boolean isValidEmail(String email) {
        return email != null && email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }

    public static boolean isValidCPF(String cpf) {
        cpf = cpf.replaceAll("[^\\d]", ""); // Remove caracteres não numéricos
        if (cpf.length() != 11) return false;

        // Cálculo do primeiro dígito verificador
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += (cpf.charAt(i) - '0') * (10 - i);
        }
        int check1 = 11 - (sum % 11);
        if (check1 == 10 || check1 == 11) check1 = 0;
        if (check1 != cpf.charAt(9) - '0') return false;

        // Cálculo do segundo dígito verificador
        sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += (cpf.charAt(i) - '0') * (11 - i);
        }
        int check2 = 11 - (sum % 11);
        if (check2 == 10 || check2 == 11) check2 = 0;
        if (check2 != cpf.charAt(10) - '0') return false;

        return true;
    }

    public static boolean isValidISBN(String isbn) {
        isbn = isbn.replace("-", "");
        if (isbn.length() == 10) {
            return isValidISBN10(isbn);
        } else if (isbn.length() == 13) {
            return isValidISBN13(isbn);
        }
        return false;
    }

    private static boolean isValidISBN10(String isbn) {
        if (isbn.length() != 10) return false;

        int sum = 0;
        for (int i = 0; i < 9; i++) {
            int digit = isbn.charAt(i) - '0';
            if (digit < 0 || digit > 9) return false;
            sum += (digit * (10 - i));
        }

        char lastChar = isbn.charAt(9);
        if (lastChar != 'X' && (lastChar < '0' || lastChar > '9')) return false;

        sum += (lastChar == 'X') ? 10 : (lastChar - '0');
        return sum % 11 == 0;
    }

    private static boolean isValidISBN13(String isbn) {
        if (isbn.length() != 13) return false;

        int sum = 0;
        for (int i = 0; i < 12; i++) {
            int digit = isbn.charAt(i) - '0';
            if (digit < 0 || digit > 9) return false;
            sum += (digit * ((i % 2 == 0) ? 1 : 3));
        }

        int lastDigit = isbn.charAt(12) - '0';
        if (lastDigit < 0 || lastDigit > 9) return false;

        sum += lastDigit;
        return sum % 10 == 0;
    }

}
