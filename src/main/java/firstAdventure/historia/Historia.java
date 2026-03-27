package firstAdventure.historia;

/**
 * Contrato que toda história deve implementar.
 *
 * Para criar uma nova história:
 * 1. Implemente esta interface.
 * 2. Construa as {@link Cena}s no construtor.
 * 3. Registre-a no menu de aventura em {@code Options}.
 */
public interface Historia {

    /** Identificador único (usado para salvar estado no banco). */
    String getId();

    String getTitulo();

    String getDescricao();

    /** ID da cena inicial onde a aventura começa. */
    String getCenaInicialId();

    /** Retorna a cena pelo ID, ou {@code null} se não existir. */
    Cena getCena(String id);
}

