package firstAdventure.data.geraTabelas;

import firstAdventure.data.ConexaoSQLite;

public class CriarTabelas {

    public static void criarTabelaPersonagem() {
        String sql = """
            CREATE TABLE IF NOT EXISTS Personagem (
                id          INTEGER PRIMARY KEY AUTOINCREMENT,
                nome        TEXT    NOT NULL,
                idade       INTEGER,
                classe      TEXT,
                nivel       INTEGER DEFAULT 1,
                forca       INTEGER,
                destreza    INTEGER,
                constituicao INTEGER,
                inteligencia INTEGER,
                sabedoria   INTEGER,
                carisma     INTEGER,
                vida        REAL,
                energia     REAL,
                sorte       INTEGER,
                pontos      INTEGER,
                experiencia INTEGER DEFAULT 0
            );
        """;

        ConexaoSQLite.criarTabela(sql);
    }

    public static void criarTabelaEstadoJogo() {
        String sql = """
            CREATE TABLE IF NOT EXISTS EstadoJogo (
                id             INTEGER PRIMARY KEY AUTOINCREMENT,
                personagem_id  INTEGER NOT NULL,
                historia_id    TEXT    NOT NULL,
                cena_atual_id  TEXT    NOT NULL,
                flags          TEXT    DEFAULT '',
                concluido      INTEGER DEFAULT 0
            );
        """;
        ConexaoSQLite.criarTabela(sql);
    }
}
