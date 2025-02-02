package desafios;

import javax.swing.*;
import java.util.Arrays;

public class WorkTrueOrFalse {

    public static void main(String[] args) {

        //Codigo de quando eu estava aprendendo:

        System.out.println(Arrays.toString(args));

        if (Arrays.asList(args).contains("flagC")) {
            System.out.println("flagC is present");
        } else {
            System.out.println("flagC is not present");
        }

//        String tipoAMensagem = JOptionPane.showInputDialog(null, "Tipo a mensagem");
//
//        System.out.println(tipoAMensagem.getClass());
//        System.out.println(tipoAMensagem);
//
//
//        Object[] options = {"Sim", "Não"};
//        int input = JOptionPane.showOptionDialog(null, "Você trabalhou na segunda?", "Trabalho",
//                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
//                null, options, options[0]);
//
//        int input2 = JOptionPane.showOptionDialog(null, "Você trabalhou na sexta?", "Trabalho",
//                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
//                null, options, options[0]);
//
//        boolean segunda = (input == 0);
//        boolean sexta =  (input2 == 0);
//
//        if(segunda & sexta) {
//            JOptionPane.showMessageDialog(null, "Tomamos sorvete e compramos a TV de 50 polegadas!");
//        } else if (segunda || sexta) {
//            JOptionPane.showMessageDialog(null, "tomamos sorvete e compramos a tv de 32 polegadas!");
//        } else {
//            JOptionPane.showMessageDialog(null, "Não tomamos sorvete nem compramos a TV!");
//        }

    }
}
