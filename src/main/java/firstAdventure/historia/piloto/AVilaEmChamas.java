package firstAdventure.historia.piloto;

import firstAdventure.historia.*;

import java.util.HashMap;
import java.util.Map;

/**
 * ════════════════════════════════════════════════════════
 *  PILOTO — A VILA EM CHAMAS
 * ════════════════════════════════════════════════════════
 *
 * Mapa de cenas:
 *
 *   INTRO ──► PORTAO_PRINCIPAL (combate difícil)
 *         └─► COLINA ──► CELEIRO (combate fácil) ──► VILA_CENTRAL
 *                   └────────────────────────────►──┘
 *
 *   VILA_CENTRAL ──► CURAR_ALDEAO (+flag ALDEAO_CURADO) ──► PRE_CONFRONTO
 *               └─────────────────────────────────────────► PRE_CONFRONTO
 *
 *   PRE_CONFRONTO ──► CONFRONTO_DRAVEN_FORTE  (sem flag)
 *                └──► CONFRONTO_DRAVEN_FRACO  (com ALDEAO_CURADO)
 *
 *   ambos ──► VITORIA  |  DERROTA
 */
public class AVilaEmChamas implements Historia {

    private static final String ID = "A_VILA_EM_CHAMAS";
    private final Map<String, Cena> cenas = new HashMap<>();

    public AVilaEmChamas() {
        construirCenas();
    }

    @Override public String getId()           { return ID; }
    @Override public String getTitulo()       { return "A Vila em Chamas"; }
    @Override public String getDescricao()    { return "Salve a aldeia de Ravenwood das mãos do cruel Draven."; }
    @Override public String getCenaInicialId(){ return "INTRO"; }
    @Override public Cena getCena(String id)  { return cenas.get(id); }

    // ── Construção das cenas ──────────────────────────────────────────────────

    private void construirCenas() {
        add(cenaIntro());
        add(cenaPortaoPrincipal());
        add(cenaColina());
        add(cenaCeleiro());
        add(cenaVilaCentral());
        add(cenaCurarAldeao());
        add(cenaPreConfronto());
        add(cenaConfrontoDravenForte());
        add(cenaConfrontoDravenFraco());
        add(cenaVitoria());
        add(cenaDerrota());
    }

    private void add(Cena c) { cenas.put(c.getId(), c); }

    // ── Cenas ────────────────────────────────────────────────────────────────

    private Cena cenaIntro() {
        return new Cena.Builder("INTRO")
            .titulo("O Chamado")
            .texto("""
A noite cai pesada sobre o reino quando um cavaleiro chega a galope, \
o rosto manchado de cinza e fuligem.

"Ravenwood está em chamas!" ele grita, tentando recuperar o fôlego. \
"Bandidos tomaram a aldeia ao anoitecer — já mataram os guardas e \
prendem reféns na praça central!"

Você vira o rosto para o horizonte alaranjado. A fumaça sobe em \
espirais negras contra o céu estrelado. Empunhando suas armas, \
você parte sem hesitar.""")
            .tipo(TipoCena.NORMAL)
            .adicionarEscolha(new Escolha.Builder()
                .texto("Avançar diretamente pela porta principal da aldeia")
                .proximaCena("PORTAO_PRINCIPAL")
                .build())
            .adicionarEscolha(new Escolha.Builder()
                .texto("Subir a colina próxima para avaliar a situação antes de agir")
                .proximaCena("COLINA")
                .build())
            .build();
    }

    private Cena cenaPortaoPrincipal() {
        return new Cena.Builder("PORTAO_PRINCIPAL")
            .titulo("O Portão em Chamas")
            .texto("""
O portão principal da aldeia está envolvido em fumaça. Dois bandidos \
armados bloqueiam a passagem — um empunha uma espada enferrujada, \
o outro segura um machado coberto de sangue.

Ao perceber sua aproximação, eles berram em uníssono: \
"Mais um idiota que quer morrer hoje!" — e avançam.""")
            .tipo(TipoCena.COMBATE)
            .inimigo(new Inimigo("Guardas Bandidos", 45, 6, 80))
            .cenaAposVitoria("VILA_CENTRAL")
            .cenaSeDerrota("DERROTA")
            .build();
    }

