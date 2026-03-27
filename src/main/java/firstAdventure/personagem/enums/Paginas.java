package firstAdventure.personagem.enums;

public enum Paginas {

    PAGINA_1("Texto escrito na página 1", 34, 17),
    PAGINA_34("TEXTO DA PAGINA 34", 10, 25),
    PAGINA_17("TEXTO DA PAGINA 17", 10, 1);

    private final String texto;
    private final int proximaPaginaA;
    private final int proximaPaginaB;

    Paginas(String texto, int proximaPaginaA, int proximaPaginaB) {
        this.texto = texto;
        this.proximaPaginaA = proximaPaginaA;
        this.proximaPaginaB = proximaPaginaB;
    }

    public String getTexto() { return texto; }
    public int getProximaPaginaA() { return proximaPaginaA; }
    public int getProximaPaginaB() { return proximaPaginaB; }
}
