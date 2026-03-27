package firstAdventure.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoSQLite {

    private static final String URL = "jdbc:sqlite:jogo.db";

    private ConexaoSQLite() {}

    public static Connection conectar() {
        try {
            return DriverManager.getConnection(URL);
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
            return null;
        }
    }

    public static void criarTabela(String query) {
        Connection conn = conectar();
        if (conn == null) {
            System.err.println("Não foi possível criar tabela: conexão nula.");
            return;
        }
        try (conn; Statement stmt = conn.createStatement()) {
            stmt.execute(query);
            System.out.println("Tabela criada/verificada com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao criar tabela: " + e.getMessage());
        }
    }

}