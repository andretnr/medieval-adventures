package firstAdventure.data.read;

import firstAdventure.data.ConexaoSQLite;
import firstAdventure.models.EstadoJogo;

import java.sql.*;

public class BuscarEstadoJogoDAO {

    private static final String SQL = """
        SELECT * FROM EstadoJogo
        WHERE personagem_id = ? AND historia_id = ? AND concluido = 0
        ORDER BY id DESC LIMIT 1
        """;

    public static EstadoJogo buscarAtivo(Long personagemId, String historiaId) {
        if (personagemId == null) return null;
        Connection conn = ConexaoSQLite.conectar();
        if (conn == null) return null;
        try (conn; PreparedStatement ps = conn.prepareStatement(SQL)) {
            ps.setLong(1, personagemId);
            ps.setString(2, historiaId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    EstadoJogo e = new EstadoJogo();
                    e.setId(rs.getLong("id"));
                    e.setPersonagemId(rs.getLong("personagem_id"));
                    e.setHistoriaId(rs.getString("historia_id"));
                    e.setCenaAtualId(rs.getString("cena_atual_id"));
                    e.setFlagsFromString(rs.getString("flags"));
                    e.setConcluido(rs.getInt("concluido") == 1);
                    return e;
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar estado: " + e.getMessage());
        }
        return null;
    }
}

