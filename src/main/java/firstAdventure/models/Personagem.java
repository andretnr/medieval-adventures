package firstAdventure.models;


import firstAdventure.personagem.enums.Classes;

import java.text.DecimalFormat;

public class Personagem {

    private String nome;

    private int idade;

    private Classes classe;

    private int nivel;

    private int forca;

    private int destreza;

    private int constituicao;

    private int inteligencia;

    private int sabedoria;

    private int carisma;

    private double vida;

    private double energia;

    private int sorte;

    private int pontos;



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getDestreza() {
        return destreza;
    }

    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }

    public int getConstituicao() {
        return constituicao;
    }

    public void setConstituicao(int constituicao) {
        this.constituicao = constituicao;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }

    public int getSabedoria() {
        return sabedoria;
    }

    public void setSabedoria(int sabedoria) {
        this.sabedoria = sabedoria;
    }

    public int getCarisma() {
        return carisma;
    }

    public void setCarisma(int carisma) {
        this.carisma = carisma;
    }

    public double getVida() {
        return vida;
    }

    public void setVida(double vida) {
        this.vida = vida;
    }

    public double getEnergia() {
        return energia;
    }

    public void setEnergia(double energia) {
        this.energia = energia;
    }

    public int getSorte() {
        return sorte;
    }

    public void setSorte(int sorte) {
        this.sorte = sorte;
    }

    public Classes getClasse() {
        return classe;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public void setClasse(Classes classe) {
        this.forca = classe.getForca();
        this.destreza = classe.getDestreza();
        this.constituicao = classe.getConstituicao();
        this.inteligencia = classe.getInteligencia();
        this.sabedoria = classe.getSabedoria();
        this.carisma = classe.getCarisma();
        this.vida = calcularVida();
        this.energia = calcularMana();
        this.sorte = getSorteInicial(classe);
        this.classe = classe;
    }

    public void calculaEvo(){
       this.vida = calcularVida();
       this.energia = calcularMana();
    }

    private int getSorteInicial(Classes classe) {
        return classe.getCarisma() + classe.getSabedoria() / 3;
    }

//
//    private Double getVidaInicial(Classes classe, double coef) {
//        double value = (double) classe.getConstituicao() + classe.getDestreza() * coef;
//        DecimalFormat df = new DecimalFormat("#.00");
//        String vidaFormatada = df.format(value);
//        vidaFormatada = vidaFormatada.replace(',', '.');
//        return Double.parseDouble(vidaFormatada);
//    }
//
//    private Double getManaInicial(Classes classe, double coef) {
//        double value = (double) classe.getInteligencia() + classe.getConstituicao() * coef;
//        DecimalFormat df = new DecimalFormat("#.00");
//        String vidaFormatada = df.format(value);
//        vidaFormatada = vidaFormatada.replace(',', '.');
//        return Double.parseDouble(vidaFormatada);
//    }


    @Override
    public String toString() {
        return "Personagem{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", classe=" + classe +
                ", nivel=" + nivel +
                ", forca=" + forca +
                ", destreza=" + destreza +
                ", constituicao=" + constituicao +
                ", inteligencia=" + inteligencia +
                ", sabedoria=" + sabedoria +
                ", carisma=" + carisma +
                ", vida=" + vida +
                ", energia=" + energia +
                ", sorte=" + sorte +
                ", pontos=" + pontos +
                '}';
    }

    public String detalhadoPersonagem() {
        return "Seu personagem: \n\n" +
                "nome = '" + nome + '\'' +
                "\nIdade = " + idade +
                "\n\nClasse = " + classe +
                "\nNível = " + nivel +
                "\n\nForça = " + forca +
                "\nDestreza = " + destreza +
                "\nConstituicao = " + constituicao +
                "\nInteligencia = " + inteligencia +
                "\nSabedoria = " + sabedoria +
                "\nCarisma = " + carisma +
                "\nSorte = " + sorte +
                "\n\nVida = " + vida +
                "\n\nEnergia = " + energia +
                "\n\nPontos = " + pontos;
    }

    private double calcularVida() {
        return this.constituicao * 5 + this.forca * 2 + (this.nivel * 10);
    }

    private double calcularMana() {
        return this.inteligencia * 6 + this.sabedoria * 3 + (this.nivel * 8);
    }

}


//🏋️ Atributos Físicos:
//Força (STR) → Determina o poder físico, capacidade de levantar peso e dano corpo a corpo.
//Destreza (DEX) → Influencia a agilidade, reflexos, precisão e esquiva.
//Constituição (CON) → Relacionada à resistência, pontos de vida e imunidade a doenças.
//🧠 Atributos Mentais:
//Inteligência (INT) → Mede a capacidade de aprendizado, lógica e conhecimento acadêmico.
//Sabedoria (WIS) → Representa intuição, percepção e forca de vontade.
//Carisma (CHA) → Relacionado ao magnetismo pessoal, persuasão e liderança.
//        ⚔️ Outros Atributos Secundários (derivados ou extras):
//Pontos de Vida (HP) → Quantidade de dano que o personagem pode suportar antes de cair.
//Mana ou Energia (MP/SP) → Recursos usados para habilidades mágicas ou especiais.
//Velocidade (SPD) → Influencia o deslocamento e a ordem de ação em combate.
//Sorte (LUK) → Afeta acertos críticos, eventos aleatórios e outras situações imprevistas.