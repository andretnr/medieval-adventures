package firstAdventure.data.update;

import firstAdventure.data.ConexaoSQLite;
import firstAdventure.models.Personagem;

import java.sql.*;

/** Atualiza os atributos dinâmicos do personagem após uma aventura. */
public class AtualizarPersonagemDAO {

    private static final String SQL = """
        UPDATE Personagem
        SET vida = ?, energia = ?, experiencia = ?, nivel = ?, pontos = ?
        WHERE id = ?
        """;

    public static void execute(Personagem personagem) {
        if (personagem.getId() == null) return;
        Connection conn = ConexaoSQLite.conectar();
        if (conn == null) return;
        try (conn; PreparedStatement ps = conn.prepareStatement(SQL)) {
            ps.setDouble(1, personagem.getVida());
            ps.setDouble(2, personagem.getEnergia());
            ps.setLong(3, personagem.getExperiencia());
            ps.setInt(4, personagem.getNivel());
            ps.setInt(5, personagem.getPontos());
            ps.setLong(6, personagem.getId());
            ps.executeUpdate();
            System.out.println("Progresso do personagem salvo!");
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar personagem: " + e.getMessage());
        }
    }
}

