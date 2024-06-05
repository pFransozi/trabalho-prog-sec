package com.livros.view;

import com.livros.common.StringSanitizer;
import com.livros.common.StringNormalizer;
import com.livros.model.UsuarioGrupo;
import java.util.List;
import java.util.Scanner;

public class UsuarioGrupoView {
    public UsuarioGrupo getUsuarioGrupoFromUser(Scanner scanner) {
        System.out.print("Informe a descrição do grupo de usuários: ");
        String descricao = StringNormalizer.normalizeString(StringSanitizer.sanitizeText(scanner.nextLine()));
        return new UsuarioGrupo(0, descricao);  // ID é 0 porque será gerado pelo banco de dados
    }

    public int getUsuarioGrupoId(Scanner scanner) {
        System.out.print("Informe o ID do grupo de usuários: ");
        return scanner.nextInt();
    }

    public void displayUsuarioGrupo(UsuarioGrupo usuarioGrupo) {
        if (usuarioGrupo != null) {
            System.out.println("Grupo de Usuários encontrado: ID: " + usuarioGrupo.getId() + ", Descrição: " + usuarioGrupo.getDescricao());
        } else {
            System.out.println("Nenhum grupo de usuários encontrado.");
        }
    }

    public void displayAllUsuarioGrupos(List<UsuarioGrupo> usuarioGrupos) {
        if (usuarioGrupos.isEmpty()) {
            System.out.println("Nenhum grupo de usuários encontrado.");
        } else {
            System.out.println("Grupos de Usuários:");
            for (UsuarioGrupo ug : usuarioGrupos) {
                System.out.println("ID: " + ug.getId() + ", Descrição: " + ug.getDescricao());
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
