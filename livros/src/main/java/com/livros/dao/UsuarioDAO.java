package dao;

import common.LogManager;
import model.Usuario;
import common.ConnectionManager;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    private ConnectionManager connectionManager;


    public UsuarioDAO() {
        connectionManager = ConnectionManager.getInstance();
    }

    public boolean insertUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuario (cpf, email, grupo) VALUES (?, ?, ?)";
        try (Connection conn = connectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, usuario.getCpf());
            pstmt.setString(2, usuario.getEmail());
            pstmt.setInt(3, usuario.getGrupo());
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        usuario.setId(generatedKeys.getInt(1));
                        return true;
                    }
                }
            }
        } catch (SQLException e) {
            LogManager.logError("Erro ao inserir usuário: " , e.getMessage());
        }catch (Exception e) {
            LogManager.logError("Erro na operação", e.getMessage());
        }
        return false;
    }

    public Usuario selectUsuario(int id) {
        String sql = "SELECT * FROM usuario WHERE id = ?";
        try (Connection conn = connectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Usuario(rs.getInt("id"), rs.getString("cpf"), rs.getString("email"), rs.getInt("grupo"));
            }
        } catch (SQLException e) {
            LogManager.logError("Erro ao buscar usuário: " , e.getMessage());
        }catch (Exception e) {
            LogManager.logError("Erro na operacao", e.getMessage());
        }
        return null;
    }

    public List<Usuario> selectAllUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuario";
        try (Connection conn = connectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                usuarios.add(new Usuario(rs.getInt("id"), rs.getString("cpf"), rs.getString("email"), rs.getInt("grupo")));
            }
        } catch (SQLException e) {
            LogManager.logError("Erro ao listar todos os usuários: " , e.getMessage());
        }catch (Exception e) {
            LogManager.logError("Erro na operacao", e.getMessage());
        }
        return usuarios;
    }

    public boolean updateUsuarioCPF(int id, String cpf) {
        String sql = "UPDATE usuario SET cpf = ? WHERE id = ?";
        try (Connection conn = connectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, cpf);
            pstmt.setInt(2, id);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            LogManager.logError("Erro ao atualizar CPF do usuário: " , e.getMessage());
        }catch (Exception e) {
            LogManager.logError("Erro na operacao", e.getMessage());
        }
        return false;
    }

    public boolean updateUsuarioEmail(int id, String email) {
        String sql = "UPDATE usuario SET email = ? WHERE id = ?";
        try (Connection conn = connectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, email);
            pstmt.setInt(2, id);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            LogManager.logError("Erro ao atualizar email do usuário: " , e.getMessage());
        }catch (Exception e) {
            LogManager.logError("Errp na operacao", e.getMessage());
        }
        return false;
    }

    public boolean updateUsuarioGrupo(int id, int grupo) {
        String sql = "UPDATE usuario SET grupo = ? WHERE id = ?";
        try (Connection conn = connectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, grupo);
            pstmt.setInt(2, id);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            LogManager.logError("Erro ao atualizar grupo do usuário: " , e.getMessage());
        }catch (Exception e) {
            LogManager.logError("Erro na operacao: " , e.getMessage());

        }
        return false;
    }

    public boolean deleteUsuario(int id) {
        String sql = "DELETE FROM usuario WHERE id = ?";
        try (Connection conn = connectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            LogManager.logError("Erro ao deletar usuário: " , e.getMessage());
        }catch (Exception e) {
            LogManager.logError("Erro na operacao: " , e.getMessage());
        }
        return false;
    }
}
