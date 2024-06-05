package com.livros.controller;

import com.livros.dao.UsuarioGrupoDAO;
import com.livros.model.UsuarioGrupo;
import com.livros.view.UsuarioGrupoView;
import java.util.List;
import java.util.Scanner;

public class UsuarioGrupoController {
    private UsuarioGrupoDAO usuarioGrupoDAO;
    private UsuarioGrupoView view;

    public UsuarioGrupoController() {
        this.usuarioGrupoDAO = new UsuarioGrupoDAO();
        this.view = new UsuarioGrupoView();
    }

    public void cadastrarUsuarioGrupo(Scanner scanner) {
        UsuarioGrupo usuarioGrupo = view.getUsuarioGrupoFromUser(scanner);
        boolean result = usuarioGrupoDAO.insertUsuarioGrupo(usuarioGrupo);
        if (result) {
            view.displaySuccess("Grupo de usuários cadastrado com sucesso!");
        } else {
            view.displayError("Erro ao cadastrar grupo de usuários.");
        }
    }

    public void listarTodosUsuarioGrupos() {
        List<UsuarioGrupo> usuarioGrupos = usuarioGrupoDAO.selectAllUsuarioGrupos();
        view.displayAllUsuarioGrupos(usuarioGrupos);
    }

    public void buscarUsuarioGrupoPorId(Scanner scanner) {
        int id = view.getUsuarioGrupoId(scanner);
        UsuarioGrupo usuarioGrupo = usuarioGrupoDAO.selectUsuarioGrupo(id);
        view.displayUsuarioGrupo(usuarioGrupo);
    }

    public void atualizarUsuarioGrupo(Scanner scanner) {
        int id = view.getUsuarioGrupoId(scanner);
        UsuarioGrupo usuarioGrupo = view.getUsuarioGrupoFromUser(scanner);
        usuarioGrupo.setId(id); // Configura o ID para garantir que o registro correto seja atualizado
        boolean result = usuarioGrupoDAO.updateUsuarioGrupo(usuarioGrupo);
        if (result) {
            view.displaySuccess("Grupo de usuários atualizado com sucesso!");
        } else {
            view.displayError("Erro ao atualizar grupo de usuários.");
        }
    }

    public void deletarUsuarioGrupo(Scanner scanner) {
        int id = view.getUsuarioGrupoId(scanner);
        boolean result = usuarioGrupoDAO.deleteUsuarioGrupo(id);
        if (result) {
            view.displaySuccess("Grupo de usuários deletado com sucesso!");
        } else {
            view.displayError("Erro ao deletar grupo de usuários.");
        }
    }
}
