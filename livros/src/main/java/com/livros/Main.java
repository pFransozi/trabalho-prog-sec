package com.livros;

import com.livros.controller.MenuController;
import com.livros.common.LogManager;
import com.livros.controller.AutenticacaoController;

public class Main {
    public static void main(String[] args) {

        AutenticacaoController autenticacaoController = null;

        try {
            autenticacaoController = new AutenticacaoController();
        } catch (RuntimeException e) {
            LogManager.logError("Erro de inicialização", e.getMessage());
            System.exit(0);
        }

        java.util.Scanner scanner = new java.util.Scanner(System.in);

        boolean authenticated = false;
        while (!authenticated) {
            // criar view e model
            System.out.print("Usuário: ");
            String username = scanner.nextLine();
            System.out.print("Senha: ");
            String password = scanner.nextLine();

            // Autentica o usuário
            String token = autenticacaoController.autenticar(username, password);
            if (token != null) {
                System.out.println("Autenticação bem-sucedida. Token de acesso: " + token);
                authenticated = true;
                MenuController menuController = new MenuController();
                menuController.run();
            } else {
                System.out.println("Falha na autenticação. Verifique seu usuário e senha.");
            }
        }

        scanner.close();
    }
}
