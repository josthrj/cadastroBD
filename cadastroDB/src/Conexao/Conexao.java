package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static final String URL = "jdbc:mysql://localhost:3306/bancoDadosLoja";
    private static final String USER = "root";
    private static final String PASSWORD = "134265Rj*";

    private static Connection conn;

    // Método para obter a conexão com o banco de dados
    public static Connection getConexao() {
        if (conn == null) {
            try {
                conn = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
                // Melhor prática seria lançar uma RuntimeException com uma mensagem mais amigável
                throw new RuntimeException("Erro ao conectar com o banco de dados.", e);
            }
        }
        return conn;
    }

    // Método para fechar a conexão com o banco de dados
    public static void fecharConexao() {
        if (conn != null) {
            try {
                conn.close();
                conn = null; // Importante para garantir que a conexão seja recriada na próxima chamada
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("Erro ao fechar a conexão com o banco de dados.", e);
            }
        }
    }
}
