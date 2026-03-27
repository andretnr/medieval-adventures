package firstAdventure.models;

public class GameContext {
    private static volatile GameContext instance;
    private Personagem personagemSelecionado;

    private GameContext() {}

    public static GameContext getInstance() {
        if (instance == null) {
            synchronized (GameContext.class) {
                if (instance == null) {
                    instance = new GameContext();
                }
            }
        }
        return instance;
    }

    public Personagem getPersonagemSelecionado() {
        return personagemSelecionado;
    }

    public void setPersonagemSelecionado(Personagem personagem) {
        this.personagemSelecionado = personagem;
    }

    /** Reinicia o contexto — útil para testes unitários. */
    public static void resetInstance() {
        instance = null;
    }
}
