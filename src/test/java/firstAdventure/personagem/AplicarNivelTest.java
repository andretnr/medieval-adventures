package firstAdventure.personagem;

import firstAdventure.models.GameContext;
import firstAdventure.models.Personagem;
import firstAdventure.personagem.enums.Classes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes de AplicarNivel")
class AplicarNivelTest {

    @BeforeEach
    void setUp() {
        GameContext.resetInstance();
        Personagem p = new Personagem();
        p.setClasse(Classes.GUERREIRO);
        p.setNivel(1);
        p.setPontos(0);
        p.setExperiencia(0);
        GameContext.getInstance().setPersonagemSelecionado(p);
    }

    @Test
    @DisplayName("Execute deve aumentar nível corretamente")
    void executeDeveAumentarNivel() {
        AplicarNivel.execute(3);
        Personagem p = GameContext.getInstance().getPersonagemSelecionado();
        assertEquals(4, p.getNivel());
    }

    @Test
    @DisplayName("Execute deve adicionar 5 pontos por nível adicionado")
    void executeDeveAdicionarCincoPontosPorNivel() {
        AplicarNivel.execute(2);
        Personagem p = GameContext.getInstance().getPersonagemSelecionado();
        assertEquals(10, p.getPontos());
    }

    @Test
    @DisplayName("Execute deve zerar experiência")
    void executeDeveZerarExperiencia() {
        GameContext.getInstance().getPersonagemSelecionado().setExperiencia(500);
        AplicarNivel.execute(1);
        assertEquals(0, GameContext.getInstance().getPersonagemSelecionado().getExperiencia());
    }

    @Test
    @DisplayName("calcularXpParaNivel nível 1 deve retornar PONTOS_INICIAIS")
    void calcularXpNivel1DeveRetornarPontosIniciais() {
        int xp = AplicarNivel.calcularXpParaNivel(1);
        assertEquals(AplicarNivel.PONTOS_INICIAIS, xp);
    }

    @Test
    @DisplayName("calcularXpParaNivel deve crescer 15% por nível")
    void calcularXpDeveAumentarPorNivel() {
        int xpNivel1 = AplicarNivel.calcularXpParaNivel(1);
        int xpNivel2 = AplicarNivel.calcularXpParaNivel(2);
        int esperado = (int) Math.ceil(xpNivel1 * AplicarNivel.AUMENTO_POR_NIVEL);
        assertEquals(esperado, xpNivel2);
    }

    @Test
    @DisplayName("verificarEvolucao deve evoluir personagem com XP suficiente")
    void verificarEvolucaoDeveEvoluirComXpSuficiente() {
        Personagem p = GameContext.getInstance().getPersonagemSelecionado();
        p.setExperiencia(200); // suficiente para pelo menos 1 nível (100 XP)
        AplicarNivel.verificarEvolucao();
        assertTrue(p.getNivel() > 1, "Personagem deve ter subido de nível");
    }

    @Test
    @DisplayName("verificarEvolucao não deve evoluir sem XP suficiente")
    void verificarEvolucaoNaoDeveEvoluirSemXp() {
        Personagem p = GameContext.getInstance().getPersonagemSelecionado();
        p.setExperiencia(50); // insuficiente para nível 1 (100 XP necessários)
        AplicarNivel.verificarEvolucao();
        assertEquals(1, p.getNivel(), "Nível não deve mudar sem XP suficiente");
    }
}

