package dao;

import common.LogManager;
import model.LivroGenero;
import common.ConnectionManager;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LivroGeneroDAO {

    private ConnectionManager connectionManager;

    public LivroGeneroDAO() {
        connectionManager = ConnectionManager.getInstance();
    }
    public boolean insertLivroGenero(LivroGenero livroGenero) {
        String query = "INSERT INTO livro_genero (descricao) VALUES (?)";
        try (Connection conn = connectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(2, livroGenero.getDescricao());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            LogManager.logError("Erro ao inserir gênero de livro", e.getMessage());
            return false;
        }catch (NullPointerException e){
            LogManager.logError("Erro na operacao.", e.getMessage());
            return false;
        }
    }

    public LivroGenero selectLivroGenero(int id) {
        String query = "SELECT id, descricao FROM livro_genero WHERE id = ?";
        try (Connection conn = connectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                LivroGenero livroGenero = new LivroGenero();
                livroGenero.setId(rs.getInt("id"));
                livroGenero.setDescricao(rs.getString("descricao"));
                return livroGenero;
            }
        } catch (SQLException e) {
            LogManager.logError("Erro ao selecionar gênero de livro", e.getMessage());
        }catch (NullPointerException e){
            LogManager.logError("Erro na operacao.", e.getMessage());
        }
        return null;
    }

    public List<LivroGenero> selectAllLivroGeneros() {
        List<LivroGenero> livroGeneros = new ArrayList<>();
        String query = "SELECT id, descricao FROM livro_genero";
        try (Connection conn = connectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                LivroGenero livroGenero = new LivroGenero();
                livroGenero.setId(rs.getInt("id"));
                livroGenero.setDescricao(rs.getString("descricao"));
                livroGeneros.add(livroGenero);
            }
        } catch (SQLException e) {
            LogManager.logError("Erro ao selecionar todos os gêneros de livros", e.getMessage());
        }catch (NullPointerException e){
            LogManager.logError("Erro na operacao.", e.getMessage());
        }
        return livroGeneros;
    }

    public boolean updateLivroGenero(LivroGenero livroGenero) {
        String query = "UPDATE livro_genero SET descricao = ? WHERE id = ?";
        try (Connection conn = connectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, livroGenero.getDescricao());
            pstmt.setInt(2, livroGenero.getId());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            LogManager.logError("Erro ao atualizar gênero de livro: ", e.getMessage());
            return false;
        }catch (NullPointerException e){
            LogManager.logError("Erro na operacao.", e.getMessage());
            return false;
        }
    }

    public boolean deleteLivroGenero(int id) {
        String query = "DELETE FROM livro_genero WHERE id = ?";
        try (Connection conn = connectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            LogManager.logError("Erro ao deletar gênero de livro: " , e.getMessage());
            return false;
        }catch (NullPointerException e){
            LogManager.logError("Erro na operacao.", e.getMessage());
            return false;
        }
    }
}
