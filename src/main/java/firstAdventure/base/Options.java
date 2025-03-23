package firstAdventure.base;

import firstAdventure.functions.Dados;
import firstAdventure.models.GameContext;
import firstAdventure.models.Personagem;
import firstAdventure.personagem.DistribuirPontos;
import firstAdventure.personagem.GerarPersonagem;
import firstAdventure.personagem.SalvarPersonagem;
import firstAdventure.personagem.SelecionarPersonagem;
import firstAdventure.utils.PrintMapTable;
import firstAdventure.utils.ValidaEntradas;
import firstAdventure.utils.ValidaPontos;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Options {
    public static void execute(Scanner scan) {
        boolean continuar = true;
        while (continuar) {
            System.out.println("\nSelecione uma opção: ");
            Map<Integer, String> options = optionsMap();
            PrintMapTable.execute(options);
            int selectedOption = scan.nextInt();
            ValidaEntradas.validaEntradaNumerico(1, options.size(), selectedOption, scan);
            continuar = executeSelectedOption(selectedOption, scan);
        }
    }

    private static boolean executeSelectedOption(int selectedOption, Scanner scan) {
        switch (selectedOption) {
            case 1:
                iniciarAventura(scan);
                break;
            case 2:
                Personagem person = criarPersonagem(scan);
                salvarPersonagem(person, scan);
                break;
            case 3:
                selecionarPersonagem(scan);
                break;
            case 4:
                rolarDados(scan);
                break;
            case 5:
                TelaEncerramento.execute();
                return false;
            default:
                System.out.println("Opção inválida! Tente novamente.");
                break;
        }
        return true;
    }


    private static Map<Integer, String> optionsMap() {
        Map<Integer, String> options = new HashMap<>();
        options.put(1, "Iniciar aventura");
        options.put(2, "Criar Personagem");
        options.put(3, "Selecionar personagem");
        options.put(4, "Testar a sorte");
        options.put(5, "Encerrar jogo!");
        return options;
    }

    private static void iniciarAventura(Scanner scan) {
        System.out.println("Aqui iniciamos a aventura!");
        System.out.println("Aventura ainda não implmentada!");
        execute(scan);
    }

    private static void salvarPersonagem(Personagem person, Scanner entrada) {
        System.out.println("Deseja salvar o " + person.getNome() + "? (S/N)");
        String decisao = entrada.nextLine();
        ValidaEntradas.validaEscolhaSimOuNao(decisao, entrada);
        SalvarPersonagem.execute(person);
        GameContext.getInstance().setPersonagemSelecionado(person);

    }

    private static Personagem criarPersonagem(Scanner entrada) {
        GerarPersonagem.execute(entrada);
        Personagem person = GameContext.getInstance().getPersonagemSelecionado();
        if(ValidaPontos.execute(person, entrada)){
            distribuirPontos(person, entrada);
        }
        System.out.println(person.detalhadoPersonagem());
        return person;
    }


    private static void rolarDados(Scanner scan) {
        Dados.execute(scan);
    }

    public static void distribuirPontos(Personagem person, Scanner entrada) {
        DistribuirPontos.execute(person, entrada);
    }


    private static void selecionarPersonagem(Scanner scan) {
        SelecionarPersonagem.execute(scan);

    }




}
