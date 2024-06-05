package dao;

import common.LogManager;
import model.UsuarioGrupo;
import common.ConnectionManager;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioGrupoDAO {

    private ConnectionManager connectionManager;

    public UsuarioGrupoDAO() {
        connectionManager = ConnectionManager.getInstance();

    }


    public boolean insertUsuarioGrupo(UsuarioGrupo usuarioGrupo) {
        String sql = "INSERT INTO usuario_grupo (descricao) VALUES (?)";
        try (Connection conn = connectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, usuarioGrupo.getDescricao());
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        usuarioGrupo.setId(generatedKeys.getInt(1));
                        return true;
                    }
                }
            }
        } catch (SQLException e) {
            LogManager.logError("Erro ao inserir grupo de usuário: " , e.getMessage());
        }catch (Exception e){
            LogManager.logError("Erro aona operacao " , e.getMessage());
        }
        return false;
    }

    public UsuarioGrupo selectUsuarioGrupo(int id) {
        String sql = "SELECT * FROM usuario_grupo WHERE id = ?";
        try (Connection conn = connectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new UsuarioGrupo(rs.getInt("id"), rs.getString("descricao"));
            }
        } catch (SQLException e) {
            LogManager.logError("Erro ao buscar grupo de usuário" , e.getMessage());
        }catch (Exception e){
            LogManager.logError("Erro aona operacao " , e.getMessage());

        }
        return null;
    }

    public List<UsuarioGrupo> selectAllUsuarioGrupos() {
        List<UsuarioGrupo> usuarioGrupos = new ArrayList<>();
        String sql = "SELECT * FROM usuario_grupo";
        try (Connection conn = connectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                usuarioGrupos.add(new UsuarioGrupo(rs.getInt("id"), rs.getString("descricao")));
            }
        } catch (SQLException e) {
            LogManager.logError("Erro ao listar todos os grupos de usuários " , e.getMessage());
        }catch (Exception e){
            LogManager.logError("Erro aona operacao " , e.getMessage());
        }
        return usuarioGrupos;
    }

    public boolean updateUsuarioGrupo(UsuarioGrupo usuarioGrupo) {
        String sql = "UPDATE usuario_grupo SET descricao = ? WHERE id = ?";
        try (Connection conn = connectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, usuarioGrupo.getDescricao());
            pstmt.setInt(2, usuarioGrupo.getId());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            LogManager.logError("Erro ao atualizar grupo de usuário: " , e.getMessage());
        }catch (Exception e){
        LogManager.logError("Erro aona operacao " , e.getMessage());
    }
        return false;
    }

    public boolean deleteUsuarioGrupo(int id) {
        String sql = "DELETE FROM usuario_grupo WHERE id = ?";
        try (Connection conn = connectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            LogManager.logError("Erro ao deletar grupo de usuário: " , e.getMessage());
        }catch (Exception e){
        LogManager.logError("Erro aona operacao " , e.getMessage());
    }
        return false;
    }
}
