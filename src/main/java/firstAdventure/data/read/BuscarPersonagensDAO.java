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
import java.util.Objects;

public class BuscarPersonagensDAO {

    public static List<Personagem> execute() {
            List<Personagem> personagens = new ArrayList<>();
            String sql = "SELECT * FROM Personagem";

            try (Connection conn = ConexaoSQLite.conectar()) {
                if (Objects.isNull(conn)){
                    throw new SQLException();
                }
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

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

