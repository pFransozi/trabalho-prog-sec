package dao;

import common.LogManager;
import model.UsuarioLivroComentario;
import common.ConnectionManager;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioLivroComentarioDAO {

    private ConnectionManager connectionManager;

    public UsuarioLivroComentarioDAO() {
        connectionManager = ConnectionManager.getInstance();
    }

    public boolean insertComentario(UsuarioLivroComentario comentario) {
        String sql = "INSERT INTO usuario_livro_comentario (id, id_usuario_livro_avaliacao, usuario, comentario) VALUES (?, ?, ?, ?)";
        try (Connection conn = connectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, comentario.getId());
            pstmt.setInt(2, comentario.getIdUsuarioLivroAvaliacao());
            pstmt.setInt(3, comentario.getUsuario());
            pstmt.setString(4, comentario.getComentario());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            LogManager.logError("Erro ao inserir comentário: " , e.getMessage());
            return false;
        }catch (Exception e){
            LogManager.logError("Erro na operacao " , e.getMessage());
            return false;
        }
    }

    public List<UsuarioLivroComentario> selectAllComentarios() {
        List<UsuarioLivroComentario> comentarios = new ArrayList<>();
        String sql = "SELECT * FROM usuario_livro_comentario";
        try (Connection conn = connectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                comentarios.add(new UsuarioLivroComentario(
                        rs.getInt("id"),
                        rs.getInt("id_usuario_livro_avaliacao"),
                        rs.getInt("usuario"),
                        rs.getString("comentario")
                ));
            }
        } catch (SQLException e) {
            LogManager.logError("Erro ao listar todos os comentários: " , e.getMessage());
        }catch (Exception e){
            LogManager.logError("Erro na operacao " , e.getMessage());
        }
        return comentarios;
    }

    public boolean updateComentario(int id, String novoComentario) {
        String sql = "UPDATE usuario_livro_comentario SET comentario = ? WHERE id = ?";
        try (Connection conn = connectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, novoComentario);
            pstmt.setInt(2, id);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            LogManager.logError("Erro ao atualizar comentário: " , e.getMessage());
            return false;
        }catch (Exception e){
            LogManager.logError("Erro na operacao" , e.getMessage());
            return false;
        }
    }

    public boolean deleteComentario(int id) {
        String sql = "DELETE FROM usuario_livro_comentario WHERE id = ?";
        try (Connection conn = connectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            LogManager.logError("Erro ao deletar comentário: " , e.getMessage());
            return false;
        }catch (Exception e){
            LogManager.logError("Erro na operacao " , e.getMessage());
            return false;
        }
    }
}
