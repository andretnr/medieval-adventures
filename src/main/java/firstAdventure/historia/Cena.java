package firstAdventure.historia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cena {

    private final String id;
    private final String titulo;
    private final String texto;
    private final TipoCena tipo;
    private final Inimigo inimigo;
    private final String cenaSeDerrota;
    private final String cenaAposVitoria;
    private final EfeitoEscolha efeitoAposVitoria;
    private final List<Escolha> escolhas;

    private Cena(Builder b) {
        this.id                = b.id;
        this.titulo            = b.titulo;
        this.texto             = b.texto;
        this.tipo              = b.tipo;
        this.inimigo           = b.inimigo;
        this.cenaSeDerrota     = b.cenaSeDerrota;
        this.cenaAposVitoria   = b.cenaAposVitoria;
        this.efeitoAposVitoria = b.efeitoAposVitoria != null ? b.efeitoAposVitoria : EfeitoEscolha.VAZIO;
        this.escolhas          = Collections.unmodifiableList(new ArrayList<>(b.escolhas));
    }

    public String getId()                       { return id; }
    public String getTitulo()                   { return titulo; }
    public String getTexto()                    { return texto; }
    public TipoCena getTipo()                   { return tipo; }
    public Inimigo getInimigo()                 { return inimigo; }
    public String getCenaSeDerrota()            { return cenaSeDerrota; }
    public String getCenaAposVitoria()          { return cenaAposVitoria; }
    public EfeitoEscolha getEfeitoAposVitoria() { return efeitoAposVitoria; }
    public List<Escolha> getEscolhas()          { return escolhas; }

    public static class Builder {
        private final String id;
        private String titulo = "";
        private String texto  = "";
        private TipoCena tipo = TipoCena.NORMAL;
        private Inimigo inimigo;
        private String cenaSeDerrota;
        private String cenaAposVitoria;
        private EfeitoEscolha efeitoAposVitoria;
        private final List<Escolha> escolhas = new ArrayList<>();

        public Builder(String id)                              { this.id = id; }
        public Builder titulo(String t)                        { this.titulo = t;             return this; }
        public Builder texto(String t)                         { this.texto = t;              return this; }
        public Builder tipo(TipoCena t)                        { this.tipo = t;               return this; }
        public Builder inimigo(Inimigo i)                      { this.inimigo = i;            return this; }
        public Builder cenaSeDerrota(String id)                { this.cenaSeDerrota = id;     return this; }
        public Builder cenaAposVitoria(String id)              { this.cenaAposVitoria = id;   return this; }
        public Builder efeitoAposVitoria(EfeitoEscolha e)      { this.efeitoAposVitoria = e;  return this; }
        public Builder adicionarEscolha(Escolha e)             { this.escolhas.add(e);        return this; }

        public Cena build() { return new Cena(this); }
    }
}

