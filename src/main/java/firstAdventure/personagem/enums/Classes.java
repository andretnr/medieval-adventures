package firstAdventure.personagem.enums;

public enum Classes {

    GUERREIRO(1, "Forte e resistente, especializado em combate corpo a corpo.", 8, 5, 9, 3, 4, 5),
    MAGO(2, "Mestre das artes arcanas, usa magia poderosa, mas é fisicamente frágil.", 2, 5, 3, 10, 6, 7),
    LADINO(3, "Ágil e furtivo, especialista em ataques surpresa e desarmamento de armadilhas.", 4, 9, 5, 6, 5, 6),
    CLERIGO(4, "Usa magia divina para curar aliados e combater forças malignas.", 5, 5, 6, 6, 9, 7),
    ARQUEIRO(5, "Especialista em combate à distância, usando arcos e flechas com precisão.", 5, 8, 5, 5, 5, 6),
    BÁRBARO(6, "Lutador feroz que entra em fúria para aumentar sua força e resistência.", 10, 5, 10, 2, 3, 4),
    PALADINO(7, "Guerreiro sagrado que combina habilidades marciais com magia divina.", 7, 4, 8, 5, 8, 7),
    DRUIDA(8, "Guardião da natureza, capaz de se transformar em animais e conjurar magias naturais.", 4, 6, 5, 7, 9, 6);

    private final int id;
    private final String descricao;
    private final int forca;
    private final int destreza;
    private final int constituicao;
    private final int inteligencia;
    private final int sabedoria;
    private final int carisma;

    // Construtor do enum
    Classes(int id, String descricao, int forca, int destreza, int constituicao, int inteligencia, int sabedoria, int carisma) {
        this.id = id;
        this.descricao = descricao;
        this.forca = forca;
        this.destreza = destreza;
        this.constituicao = constituicao;
        this.inteligencia = inteligencia;
        this.sabedoria = sabedoria;
        this.carisma = carisma;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getForca() {
        return forca;
    }

    public int getDestreza() {
        return destreza;
    }

    public int getConstituicao() {
        return constituicao;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public int getSabedoria() {
        return sabedoria;
    }

    public int getCarisma() {
        return carisma;
    }

    public static Classes getById(int id) {
        for (Classes classe : Classes.values()) {
            if (classe.getId() == id) {
                return classe;
            }
        }
        return null;
    }
}