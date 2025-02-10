package futebol.br.maneger.model;

public class Goleiro extends Jogador{
    private int defesas;
    private int penaltisDefendidos;
    private int golsSofridos;
    private int jogosSemSofrerGol;
    private double alcance;

    public Goleiro(int idJogador, String nome, int idade, String nacionalidade, double altura, double peso, Time timeatual, int num_camisa, String posicao ,int defesas, int penaltisDefendidos, int golsSofridos, int jogosSemSofrerGol, double alcance) {
        super(nome, idade,nacionalidade, altura, peso, timeatual, num_camisa, posicao);
        this.defesas = defesas;
        this.penaltisDefendidos = penaltisDefendidos;
        this.golsSofridos = golsSofridos;
        this.jogosSemSofrerGol = jogosSemSofrerGol;
        this.alcance = alcance;
    }

    public int getDefesas() {
        return this.defesas;
    }

    public void setDefesas(int defesas) {
        this.defesas = defesas;
    }

    public int getPenaltisDefendidos() {
        return this.penaltisDefendidos;
    }

    public void setPenaltisDefendidos(int penaltisDefendidos) {
        this.penaltisDefendidos = penaltisDefendidos;
    }

    public int getGolsSofridos() {
        return this.golsSofridos;
    }

    public void setGolsSofridos(int golsSofridos) {
        this.golsSofridos = golsSofridos;
    }

    public int getJogosSemSofrerGol() {
        return this.jogosSemSofrerGol;
    }

    public void setJogosSemSofrerGol(int jogosSemSofrerGol) {
        this.jogosSemSofrerGol = jogosSemSofrerGol;
    }

    public double getAlcance() {
        return this.alcance;
    }

    public void setAlcance(double alcance) {
        this.alcance = alcance;
    }
}
