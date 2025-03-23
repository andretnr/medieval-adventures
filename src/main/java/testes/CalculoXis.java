package testes;

import java.util.*;

public class CalculoXis {

    public static void main(String[] args) {

        

//        // Criando personagens para diferentes dimensões
//        List<String> universo1 = new ArrayList<>(Arrays.asList("Rick", "Morty"));
//        List<String> universo2 = new ArrayList<>(Arrays.asList("Batman", "Coringa"));
//        List<String> universo3 = new ArrayList<>(Arrays.asList("Goku", "Vegeta"));
//        List<String> universo4 = new ArrayList<>(Arrays.asList("Harry Potter", "Voldemort"));
//
//        // Criando dimensões dentro de dimensões
//        List<List<String>> dimensao1 = new ArrayList<>();
//        dimensao1.add(universo1);
//
//        List<List<String>> dimensao2 = new ArrayList<>();
//        dimensao2.add(universo2);
//
//        List<List<List<String>>> multiverso1 = new ArrayList<>();
//        multiverso1.add(dimensao1);
//        multiverso1.add(dimensao2);
//
//        List<List<List<String>>> multiverso2 = new ArrayList<>();
//        multiverso2.add(Collections.singletonList(universo3));
//        multiverso2.add(Collections.singletonList(universo4));
//
//        // Criando o multiverso definitivo
//        List<List<List<List<String>>>> listaDaListaDaListaDePessoas = new ArrayList<>();
//        listaDaListaDaListaDePessoas.add(multiverso1);
//        listaDaListaDaListaDePessoas.add(multiverso2);
//
//        // Impressão da estrutura multiversal
//        System.out.println("🌌 Bem-vindo ao Multiverso das Listas! 🌌\n");
//        System.out.println("Aqui estão os universos existentes:");
//        System.out.println(listaDaListaDaListaDePessoas);
//
//        // Explorando dimensões específicas
//        System.out.println("\n📡 Acessando personagens em diferentes realidades...");
//        System.out.println("🔹 No Universo 1, temos: " + listaDaListaDaListaDePessoas.get(0).get(0).get(0));
//        System.out.println("🔹 No Universo 2, temos: " + listaDaListaDaListaDePessoas.get(0).get(1).get(0));
//        System.out.println("🔹 No Universo 3, temos: " + listaDaListaDaListaDePessoas.get(1).get(0).get(0));
//        System.out.println("🔹 No Universo 4, temos: " + listaDaListaDaListaDePessoas.get(1).get(1).get(0));
//
//        // Mensagem final
//        System.out.println("\n🌀 Cuidado! Se você se perder nessa Matrioska de universos, pode nunca mais voltar! 🤯");


//        List<List<List<List<String>>>> listaDaListaDaListaDePessoas = new ArrayList<>();
//
//        // Criando os níveis internos da lista
//        List<String> pessoa = new ArrayList<>();
//        pessoa.add("João");
//        pessoa.add("Maria");
//
//        List<List<String>> listaDePessoas = new ArrayList<>();
//        listaDePessoas.add(pessoa);
//
//        List<List<List<String>>> listaDaListaDePessoas = new ArrayList<>();
//        listaDaListaDePessoas.add(listaDePessoas);
//
//        listaDaListaDaListaDePessoas.add(listaDaListaDePessoas);
//
//        // Impressão engraçada
//        System.out.println("Bem-vindo à Matrioska das listas! 🎭");
//        System.out.println("Aqui está o seu universo de pessoas:");
//        System.out.println(listaDaListaDaListaDePessoas);
//        System.out.println("\nAgora, vamos acessar as pessoas...");
//
//        System.out.println("Lista da Lista da Lista da Lista -> " +
//                listaDaListaDaListaDePessoas.get(0)
//                        .get(0)
//                        .get(0)
//                        .get(0)); // João
//
//        System.out.println("Lista da Lista da Lista da Lista -> " +
//                listaDaListaDaListaDePessoas.get(0)
//                        .get(0)
//                        .get(0)
//                        .get(1)); // Maria
//
//        System.out.println("\nIsso foi confuso? Bem-vindo à programação! 😂");


//        Map<String, Pessoa> pessoasMap = new HashMap<>();
//
//        Pessoa pessoaOne = new Pessoa();
//        pessoaOne.setNome("Karen");
//        pessoaOne.setIdade(15);
//        pessoaOne.setCidade("SP");
//
//
//        Pessoa pessoaTwo = new Pessoa();
//        pessoaTwo.setNome("Ed");
//        pessoaTwo.setIdade(20);
//        pessoaTwo.setCidade("SP");
//
//        Pessoa pessoaThree = new Pessoa();
//        pessoaThree.setNome("Bela");
//        pessoaThree.setIdade(17);
//        pessoaThree.setCidade("OS");
//
//        Pessoa pessoaFour = new Pessoa();
//        pessoaFour.setNome("Andre");
//        pessoaFour.setIdade(12);
//        pessoaFour.setCidade("SA");
//
//        pessoasMap.put(pessoaOne.getNome(), pessoaOne);
//        pessoasMap.put(pessoaTwo.getNome(), pessoaTwo);
//        pessoasMap.put(pessoaThree.getNome(), pessoaThree);
//        pessoasMap.put(pessoaFour.getNome(), pessoaFour);
//
////
//        Pessoa pesseaGet = pessoasMap.get("Bela");
//        System.out.println(pesseaGet.toString());



//        int operador1 = 5;
//        int operador2 = 6;
//        int armazenado = 8;
//        int proximoSequencia = 0;
//
//
//        List<Integer> numbers = new ArrayList<>();
//        numbers.add(1);
//        numbers.add(2);
//        numbers.add(3);
//        numbers.add(5);
//        numbers.add(8);
//
//        List<String> letras = new ArrayList<>();
//        letras.add("A");
//        letras.add("B");
//        letras.add("C");



//        List<Double> decimais = new ArrayList<>();
//        decimais.add(10.10);
//        decimais.add(2.26);
//        decimais.add(330.18);
//        decimais.add(9.9);
//
//
//        List<List<?>> matriz = new ArrayList<>();
//
//        matriz.add(numbers);
//        matriz.add(letras);
//        matriz.add(decimais);
//
//        System.out.println(matriz);








//        numbers.add(5);
//        numbers.add(6);
//        numbers.add(8);
//
//        for(int i = 4; i <= 50; i++ ) {
//
//
//            proximoSequencia = soma(operador1, operador2);
//
//            numbers.add(proximoSequencia);
//            operador1 = operador2;
//            operador2 = armazenado;
//            armazenado = proximoSequencia;
//
//
//        }
//
//        System.out.println(numbers);
//        System.out.println("O quiquagessimo numero é : "+ numbers.get(49));

//        int i = 3;
//
//        while (i < 50) {
//
//            proximoSequencia = soma(operador1, operador2);
//            operador1 = operador2;
//            operador2 = armazenado;
//            armazenado = proximoSequencia;
//            i++;
//
//        }

      //  System.out.println("resultado: "+proximoSequencia);




    }


    static Integer soma(int n1, int n2) {
        int resultado;
        resultado = n1 + n2;
        return resultado;
    }

}
