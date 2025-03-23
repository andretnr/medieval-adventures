package firstAdventure.personagem;

import firstAdventure.models.GameContext;
import firstAdventure.models.Personagem;

import java.util.Objects;

public class AplicarNivel {

    static final int PONTOS_INICIAIS = 100; // Defina o valor que você achar apropriado
    static final double AUMENTO_POR_NIVEL = 1.15; // 15% de aumento por nível

    static void execute(int nvAdicionar) {
        Personagem person = GameContext.getInstance().getPersonagemSelecionado();
        int nvAtual = person.getNivel();
        int novoNivel = nvAtual + nvAdicionar;
        int ptAtual = person.getPontos();
        int novoPonto = ptAtual+ nvAdicionar * 5;
        person.setNivel(novoNivel);
        person.setPontos(novoPonto);
        person.setExperiencia(0);
    }

    static void verificarEvolucao() {
        Personagem personagemSelecionado = GameContext.getInstance().getPersonagemSelecionado();
        long experiencia = personagemSelecionado.getExperiencia();
        int nivel = personagemSelecionado.getNivel();

        // Calcular a quantidade de pontos necessários para o próximo nível
        int pontosParaProximoNivel = PONTOS_INICIAIS;

        // Calcular os pontos necessários até o nível atual
        for (int i = 1; i < nivel; i++) {
            pontosParaProximoNivel = (int) Math.ceil(pontosParaProximoNivel * AUMENTO_POR_NIVEL);
        }

        // Verificar se o personagem tem experiência suficiente para evoluir
        while (experiencia >= pontosParaProximoNivel) {
            // O personagem sobe de nível
            nivel++;

            // Subtrair os pontos para o próximo nível da experiência do personagem
            experiencia -= pontosParaProximoNivel;

            // Atualizar os pontos necessários para o próximo nível com o aumento de 15%
            pontosParaProximoNivel = (int) Math.ceil(pontosParaProximoNivel * AUMENTO_POR_NIVEL);
        }

        // Atualizar as informações do personagem após a evolução
        personagemSelecionado.setNivel(nivel);
        personagemSelecionado.setExperiencia(experiencia);

        // Se necessário, adicione alguma mensagem ou ação após a evolução
        System.out.println("O personagem subiu para o nível " + nivel + " com " + experiencia + " pontos de experiência restantes.");
    }
}
