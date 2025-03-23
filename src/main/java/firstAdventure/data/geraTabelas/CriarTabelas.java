package firstAdventure.data.geraTabelas;

import firstAdventure.data.ConexaoSQLite;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarTabelas {

    public static void criarTabelaPersonagem() {
        String sql = """
            CREATE TABLE IF NOT EXISTS Personagem (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                nome TEXT NOT NULL,
                idade INTEGER,
                classe TEXT,
                nivel INTEGER DEFAULT 1,
                forca INTEGER,
                destreza INTEGER,
                constituicao INTEGER,
                inteligencia INTEGER,
                sabedoria INTEGER,
                carisma INTEGER,
                vida REAL,
                energia REAL,
                sorte INTEGER,
                pontos INTEGER
            );
        """;

        criarTabela(sql);
    }

    public static void criarTabela(String query) {
        ConexaoSQLite.criarTabela(query);
    }

    public static void main(String[] args) {
        criarTabelaPersonagem();
    }
}
