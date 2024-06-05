package common;

import java.sql.*;

public class ConnectionManager {

    //Eager Initialization
    private static final ConnectionManager instance = new  ConnectionManager();

    // Leitura das configurações da conexão a partir de variáveis de ambiente
    private final String url = System.getenv("DB_URL");
    private final String user = System.getenv("DB_USER");
    private final String password = System.getenv("DB_PASSWORD");
    private Connection connection;

    private ConnectionManager() {
        // Inicialização da conexão
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Erro ao conectar com o banco de dados: " + e.getMessage());
            this.connection = null;
        }
    }

    public static ConnectionManager getInstance() {
        return instance;
    }

    public Connection getConnection() {
        return this.connection;
    }

    @Override
    protected void finalize() throws Throwable {
        try {
            closeConnection();
        } finally {
            super.finalize();
        }
    }

    public void closeConnection() {
        if (this.connection != null) {
            try {
                this.connection.close();
            } catch (SQLException e) {
                System.err.println("Erro ao fechar a conexão com o banco de dados.");
            } finally {
                this.connection = null;
            }
        }
    }
}
