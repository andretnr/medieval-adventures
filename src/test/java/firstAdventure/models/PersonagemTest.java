package firstAdventure.models;

import firstAdventure.personagem.enums.Classes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes da classe Personagem")
class PersonagemTest {

    private Personagem personagem;

    @BeforeEach
    void setUp() {
        personagem = new Personagem();
    }

    @Test
    @DisplayName("Deve setar atributos da classe ao definir a classe do personagem")
    void deveSetarAtributosAoDefinirClasse() {
        personagem.setClasse(Classes.GUERREIRO);

        assertEquals(Classes.GUERREIRO, personagem.getClasse());
        assertEquals(Classes.GUERREIRO.getForca(), personagem.getForca());
        assertEquals(Classes.GUERREIRO.getDestreza(), personagem.getDestreza());
        assertEquals(Classes.GUERREIRO.getConstituicao(), personagem.getConstituicao());
        assertEquals(Classes.GUERREIRO.getInteligencia(), personagem.getInteligencia());
        assertEquals(Classes.GUERREIRO.getSabedoria(), personagem.getSabedoria());
        assertEquals(Classes.GUERREIRO.getCarisma(), personagem.getCarisma());
    }

    @Test
    @DisplayName("Deve calcular vida positiva após definir classe")
    void deveCalcularVidaPositiva() {
        personagem.setClasse(Classes.GUERREIRO);
        assertTrue(personagem.getVida() > 0, "Vida deve ser maior que zero");
    }

    @Test
    @DisplayName("Deve calcular energia positiva após definir classe")
    void deveCalcularEnergiaPositiva() {
        personagem.setClasse(Classes.MAGO);
        assertTrue(personagem.getEnergia() > 0, "Energia deve ser maior que zero");
    }

    @Test
    @DisplayName("Deve atualizar vida e energia ao chamar calculaEvo()")
    void deveAtualizarVidaEEnergiaNoCalculaEvo() {
        personagem.setClasse(Classes.GUERREIRO);
        double vidaAntes = personagem.getVida();
        double energiaAntes = personagem.getEnergia();

        personagem.setForca(personagem.getForca() + 10);
        personagem.setConstituicao(personagem.getConstituicao() + 10);
        personagem.calculaEvo();

        assertTrue(personagem.getVida() >= vidaAntes, "Vida deve ser >= após aumentar atributos");
        assertTrue(personagem.getEnergia() >= energiaAntes, "Energia deve ser >= após aumentar atributos");
    }

    @Test
    @DisplayName("Construtor completo deve setar todos os campos corretamente")
    void construtorCompletoDeveSetarCampos() {
        Personagem p = new Personagem(1L, "Aragorn", 30, Classes.GUERREIRO,
                5, 8, 5, 9, 3, 4, 5, 100.0, 50.0, 7, 25, 500L);

        assertEquals(1L, p.getId());
        assertEquals("Aragorn", p.getNome());
        assertEquals(30, p.getIdade());
        assertEquals(Classes.GUERREIRO, p.getClasse());
        assertEquals(5, p.getNivel());
        assertEquals(500L, p.getExperiencia());
    }

    @Test
    @DisplayName("Deve setar e obter nome corretamente")
    void deveSetarEObterNome() {
        personagem.setNome("Legolas");
        assertEquals("Legolas", personagem.getNome());
    }

    @Test
    @DisplayName("Deve setar e obter pontos corretamente")
    void deveSetarEObterPontos() {
        personagem.setPontos(50);
        assertEquals(50, personagem.getPontos());
    }

    @Test
    @DisplayName("toString deve conter nome do personagem")
    void toStringShouldContainNome() {
        personagem.setNome("Gandalf");
        personagem.setClasse(Classes.MAGO);
        String resultado = personagem.toString();
        assertTrue(resultado.contains("Gandalf"), "toString deve conter o nome");
    }

    @Test
    @DisplayName("Mago deve ter mais energia que Guerreiro")
    void magoDeveTerMaisEnergiaCQueGuerreiro() {
        Personagem guerreiro = new Personagem();
        guerreiro.setClasse(Classes.GUERREIRO);

        Personagem mago = new Personagem();
        mago.setClasse(Classes.MAGO);

        assertTrue(mago.getEnergia() >= guerreiro.getEnergia(),
                "Mago deve ter energia >= Guerreiro");
    }

    @Test
    @DisplayName("Guerreiro deve ter mais vida que Mago")
    void guerreiroDeveTerMaisVidaQueMago() {
        Personagem guerreiro = new Personagem();
        guerreiro.setClasse(Classes.GUERREIRO);

        Personagem mago = new Personagem();
        mago.setClasse(Classes.MAGO);

        assertTrue(guerreiro.getVida() >= mago.getVida(),
                "Guerreiro deve ter vida >= Mago");
    }
}

