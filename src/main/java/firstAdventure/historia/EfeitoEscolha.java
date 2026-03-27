package firstAdventure.historia;

public class EfeitoEscolha {

    public static final EfeitoEscolha VAZIO = new EfeitoEscolha(0, 0, null);

    private final int xpGanho;
    private final double vidaRecuperada;
    private final String flagAdicionar;

    public EfeitoEscolha(int xpGanho, double vidaRecuperada, String flagAdicionar) {
        this.xpGanho = xpGanho;
        this.vidaRecuperada = vidaRecuperada;
        this.flagAdicionar = flagAdicionar;
    }

    public int getXpGanho()              { return xpGanho; }
    public double getVidaRecuperada()    { return vidaRecuperada; }
    public String getFlagAdicionar()     { return flagAdicionar; }
    public boolean temFlag()             { return flagAdicionar != null && !flagAdicionar.isEmpty(); }
}

