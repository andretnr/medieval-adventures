package firstAdventure.personagem;

import firstAdventure.models.GameContext;
import firstAdventure.models.Personagem;

public class AplicarNivel {

    public static final int PONTOS_INICIAIS = 100;
    public static final double AUMENTO_POR_NIVEL = 1.15; // 15% por nível

    /** Adiciona níveis ao personagem do contexto e distribui pontos. */
    public static void execute(int nvAdicionar) {
        Personagem person = GameContext.getInstance().getPersonagemSelecionado();
        int novoNivel = person.getNivel() + nvAdicionar;
        int novosPontos = person.getPontos() + nvAdicionar * 5;
        person.setNivel(novoNivel);
        person.setPontos(novosPontos);
        person.setExperiencia(0);
    }

    /** Verifica se o personagem tem XP suficiente para evoluir e aplica os níveis. */
    public static void verificarEvolucao() {
        Personagem personagem = GameContext.getInstance().getPersonagemSelecionado();
        long experiencia = personagem.getExperiencia();
        int nivel = personagem.getNivel();

        int pontosParaProximoNivel = calcularXpParaNivel(nivel);

        while (experiencia >= pontosParaProximoNivel) {
            experiencia -= pontosParaProximoNivel;
            nivel++;
            pontosParaProximoNivel = (int) Math.ceil(pontosParaProximoNivel * AUMENTO_POR_NIVEL);
        }

        personagem.setNivel(nivel);
        personagem.setExperiencia(experiencia);
        System.out.printf("Personagem no nível %d com %d XP restantes.%n", nivel, experiencia);
    }

    /**
     * Calcula o XP necessário para atingir o nível informado.
     *
     * @param nivel nível atual (base 1)
     * @return XP necessário para o próximo nível
     */
    public static int calcularXpParaNivel(int nivel) {
        int pontos = PONTOS_INICIAIS;
        for (int i = 1; i < nivel; i++) {
            pontos = (int) Math.ceil(pontos * AUMENTO_POR_NIVEL);
        }
        return pontos;
    }
}
