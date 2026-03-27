package firstAdventure.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes de ValidaEntradas")
class ValidaEntradasTest {

    @Test
    @DisplayName("validaEscolhaSimOuNao deve aceitar 'S'")
    void deveAceitarS() {
        Scanner scan = new Scanner("S\n");
        String resultado = ValidaEntradas.validaEscolhaSimOuNao("S", scan);
        assertEquals("S", resultado);
    }

    @Test
    @DisplayName("validaEscolhaSimOuNao deve aceitar 'N'")
    void deveAceitarN() {
        Scanner scan = new Scanner("N\n");
        String resultado = ValidaEntradas.validaEscolhaSimOuNao("N", scan);
        assertEquals("N", resultado);
    }

    @Test
    @DisplayName("validaEscolhaSimOuNao deve aceitar 's' minúsculo")
    void deveAceitarSMinusculo() {
        Scanner scan = new Scanner("s\n");
        String resultado = ValidaEntradas.validaEscolhaSimOuNao("s", scan);
        assertEquals("s", resultado);
    }

    @Test
    @DisplayName("validaEscolhaSimOuNao deve rejeitar entrada inválida e pedir nova")
    void deveRejeitarEntradaInvalidaEPedirNova() {
        // Entrada inválida primeiro, depois "S"
        Scanner scan = new Scanner("X\nS\n");
        String resultado = ValidaEntradas.validaEscolhaSimOuNao("X", scan);
        assertEquals("S", resultado);
    }

    @Test
    @DisplayName("validaEntradaNumerico deve aceitar valor dentro do intervalo")
    void deveAceitarValorNoIntervalo() {
        Scanner scan = new Scanner("5\n");
        int resultado = ValidaEntradas.validaEntradaNumerico(1, 10, 5, scan);
        assertEquals(5, resultado);
    }

    @Test
    @DisplayName("validaEntradaNumerico deve aceitar valor mínimo")
    void deveAceitarValorMinimo() {
        Scanner scan = new Scanner("1\n");
        int resultado = ValidaEntradas.validaEntradaNumerico(1, 10, 1, scan);
        assertEquals(1, resultado);
    }

    @Test
    @DisplayName("validaEntradaNumerico deve aceitar valor máximo")
    void deveAceitarValorMaximo() {
        Scanner scan = new Scanner("10\n");
        int resultado = ValidaEntradas.validaEntradaNumerico(1, 10, 10, scan);
        assertEquals(10, resultado);
    }

    @Test
    @DisplayName("validaEntradaNumerico deve rejeitar valor fora do intervalo e pedir novo")
    void deveRejeitarValorForaDoIntervaloEPedirNovo() {
        // Valor inválido 15, depois válido 7
        Scanner scan = new Scanner("7\n");
        int resultado = ValidaEntradas.validaEntradaNumerico(1, 10, 15, scan);
        assertEquals(7, resultado);
    }
}

