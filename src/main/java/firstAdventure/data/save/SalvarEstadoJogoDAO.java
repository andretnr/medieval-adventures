package firstAdventure.data.save;

import firstAdventure.data.ConexaoSQLite;
import firstAdventure.models.EstadoJogo;

import java.sql.*;

public class SalvarEstadoJogoDAO {

    private static final String SQL_INSERT = """
        INSERT INTO EstadoJogo (personagem_id, historia_id, cena_atual_id, flags, concluido)
        VALUES (?, ?, ?, ?, ?)
        """;

    private static final String SQL_UPDATE = """
        UPDATE EstadoJogo
        SET cena_atual_id = ?, flags = ?, concluido = ?
        WHERE id = ?
        """;

    public static void salvar(EstadoJogo estado) {
        Connection conn = ConexaoSQLite.conectar();
        if (conn == null) return;
        try (conn; PreparedStatement ps = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {
            ps.setLong(1, estado.getPersonagemId());
            ps.setString(2, estado.getHistoriaId());
            ps.setString(3, estado.getCenaAtualId());
            ps.setString(4, estado.getFlagsAsString());
            ps.setInt(5, estado.isConcluido() ? 1 : 0);
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) estado.setId(rs.getLong(1));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao salvar estado: " + e.getMessage());
        }
    }

    public static void atualizar(EstadoJogo estado) {
        if (estado.getId() == null) { salvar(estado); return; }
        Connection conn = ConexaoSQLite.conectar();
        if (conn == null) return;
        try (conn; PreparedStatement ps = conn.prepareStatement(SQL_UPDATE)) {
            ps.setString(1, estado.getCenaAtualId());
            ps.setString(2, estado.getFlagsAsString());
            ps.setInt(3, estado.isConcluido() ? 1 : 0);
            ps.setLong(4, estado.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar estado: " + e.getMessage());
        }
    }
}

