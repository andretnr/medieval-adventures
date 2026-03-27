package firstAdventure.models;

import java.util.HashSet;
import java.util.Set;

/**
 * Representa o progresso de um personagem em uma determinada história.
 * Persistido no banco para retomar aventuras interrompidas.
 */
public class EstadoJogo {

    private Long id;
    private Long personagemId;
    private String historiaId;
    private String cenaAtualId;
    private Set<String> flags;
    private boolean concluido;

    public EstadoJogo() {
        this.flags = new HashSet<>();
    }

    public EstadoJogo(Long personagemId, String historiaId, String cenaInicialId) {
        this.personagemId = personagemId;
        this.historiaId   = historiaId;
        this.cenaAtualId  = cenaInicialId;
        this.flags        = new HashSet<>();
        this.concluido    = false;
    }

    public Long getId()                  { return id; }
    public void setId(Long id)           { this.id = id; }

    public Long getPersonagemId()        { return personagemId; }
    public void setPersonagemId(Long v)  { this.personagemId = v; }

    public String getHistoriaId()        { return historiaId; }
    public void setHistoriaId(String v)  { this.historiaId = v; }

    public String getCenaAtualId()       { return cenaAtualId; }
    public void setCenaAtualId(String v) { this.cenaAtualId = v; }

    public boolean isConcluido()         { return concluido; }
    public void setConcluido(boolean v)  { this.concluido = v; }

    public void adicionarFlag(String flag)  { flags.add(flag); }
    public boolean temFlag(String flag)     { return flags.contains(flag); }

    public String getFlagsAsString() {
        return String.join(",", flags);
    }

    public void setFlagsFromString(String flagsStr) {
        flags = new HashSet<>();
        if (flagsStr != null && !flagsStr.isBlank()) {
            for (String f : flagsStr.split(",")) {
                String t = f.trim();
                if (!t.isEmpty()) flags.add(t);
            }
        }
    }
}