    private Cena cenaColina() {
        return new Cena.Builder("COLINA")
            .titulo("A Visão da Colina")
            .texto("""
Da crista da colina, a visão é sombria: casas em chamas, gritos ao \
longe, silhuetas de reféns na praça central.

Mas seus olhos treinados captam algo útil — um caminho de serviço \
que contorna a aldeia pelo celeiro ao sul, aparentemente sem guardas. \
Uma oportunidade de entrar sem ser visto.

O portão principal, entretanto, ainda está acessível para uma \
abordagem direta.""")
            .tipo(TipoCena.NORMAL)
            .adicionarEscolha(new Escolha.Builder()
                .texto("Usar o caminho secreto pelo celeiro [abordagem furtiva]")
                .proximaCena("CELEIRO")
                .build())
            .adicionarEscolha(new Escolha.Builder()
                .texto("Avançar pela porta principal mesmo assim [confronto direto]")
                .proximaCena("PORTAO_PRINCIPAL")
                .build())
            .build();
    }

    private Cena cenaCeleiro() {
        return new Cena.Builder("CELEIRO")
            .titulo("O Celeiro Adormecido")
            .texto("""
O caminho de terra leva até os fundos do celeiro. Pelo vão da porta \
entreaberta, você avista um bandido solitário recostado num fardo de \
palha, uma garrafa vazia tombada ao lado. Pelo cheiro, ele claramente \
bebeu demais para estar de guarda.

Mesmo sonolento, ele acorda ao ouvir seus passos e arranha a espada \
do cinturão com dedos trôpegos.""")
            .tipo(TipoCena.COMBATE)
            .inimigo(new Inimigo("Bandido Bêbado", 15, 3, 40))
            .cenaAposVitoria("VILA_CENTRAL")
            .cenaSeDerrota("DERROTA")
            .efeitoAposVitoria(new EfeitoEscolha(0, 15, "CAMINHO_SECRETO"))
            .build();
    }

    private Cena cenaVilaCentral() {
        return new Cena.Builder("VILA_CENTRAL")
            .titulo("A Praça Central")
            .texto("""
Você emerge na praça central de Ravenwood. O cheiro de fumaça é \
sufocante; brasas dançam no ar quente da noite.

Num canto da praça, um ancião ferido apoia-se trêmulo contra a parede \
de pedra de uma fonte. "Por favor..." ele murmura, estendendo a mão \
com esforço, os olhos brilhando de esperança ao te ver.

Ao longe, do lado oposto da praça, você ouve o riso grave e \
arrogante de alguém que claramente está no comando.""")
            .tipo(TipoCena.NORMAL)
            .adicionarEscolha(new Escolha.Builder()
                .texto("Parar para curar o ancião ferido")
                .proximaCena("CURAR_ALDEAO")
                .efeito(new EfeitoEscolha(30, 10, "ALDEAO_CURADO"))
                .build())
            .adicionarEscolha(new Escolha.Builder()
                .texto("Avançar direto para o confronto — não há tempo a perder")
                .proximaCena("PRE_CONFRONTO")
                .build())
            .build();
    }

    private Cena cenaCurarAldeao() {
        return new Cena.Builder("CURAR_ALDEAO")
            .titulo("Uma Bondade no Caos")
            .texto("""
Você age rapidamente. Com tiras rasgadas de sua capa, estanca o \
ferimento no flanco do ancião. Ele respira fundo, a cor voltando \
lentamente ao rosto.

"Você é bondoso, viajante... Escute," ele sussurra com urgência, \
agarrando seu braço. "O líder deles se chama Draven. Ele usa um \
amuleto de proteção — mas quando criança quase morreu num incêndio. \
O fogo o apavora até hoje. Isso pode ser sua maior vantagem."

Ele aperta sua mão com o pouco de força que lhe resta. \
"Vá. Salve-os."  """)
            .tipo(TipoCena.NORMAL)
            .adicionarEscolha(new Escolha.Builder()
                .texto("Agradecer o conselho e avançar para o confronto")
                .proximaCena("PRE_CONFRONTO")
                .build())
            .build();
    }

