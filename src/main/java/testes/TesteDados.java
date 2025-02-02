package testes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TesteDados {

    public static void contarNumeros(List<Integer> array) {
        Map<Integer, Integer> contagem = new HashMap<>();
        for (int num : array) {
            contagem.put(num, contagem.getOrDefault(num, 0) + 1);
        }
        System.out.println("Quantidade de cada número:");
        for (Map.Entry<Integer, Integer> entry : contagem.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
