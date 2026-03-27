package firstAdventure.historia;

public class Inimigo {
    private final String nome;
    private final double vidaMaxima;
    private final int forca;
    private final int xpRecompensa;

    public Inimigo(String nome, double vidaMaxima, int forca, int xpRecompensa) {
        this.nome = nome;
        this.vidaMaxima = vidaMaxima;
        this.forca = forca;
        this.xpRecompensa = xpRecompensa;
    }

    public String getNome()          { return nome; }
    public double getVidaMaxima()    { return vidaMaxima; }
    public int getForca()            { return forca; }
    public int getXpRecompensa()     { return xpRecompensa; }
}

