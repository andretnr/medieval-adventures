package firstAdventure.data.read;

import firstAdventure.data.ConexaoSQLite;
import firstAdventure.models.Personagem;
import firstAdventure.personagem.enums.Classes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BuscarPersonagensDAO {

    private static final String SQL = "SELECT * FROM Personagem";

    public static List<Personagem> execute() {
        List<Personagem> personagens = new ArrayList<>();

        Connection conn = ConexaoSQLite.conectar();
        if (conn == null) {
            System.err.println("Erro ao buscar personagens: conexão nula.");
            return personagens;
        }

        try (conn;
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {

            while (rs.next()) {
                Personagem personagem = new Personagem(
                        rs.getLong("id"),
                        rs.getString("nome"),
                        rs.getInt("idade"),
                        Classes.valueOf(rs.getString("classe")),
                        rs.getInt("nivel"),
                        rs.getInt("forca"),
                        rs.getInt("destreza"),
                        rs.getInt("constituicao"),
                        rs.getInt("inteligencia"),
                        rs.getInt("sabedoria"),
                        rs.getInt("carisma"),
                        rs.getDouble("vida"),
                        rs.getDouble("energia"),
                        rs.getInt("sorte"),
                        rs.getInt("pontos"),
                        rs.getLong("experiencia")
                );
                personagens.add(personagem);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar personagens: " + e.getMessage());
        }

        return personagens;
    }
}
