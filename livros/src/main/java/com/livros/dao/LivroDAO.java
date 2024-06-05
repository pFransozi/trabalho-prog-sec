package dao;

import common.ConnectionManager;
import common.LogManager;
import model.Livro;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LivroDAO {

    private ConnectionManager connectionManager;

    public LivroDAO() {
        connectionManager = ConnectionManager.getInstance();
    }

    public boolean insertLivro(Livro livro) {
        String sql = "INSERT INTO livro (id, titulo, autor, isbn, genero) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = connectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, livro.getId());
            pstmt.setString(2, livro.getTitulo());
            pstmt.setString(3, livro.getAutor());
            pstmt.setString(4, livro.getIsbn());
            pstmt.setInt(5, livro.getGenero());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            LogManager.logError("Erro ao inserir livro", e.getMessage());
            return false;
        }catch (Exception e){
            LogManager.logError("Erro na operação.", e.getMessage());
            return false;
        }
    }

    public Livro selectLivroByISBN(String isbn) {
        String sql = "SELECT * FROM livro WHERE isbn = ?";
        try (Connection conn = connectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, isbn);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Livro(rs.getInt("id"), rs.getString("titulo"), rs.getString("autor"), rs.getString("isbn"), rs.getInt("genero"));
            }
        } catch (SQLException e) {
            LogManager.logError("Erro ao buscar livro por ISBN", e.getMessage());
        }catch (Exception ex){
            LogManager.logError("Erro na operação.", ex.getMessage());
        }
        return null;
    }

    public Livro selectLivroById(int id) {
        String sql = "SELECT * FROM livro WHERE id = ?";
        try (Connection conn = connectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Livro(rs.getInt("id"), rs.getString("titulo"), rs.getString("autor"), rs.getString("isbn"), rs.getInt("genero"));
            }
        } catch (SQLException e) {
            LogManager.logError("Erro ao buscar livro por ID", e.getMessage());
        }catch (Exception e){
            LogManager.logError("Erro na operacao", e.getMessage());
        }
        return null;
    }

    public List<Livro> selectAllLivrosByGenero(int genero) {
        List<Livro> livros = new ArrayList<>();
        String sql = "SELECT * FROM livro WHERE genero = ?";
        try (Connection conn = connectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, genero);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                livros.add(new Livro(rs.getInt("id"), rs.getString("titulo"), rs.getString("autor"), rs.getString("isbn"), rs.getInt("genero")));
            }
        } catch (SQLException e) {
            LogManager.logError("Erro ao buscar livros", e.getMessage());
        }catch(Exception e){
            LogManager.logError("Erro na operacao", e.getMessage());
        }
        return livros;
    }

    public List<Livro> selectAllLivrosByAutor(String autor) {
        List<Livro> livros = new ArrayList<>();
        String sql = "SELECT * FROM livro WHERE autor = ?";
        try (Connection conn = connectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, autor);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                livros.add(new Livro(rs.getInt("id"), rs.getString("titulo"), rs.getString("autor"), rs.getString("isbn"), rs.getInt("genero")));
            }
        } catch (SQLException e) {
            LogManager.logError("Erro ao buscar livros", e.getMessage());
        }catch(Exception e){
            LogManager.logError("Erro na operacao", e.getMessage());
        }
        return livros;
    }

    public List<Livro> selectAllLivros() {
        List<Livro> livros = new ArrayList<>();
        String sql = "SELECT * FROM livro";
        try (Connection conn = connectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                livros.add(new Livro(rs.getInt("id"), rs.getString("titulo"), rs.getString("autor"), rs.getString("isbn"), rs.getInt("genero")));
            }
        } catch (SQLException e) {
            LogManager.logError("Erro ao buscar livros", e.getMessage());
        }catch (Exception e){
            LogManager.logError("Erro na operacao", e.getMessage());
        }
        return livros;
    }

    public boolean updateTitulo(int id, String novoTitulo) {
        String sql = "UPDATE livro SET titulo = ? WHERE id = ?";
        try (Connection conn = connectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, novoTitulo);
            pstmt.setInt(2, id);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            LogManager.logError("Erro ao atualizar titulo", e.getMessage());
            return false;
        }catch (Exception e){
            LogManager.logError("Erro na operacao", e.getMessage());
            return false;
        }
    }

    public boolean updateAutor(int id, String novoAutor) {
        String sql = "UPDATE livro SET autor = ? WHERE id = ?";
        try (Connection conn = connectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, novoAutor);
            pstmt.setInt(2, id);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            LogManager.logError("Erro ao atualizar autor", e.getMessage());
            return false;
        }catch (Exception e){
            LogManager.logError("Erro na operacao", e.getMessage());
            return false;
        }
    }

    public boolean updateGenero(int id, int novoGenero) {
        String sql = "UPDATE livro SET genero = ? WHERE id = ?";
        try (Connection conn = connectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, novoGenero);
            pstmt.setInt(2, id);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            LogManager.logError("Erro ao atualizar genero", e.getMessage());
            return false;
        }catch (Exception e){
            LogManager.logError("Erro na operacao", e.getMessage());
            return false;
        }
    }

    public boolean deleteLivro(int id) {
        String sql = "DELETE FROM livro WHERE id = ?";
        try (Connection conn = connectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            LogManager.logError("Erro ao deletar livro", e.getMessage());
            return false;
        }catch (Exception e){
            LogManager.logError("Erro na operacao", e.getMessage());
            return false;
        }
    }
}