    private Cena cenaPreConfronto() {
        return new Cena.Builder("PRE_CONFRONTO")
            .titulo("Frente a Frente com Draven")
            .texto("""
No centro da praça, iluminado pelas chamas das casas ao redor, \
está Draven.

Alto, de armadura negra ornamentada, um amuleto pulsando com luz \
escura pendurado no pescoço. Ele apoia uma mão despreocupada na \
empunhadura da espada e sorri ao te ver — o sorriso de alguém que \
nunca foi derrotado.

"Que irônico," ele diz, a voz rouca e fria. "Um herói solitário \
contra meu exército. Acho que vou gostar deste momento."

Os reféns na praça observam em silêncio, segurado pela esperança \
que você representa. Não há como recuar.""")
            .tipo(TipoCena.NORMAL)
            .adicionarEscolha(new Escolha.Builder()
                .texto("Enfrentar Draven!")
                .proximaCena("CONFRONTO_DRAVEN_FORTE")
                .seFlagPresente("ALDEAO_CURADO", "CONFRONTO_DRAVEN_FRACO")
                .build())
            .build();
    }

    private Cena cenaConfrontoDravenForte() {
        return new Cena.Builder("CONFRONTO_DRAVEN_FORTE")
            .titulo("A Batalha Final")
            .texto("""
Draven desembainha a espada com um movimento preciso e elegante. \
O amuleto em seu pescoço pulsa com uma luz negra estranha — \
uma proteção mágica que reforça cada um de seus golpes.

"Vamos acabar com isso logo," ele diz, e avança.""")
            .tipo(TipoCena.COMBATE)
            .inimigo(new Inimigo("Draven, Senhor das Chamas", 70, 9, 300))
            .cenaAposVitoria("VITORIA")
            .cenaSeDerrota("DERROTA")
            .build();
    }

    private Cena cenaConfrontoDravenFraco() {
        return new Cena.Builder("CONFRONTO_DRAVEN_FRACO")
            .titulo("A Fraqueza de Draven")
            .texto("""
Antes de Draven atacar, você pega uma tocha de um suporte na parede \
e a agita lentamente na direção dele.

Por uma fração de segundo — apenas uma fração — o terror cruza o \
rosto do bandido. O amuleto parece fraquejar, sua pulsação hesitante. \
"T-tire isso daqui!" ele gagueja, antes de se recompor com raiva.

Mas a hesitação já custou caro. Sua confiança está abalada.""")
            .tipo(TipoCena.COMBATE)
            .inimigo(new Inimigo("Draven (Abalado)", 45, 6, 350))
            .cenaAposVitoria("VITORIA")
            .cenaSeDerrota("DERROTA")
            .build();
    }

    private Cena cenaVitoria() {
        return new Cena.Builder("VITORIA")
            .titulo("Ravenwood Salva!")
            .texto("""
Draven cai de joelhos no chão de pedra da praça. Sua armadura negra \
range enquanto o amuleto se parte ao meio com um estalo seco, \
liberando uma luz branca que se dissolve no ar.

Por um momento, silêncio.

Então os bandidos dispersam — correm para as sombras, para as \
estradas, para onde quer que não seja aqui. Os reféns irrompem em \
lágrimas e abraços. Uma criança pequena corre até você e te abraça \
pela cintura sem dizer uma palavra.

O ancião que você curou se aproxima devagar, apoiado numa bengala \
improvisada. Ele estende a mão, os olhos marejados.

"Ravenwood nunca esquecerá este nome, herói."

A fumaça começa lentamente a se dissipar. As chamas são apagadas. \
A aldeia respira de novo.""")
            .tipo(TipoCena.FIM_VITORIA)
            .build();
    }

    private Cena cenaDerrota() {
        return new Cena.Builder("DERROTA")
            .titulo("A Derrota")
            .texto("""
Você cai de joelhos, exausto e ferido demais para continuar.

Draven se aproxima, olha para você por um longo momento e dá de \
ombros: "Patético." Ele ordena que seus homens te joguem para fora \
da aldeia.

Enquanto você perde a consciência na estrada de terra, a fumaça \
alaranjada de Ravenwood ainda ilumina o céu noturno.

Os reféns ficam para trás.

Desta vez, a escuridão venceu. Mas enquanto houver vida...\
há uma próxima vez.""")
            .tipo(TipoCena.FIM_DERROTA)
            .build();
    }
}

