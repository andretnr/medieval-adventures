package firstAdventure.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

public class ConexaoSQLite {
    private static final String URL = "jdbc:sqlite:jogo.db"; // Arquivo do banco

    public static void main(String[] args) {
        Connection conn = conectar();
        if (conn != null) {
            System.out.println("Conexão bem-sucedida!");
        }
    }

    public static Connection conectar() {
        try {
            return DriverManager.getConnection(URL);
        } catch (SQLException e) {
            System.err.println("Erro ao conectar: " + e.getMessage());
            return null;
        }
    }

    public static void criarTabela(String query) {
        try (Connection conn = ConexaoSQLite.conectar()) {
            if(Objects.isNull(conn)){
                throw new SQLException();
            }
            Statement stmt = conn.createStatement();
            stmt.execute(query);
            System.out.println("Tabela criada com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao criar tabela: " + e.getMessage());
        }
    }

}