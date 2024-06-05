package com.livros.dao;

import com.livros.common.LogManager;
import com.livros.model.UsuarioLivroAvaliacao;
import com.livros.common.ConnectionManager;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioLivroAvaliacaoDAO {

    private ConnectionManager connectionManager;

    public UsuarioLivroAvaliacaoDAO() {
        connectionManager = ConnectionManager.getInstance();

    }

    public boolean insertAvaliacao(UsuarioLivroAvaliacao avaliacao) {
        String sql = "INSERT INTO usuario_livro_avaliacao (id, usuario, livro, comentario, nota) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = connectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, avaliacao.getId());
            pstmt.setInt(2, avaliacao.getUsuario());
            pstmt.setInt(3, avaliacao.getLivro());
            pstmt.setString(4, avaliacao.getComentario());
            pstmt.setDouble(5, avaliacao.getNota());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            LogManager.logError("Erro ao inserir avaliação: ", e.getMessage());
        }catch (Exception e) {
            LogManager.logError("Erro na operacao", e.getMessage());
        }
        return false;
    }

    public boolean updateAvaliacaoComentario(int id, String comentario) {
        String sql = "UPDATE usuario_livro_avaliacao SET comentario = ? WHERE id = ?";
        try (Connection conn = connectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, comentario);
            pstmt.setInt(2, id);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            LogManager.logError("Erro ao atualizar comentário da avaliação: ", e.getMessage());
        }catch (Exception e) {
            LogManager.logError("Erro na operacao", e.getMessage());
        }
        return false;
    }

    public boolean updateAvaliacaoNota(int id, double nota) {
        String sql = "UPDATE usuario_livro_avaliacao SET nota = ? WHERE id = ?";
        try (Connection conn = connectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, nota);
            pstmt.setInt(2, id);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            LogManager.logError("Erro ao atualizar nota da avaliação: ", e.getMessage());
        }catch (Exception e) {
        LogManager.logError("Erro na operacao", e.getMessage());
    }
        return false;
    }

    public List<UsuarioLivroAvaliacao> selectAllAvaliacoes() {
        List<UsuarioLivroAvaliacao> avaliacoes = new ArrayList<>();
        String sql = "SELECT * FROM usuario_livro_avaliacao";
        try (Connection conn = connectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                avaliacoes.add(new UsuarioLivroAvaliacao(
                        rs.getInt("id"),
                        rs.getInt("usuario"),
                        rs.getInt("livro"),
                        rs.getString("comentario"),
                        rs.getDouble("nota")
                ));
            }
        } catch (SQLException e) {
            LogManager.logError("Erro ao listar avaliações: " , e.getMessage());
        }catch (Exception e){
            LogManager.logError("Erro na operacao", e.getMessage());
        }
        return avaliacoes;
    }

    public List<UsuarioLivroAvaliacao> selectAvaliacoesPorUsuario(int usuarioId) {
        List<UsuarioLivroAvaliacao> avaliacoes = new ArrayList<>();
        String sql = "SELECT * FROM usuario_livro_avaliacao WHERE usuario = ?";
        try (Connection conn = connectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, usuarioId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    avaliacoes.add(new UsuarioLivroAvaliacao(
                            rs.getInt("id"),
                            rs.getInt("usuario"),
                            rs.getInt("livro"),
                            rs.getString("comentario"),
                            rs.getDouble("nota")
                    ));
                }
            }
        } catch (SQLException e) {
            LogManager.logError("Erro ao buscar avaliações por usuário: " , e.getMessage());
        }catch (Exception e){
            LogManager.logError("Erro na operacao", e.getMessage());
        }
        return avaliacoes;
    }

    public List<UsuarioLivroAvaliacao> selectAvaliacoesPorLivro(int livroId) {
        List<UsuarioLivroAvaliacao> avaliacoes = new ArrayList<>();
        String sql = "SELECT * FROM usuario_livro_avaliacao WHERE livro = ?";
        try (Connection conn = connectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, livroId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    avaliacoes.add(new UsuarioLivroAvaliacao(
                            rs.getInt("id"),
                            rs.getInt("usuario"),
                            rs.getInt("livro"),
                            rs.getString("comentario"),
                            rs.getDouble("nota")
                    ));
                }
            }
        } catch (SQLException e) {
            LogManager.logError("Erro ao buscar avaliações por livro: " , e.getMessage());
        }catch (Exception e){
            LogManager.logError("Erro na operacao", e.getMessage());
        }
        return avaliacoes;
    }

    public UsuarioLivroAvaliacao selectAvaliacao(int id) {
        String sql = "SELECT * FROM usuario_livro_avaliacao WHERE id = ?";
        try (Connection conn = connectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new UsuarioLivroAvaliacao(
                        rs.getInt("id"),
                        rs.getInt("usuario"),
                        rs.getInt("livro"),
                        rs.getString("comentario"),
                        rs.getDouble("nota")
                );
            }
        } catch (SQLException e) {
            LogManager.logError("Erro ao buscar avaliação por ID: " , e.getMessage());
        }catch (Exception e){
            LogManager.logError("Erro na operacao", e.getMessage());
        }
        return null;
    }


    public List<UsuarioLivroAvaliacao> selectAvaliacoesPorNota(double nota) {
        List<UsuarioLivroAvaliacao> avaliacoes = new ArrayList<>();
        String sql = "SELECT * FROM usuario_livro_avaliacao WHERE nota = ?";
        try (Connection conn = connectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, nota);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    avaliacoes.add(new UsuarioLivroAvaliacao(
                            rs.getInt("id"),
                            rs.getInt("usuario"),
                            rs.getInt("livro"),
                            rs.getString("comentario"),
                            rs.getDouble("nota")
                    ));
                }
            }
        } catch (SQLException e) {
            LogManager.logError("Erro ao buscar avaliações por nota: " , e.getMessage());
        }catch (Exception e){
            LogManager.logError("Erro na operacao", e.getMessage());
        }
        return avaliacoes;
    }

    public boolean deleteAvaliacao(int id) {
        String sql = "DELETE FROM usuario_livro_avaliacao WHERE id = ?";
        try (Connection conn = connectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            LogManager.logError("Erro ao deletar avaliação: " , e.getMessage());
        }catch (Exception e){
            LogManager.logError("Erro na operacao: " , e.getMessage());
        }
        return false;
    }
}
