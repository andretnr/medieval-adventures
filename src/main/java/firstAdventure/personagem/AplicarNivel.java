package firstAdventure.personagem;

import firstAdventure.models.Personagem;

public class AplicarNivel {

    static void execute(Personagem person, int nvAdicionar) {
        int nvAtual = person.getNivel();
        int novoNivel = nvAtual + nvAdicionar;
        int ptAtual = person.getPontos();
        int novoPonto = ptAtual+ nvAdicionar * 5;
        person.setNivel(novoNivel);
        person.setPontos(novoPonto);
    }
}
