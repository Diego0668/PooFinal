import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe responsável por estabelecer a conexão com o MySQL.
 */
public class Conexao {

    // Configurações do servidor (Ajustadas via Gerador)
    private static final String URL = "jdbc:mysql://localhost:3306/Adega";
    private static final String USER = "root";
    private static final String PASS = "D1egolima!";

    /**
     * Retorna um objeto de conexão ativa com o banco de dados.
     */
    public static Connection getConexao() {
        try {
            // Tenta estabelecer a conexão usando o DriverManager
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            // Lança uma exceção em caso de erro (ex: driver ausente, credenciais inválidas)
            throw new RuntimeException("Erro na conexão JDBC: " + e.getMessage());
        }
    }
}