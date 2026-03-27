package firstAdventure.data.save;

import firstAdventure.data.ConexaoSQLite;
import firstAdventure.models.Personagem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SalvarPersonagemDAO {

    private static final String SQL = """
        INSERT INTO Personagem
            (nome, idade, classe, nivel, forca, destreza, constituicao,
             inteligencia, sabedoria, carisma, vida, energia, sorte, pontos, experiencia)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
    """;

    public static void execute(Personagem personagem) {
        Connection conn = ConexaoSQLite.conectar();
        if (conn == null) {
            System.err.println("Erro ao salvar personagem: conexão nula.");
            return;
        }
        try (conn; PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setString(1, personagem.getNome());
            pstmt.setInt(2, personagem.getIdade());
            pstmt.setString(3, personagem.getClasse().toString());
            pstmt.setInt(4, personagem.getNivel());
            pstmt.setInt(5, personagem.getForca());
            pstmt.setInt(6, personagem.getDestreza());
            pstmt.setInt(7, personagem.getConstituicao());
            pstmt.setInt(8, personagem.getInteligencia());
            pstmt.setInt(9, personagem.getSabedoria());
            pstmt.setInt(10, personagem.getCarisma());
            pstmt.setDouble(11, personagem.getVida());
            pstmt.setDouble(12, personagem.getEnergia());
            pstmt.setInt(13, personagem.getSorte());
            pstmt.setInt(14, personagem.getPontos());
            pstmt.setLong(15, personagem.getExperiencia());

            pstmt.executeUpdate();
            System.out.println("Personagem salvo com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao salvar personagem: " + e.getMessage());
        }
    }
}
