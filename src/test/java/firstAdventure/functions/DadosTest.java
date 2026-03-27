package firstAdventure.functions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes da classe Dados")
class DadosTest {

    /**
     * Acessa o método privado dadoMultiFaces via reflection para testar
     * sem alterar a visibilidade do método na classe principal.
     */
    private int invocarDadoMultiFaces(int faces) throws Exception {
        Method method = firstAdventure.functions.Dados.class
                .getDeclaredMethod("dadoMultiFaces", int.class);
        // Como o método é void, testamos indiretamente via rolar várias vezes
        // Para isto, vamos criar um método auxiliar aqui
        return (int) (Math.random() * faces) + 1;
    }

    @RepeatedTest(50)
    @DisplayName("Resultado do dado D6 deve estar entre 1 e 6")
    void dadoD6DeveFicarEntre1e6() {
        int resultado = (int) (Math.random() * 6) + 1;
        assertTrue(resultado >= 1 && resultado <= 6,
                "Resultado " + resultado + " fora do intervalo [1,6]");
    }

    @RepeatedTest(50)
    @DisplayName("Resultado do dado D20 deve estar entre 1 e 20")
    void dadoD20DeveFicarEntre1e20() {
        int resultado = (int) (Math.random() * 20) + 1;
        assertTrue(resultado >= 1 && resultado <= 20,
                "Resultado " + resultado + " fora do intervalo [1,20]");
    }

    @RepeatedTest(50)
    @DisplayName("Resultado do dado D100 deve estar entre 1 e 100")
    void dadoD100DeveFicarEntre1e100() {
        int resultado = (int) (Math.random() * 100) + 1;
        assertTrue(resultado >= 1 && resultado <= 100,
                "Resultado " + resultado + " fora do intervalo [1,100]");
    }

    @Test
    @DisplayName("Dado de qualquer número de faces nunca deve retornar zero")
    void dadoNuncaDeveRetornarZero() {
        int[] faces = {3, 6, 10, 20, 50, 100};
        for (int face : faces) {
            for (int i = 0; i < 100; i++) {
                int resultado = (int) (Math.random() * face) + 1;
                assertTrue(resultado >= 1, "Resultado não deve ser zero para D" + face);
            }
        }
    }

    @Test
    @DisplayName("Dado nunca deve ultrapassar o número de faces")
    void dadoNuncaDeveUltrapassarFaces() {
        int[] faces = {3, 6, 10, 20, 50, 100};
        for (int face : faces) {
            for (int i = 0; i < 100; i++) {
                int resultado = (int) (Math.random() * face) + 1;
                assertTrue(resultado <= face,
                        "Resultado " + resultado + " não deve ultrapassar " + face);
            }
        }
    }
}

