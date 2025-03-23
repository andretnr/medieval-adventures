package firstAdventure.personagem;

import firstAdventure.models.GameContext;
import firstAdventure.models.Personagem;
import firstAdventure.personagem.enums.Classes;
import firstAdventure.utils.ValidaEntradas;

import java.util.Objects;
import java.util.Scanner;

import static firstAdventure.personagem.AplicarNivel.verificarEvolucao;

public class GerarPersonagem {

    public static void execute(Scanner entrada) {

        Personagem person = new Personagem();
        System.out.println("Primeiramente vamos criar seu personagem, nesse momento escolha o nome e a idade do seu personagem: ");
        System.out.println("Nome do seu personagem:");
        String nome = entrada.nextLine();
        person.setNome(nome);
        System.out.println("Idade do seu personagem:");


            int idade = entrada.nextInt();
            idade = ValidaEntradas.validaEntradaNumerico(13, 299, idade, entrada);
            person.setIdade(idade);


        // System.out.println("\nAgora vamos definir os atributos básicos do seu personagem!\n\n");
        System.out.println("\nAgora vamos selecionar a classe do seu personagem (escolha peloo número):");
        selecionarClasse(person, entrada);
        System.out.println("Classe Selecionada: " + person.getClasse());


        System.out.println("\nSelecione o nível inicial de seu personagem (1 a 5): ");
        int nvInicial = entrada.nextInt();
        ValidaEntradas.validaEntradaNumerico(1,5, nvInicial, entrada);
        GameContext.getInstance().setPersonagemSelecionado(person);
        AplicarNivel.execute(nvInicial);
        verificarEvolucao();

        System.out.println(person.detalhadoPersonagem());

    }


    public static void selecionarClasse(Personagem person, Scanner entry) {
        boolean classeConfirmada = false;
        Classes classeEscolhida = null;

        while (!classeConfirmada) {
            for (Classes classe : Classes.values()) {
                System.out.println(classe.getId() + " - " + classe.name() + ": " + classe.getDescricao());
            }
            System.out.println("\nDigite o número da classe que você deseja escolher: ");
            int idSelecionado = entry.nextInt();
            ValidaEntradas.validaEntradaNumerico(1, 8, idSelecionado, entry);
            classeEscolhida = Classes.getById(idSelecionado);

            if (Objects.isNull(classeEscolhida)) {
                System.out.println("Classe inválida! Escolha um número válido.");
                continue;
            }

            System.out.println("\nVocê escolheu: " + classeEscolhida.name());
            System.out.println("Atributos:");
            System.out.println("Força: " + classeEscolhida.getForca() + ", \nDestreza: " + classeEscolhida.getDestreza() +
                    ", \nConstituição: " + classeEscolhida.getConstituicao() + ", \nInteligência: " + classeEscolhida.getInteligencia() +
                    ", \nSabedoria: " + classeEscolhida.getSabedoria() + ", \nCarisma: " + classeEscolhida.getCarisma());

            System.out.println("\nConfirma a escolha dessa classe? S/N");
            String select = entry.next();
            ValidaEntradas.validaEscolhaSimOuNao(select, entry);

            if ("S".equalsIgnoreCase(select)) {
                classeConfirmada = true;
            } else {
                System.out.println("Escolha cancelada. Selecione novamente.");
            }
        }
        person.setClasse(classeEscolhida);
    }
}
