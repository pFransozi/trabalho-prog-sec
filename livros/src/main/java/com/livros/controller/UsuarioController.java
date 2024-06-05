package com.livros.controller;

import com.livros.dao.UsuarioDAO;
import com.livros.model.Usuario;
import com.livros.view.UsuarioView;
import java.util.List;
import java.util.Scanner;

public class UsuarioController {
    private UsuarioDAO usuarioDAO;
    private UsuarioView view;

    public UsuarioController() {
        this.usuarioDAO = new UsuarioDAO();
        this.view = new UsuarioView();
    }

    public void cadastrarUsuario(Scanner scanner) {
        Usuario usuario = view.getUsuarioFromUser(scanner);
        boolean result = usuarioDAO.insertUsuario(usuario);
        if (result) {
            view.displaySuccess("Usuário cadastrado com sucesso!");
        } else {
            view.displayError("Erro ao cadastrar usuário.");
        }
    }

    public void listarTodosUsuarios() {
        List<Usuario> usuarios = usuarioDAO.selectAllUsuarios();
        view.displayAllUsuarios(usuarios);
    }

    public void buscarUsuarioPorId(Scanner scanner) {
        int id = view.getUsuarioId(scanner);
        Usuario usuario = usuarioDAO.selectUsuario(id);
        view.displayUsuario(usuario);
    }

    public void atualizarUsuarioCPF(Scanner scanner) {
        int id = view.getUsuarioId(scanner);
        String cpf = view.getCpfFromUser(scanner);
        boolean result = usuarioDAO.updateUsuarioCPF(id, cpf);
        if (result) {
            view.displaySuccess("CPF do usuário atualizado com sucesso!");
        } else {
            view.displayError("Erro ao atualizar CPF do usuário.");
        }
    }

    public void atualizarUsuarioEmail(Scanner scanner) {
        int id = view.getUsuarioId(scanner);
        String email = view.getEmailFromUser(scanner);
        boolean result = usuarioDAO.updateUsuarioEmail(id, email);
        if (result) {
            view.displaySuccess("Email do usuário atualizado com sucesso!");
        } else {
            view.displayError("Erro ao atualizar email do usuário.");
        }
    }

    public void atualizarUsuarioGrupo(Scanner scanner) {
        int id = view.getUsuarioId(scanner);
        int grupo = view.getGrupoFromUser(scanner);
        boolean result = usuarioDAO.updateUsuarioGrupo(id, grupo);
        if (result) {
            view.displaySuccess("Grupo do usuário atualizado com sucesso!");
        } else {
            view.displayError("Erro ao atualizar grupo do usuário.");
        }
    }

    public void deletarUsuario(Scanner scanner) {
        int id = view.getUsuarioId(scanner);
        boolean result = usuarioDAO.deleteUsuario(id);
        if (result) {
            view.displaySuccess("Usuário deletado com sucesso!");
        } else {
            view.displayError("Erro ao deletar usuário.");
        }
    }
}
