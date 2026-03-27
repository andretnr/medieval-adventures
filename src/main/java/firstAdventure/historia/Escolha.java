package firstAdventure.historia;

public class Escolha {

    private final String texto;
    private final String proximaCenaId;
    private final String flagParaRedirecionar;
    private final String cenaIdAlternativa;
    private final String requisitoFlag;
    private final EfeitoEscolha efeito;

    private Escolha(Builder b) {
        this.texto                = b.texto;
        this.proximaCenaId        = b.proximaCenaId;
        this.flagParaRedirecionar = b.flagParaRedirecionar;
        this.cenaIdAlternativa    = b.cenaIdAlternativa;
        this.requisitoFlag        = b.requisitoFlag;
        this.efeito               = b.efeito != null ? b.efeito : EfeitoEscolha.VAZIO;
    }

    public String getTexto()                { return texto; }
    public String getProximaCenaId()        { return proximaCenaId; }
    public String getFlagParaRedirecionar() { return flagParaRedirecionar; }
    public String getCenaIdAlternativa()    { return cenaIdAlternativa; }
    public String getRequisitoFlag()        { return requisitoFlag; }
    public EfeitoEscolha getEfeito()        { return efeito; }

    public boolean temRedirecionamento() {
        return flagParaRedirecionar != null && cenaIdAlternativa != null;
    }

    public boolean temRequisito() {
        return requisitoFlag != null;
    }

    public static class Builder {
        private String texto;
        private String proximaCenaId;
        private String flagParaRedirecionar;
        private String cenaIdAlternativa;
        private String requisitoFlag;
        private EfeitoEscolha efeito;

        public Builder texto(String t)                   { this.texto = t;              return this; }
        public Builder proximaCena(String id)            { this.proximaCenaId = id;     return this; }
        public Builder efeito(EfeitoEscolha e)           { this.efeito = e;             return this; }
        public Builder requerFlag(String flag)           { this.requisitoFlag = flag;   return this; }

        /** Se {@code flag} estiver no estado, redireciona para {@code cenaAlternativa}. */
        public Builder seFlagPresente(String flag, String cenaAlternativa) {
            this.flagParaRedirecionar = flag;
            this.cenaIdAlternativa    = cenaAlternativa;
            return this;
        }

        public Escolha build() { return new Escolha(this); }
    }
}

