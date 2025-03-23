package firstAdventure.models;

public class GameContext {
    private static GameContext instance;
    private Personagem personagemSelecionado;

    private GameContext() {}

    public static GameContext getInstance() {
        if (instance == null) {
            instance = new GameContext();
        }
        return instance;
    }

    public Personagem getPersonagemSelecionado() {
        return personagemSelecionado;
    }

    public void setPersonagemSelecionado(Personagem personagem) {
        this.personagemSelecionado = personagem;
    }
}
