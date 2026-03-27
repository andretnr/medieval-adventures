package firstAdventure.utils;

import firstAdventure.models.Personagem;
import firstAdventure.personagem.enums.Classes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes de ValidaPontos")
class ValidaPontosTest {

    private Personagem personagem;

    @BeforeEach
    void setUp() {
        personagem = new Personagem();
        personagem.setClasse(Classes.GUERREIRO);
    }

    @Test
    @DisplayName("hasPontos deve retornar true quando pontos > 0")
    void hasPontosDeveRetornarTrueQuandoPositivo() {
        personagem.setPontos(10);
        assertTrue(ValidaPontos.hasPontos(personagem));
    }

    @Test
    @DisplayName("hasPontos deve retornar false quando pontos == 0")
    void hasPontosDeveRetornarFalseQuandoZero() {
        personagem.setPontos(0);
        assertFalse(ValidaPontos.hasPontos(personagem));
    }

    @Test
    @DisplayName("execute deve retornar true quando há pontos e usuário escolhe S")
    void executeDeveRetornarTrueComPontosES() {
        personagem.setPontos(10);
        Scanner scan = new Scanner("S\n");
        boolean resultado = ValidaPontos.execute(personagem, scan);
        assertTrue(resultado);
    }

    @Test
    @DisplayName("execute deve retornar false quando há pontos e usuário escolhe N")
    void executeDeveRetornarFalseComPontosEN() {
        personagem.setPontos(10);
        Scanner scan = new Scanner("N\n");
        boolean resultado = ValidaPontos.execute(personagem, scan);
        assertFalse(resultado);
    }

    @Test
    @DisplayName("execute deve retornar false quando não há pontos")
    void executeDeveRetornarFalseSemPontos() {
        personagem.setPontos(0);
        Scanner scan = new Scanner("");
        boolean resultado = ValidaPontos.execute(personagem, scan);
        assertFalse(resultado);
    }
}

