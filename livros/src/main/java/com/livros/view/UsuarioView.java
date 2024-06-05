package view;

import common.DataValidate;
import common.StringNormalizer;
import model.Usuario;
import java.util.List;
import java.util.Scanner;

public class UsuarioView {
    public Usuario getUsuarioFromUser(Scanner scanner) {
        String cpf = getCPFFromUser(scanner);
        String email = getEmailFromUser(scanner);

        System.out.print("Informe o ID do grupo do usuário: ");
        int grupo = scanner.nextInt();
        scanner.nextLine();  // Limpar buffer após ler o número

        return new Usuario(0, cpf, email, grupo);  // ID é 0 porque será gerado pelo banco de dados
    }

    private String getCPFFromUser(Scanner scanner) {
        String cpf;
        boolean isValid;
        do {
            System.out.print("Informe o CPF do usuário: ");
            cpf = scanner.nextLine();
            isValid = DataValidate.isValidCPF(cpf);
            if (!isValid) {
                System.out.println("CPF inválido. Por favor, tente novamente.");
            }
        } while (!isValid);
        return cpf;
    }


    public String getEmailFromUser(Scanner scanner) {
        String email;
        boolean isValid;
        do {
            System.out.print("Informe o email do usuário: ");
            email = scanner.nextLine();
            isValid = DataValidate.isValidEmail(email);
            if (!isValid) {
                System.out.println("Email inválido. Por favor, tente novamente.");
            }
        } while (!isValid);
        email = StringNormalizer.normalizeString(email);
        return email;
    }

    public int getUsuarioId(Scanner scanner) {
        System.out.print("Informe o ID do usuário para operação: ");
        Integer id = scanner.nextInt();
        return id;
    }

    public void displayUsuario(Usuario usuario) {
        if (usuario != null) {
            System.out.println("Usuário Encontrado: ID: " + usuario.getId() + ", CPF: " + usuario.getCpf() +
                    ", Email: " + usuario.getEmail() + ", Grupo: " + usuario.getGrupo());
        } else {
            System.out.println("Nenhum usuário encontrado.");
        }
    }

    public void displayAllUsuarios(List<Usuario> usuarios) {
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário encontrado.");
        } else {
            System.out.println("Lista de Usuários:");
            for (Usuario usuario : usuarios) {
                System.out.println("ID: " + usuario.getId() + ", CPF: " + usuario.getCpf() +
                        ", Email: " + usuario.getEmail() + ", Grupo: " + usuario.getGrupo());
            }
        }
    }

    public String getCpfFromUser(Scanner scanner) {
        System.out.print("Digite o novo CPF do usuário: ");
        String cpf = scanner.nextLine();
        return cpf;
    }

    public int getGrupoFromUser(Scanner scanner) {
        System.out.print("Digite o novo ID de grupo do usuário: ");
        int grupo = scanner.nextInt();
        return grupo;
    }

    public void displaySuccess(String message) {
        System.out.println(message);
    }

    public void displayError(String message) {
        System.out.println(message);
    }
}
