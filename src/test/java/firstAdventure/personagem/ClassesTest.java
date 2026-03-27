package firstAdventure.personagem;

import firstAdventure.personagem.enums.Classes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes do enum Classes")
class ClassesTest {

    @Test
    @DisplayName("getById deve retornar a classe correta pelo ID")
    void getByIdDeveRetornarClasseCorreta() {
        assertEquals(Classes.GUERREIRO, Classes.getById(1));
        assertEquals(Classes.MAGO,      Classes.getById(2));
        assertEquals(Classes.LADINO,    Classes.getById(3));
        assertEquals(Classes.CLERIGO,   Classes.getById(4));
        assertEquals(Classes.ARQUEIRO,  Classes.getById(5));
        assertEquals(Classes.BÁRBARO,   Classes.getById(6));
        assertEquals(Classes.PALADINO,  Classes.getById(7));
        assertEquals(Classes.DRUIDA,    Classes.getById(8));
    }

    @Test
    @DisplayName("getById deve retornar null para ID inexistente")
    void getByIdDeveRetornarNullParaIdInexistente() {
        assertNull(Classes.getById(99));
        assertNull(Classes.getById(0));
        assertNull(Classes.getById(-1));
    }

    @ParameterizedTest(name = "Classe ID={0} deve ter atributos positivos")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8})
    @DisplayName("Todas as classes devem ter atributos positivos")
    void todasClassesDevemTerAtributosPositivos(int id) {
        Classes c = Classes.getById(id);
        assertNotNull(c);
        assertTrue(c.getForca()       > 0, c + " forca deve ser > 0");
        assertTrue(c.getDestreza()    > 0, c + " destreza deve ser > 0");
        assertTrue(c.getConstituicao()> 0, c + " constituicao deve ser > 0");
        assertTrue(c.getInteligencia()> 0, c + " inteligencia deve ser > 0");
        assertTrue(c.getSabedoria()   > 0, c + " sabedoria deve ser > 0");
        assertTrue(c.getCarisma()     > 0, c + " carisma deve ser > 0");
    }

    @Test
    @DisplayName("Todas as classes devem ter descrição não nula e não vazia")
    void todasClassesDevemTerDescricaoNaoVazia() {
        for (Classes c : Classes.values()) {
            assertNotNull(c.getDescricao(), c + " deve ter descrição não nula");
            assertFalse(c.getDescricao().isBlank(), c + " deve ter descrição não vazia");
        }
    }

    @Test
    @DisplayName("Guerreiro deve ter força maior que Mago")
    void guerreiroDeveTerForcaMaiorQueMago() {
        assertTrue(Classes.GUERREIRO.getForca() > Classes.MAGO.getForca());
    }

    @Test
    @DisplayName("Mago deve ter inteligência maior que Guerreiro")
    void magoDeveTerInteligenciaMaiorQueGuerreiro() {
        assertTrue(Classes.MAGO.getInteligencia() > Classes.GUERREIRO.getInteligencia());
    }

    @Test
    @DisplayName("Bárbaro deve ter a maior força de todas as classes")
    void barbaroDeveTerMaiorForca() {
        int forcaBarbaro = Classes.BÁRBARO.getForca();
        for (Classes c : Classes.values()) {
            assertTrue(forcaBarbaro >= c.getForca(),
                    "Bárbaro deve ter força >= " + c.name());
        }
    }
}

