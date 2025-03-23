package firstAdventure.personagem;

import firstAdventure.data.save.SalvarPersonagemDAO;
import firstAdventure.models.Personagem;

public class SalvarPersonagem {

    public static void execute(Personagem person){
        SalvarPersonagemDAO.execute(person);
        System.out.println("Aventureiro " + person.getClasse() + " " + person.getNome() + " Salvo com sucesso!");
    }
}
