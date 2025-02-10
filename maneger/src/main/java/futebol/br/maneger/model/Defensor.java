package futebol.br.maneger.model;

public class Defensor extends Jogador{
    private int desarmes; 
    private int bloqueios;
    private int passesPrecisos;
    private int jogosSemSofrerGol;
    private double forcaFisica;


    public Defensor(int idJogador, String nome, int idade, String nacionalidade, double altura, double peso, Time timeatual, int num_camisa, String posicao ,int desarmes, int bloqueios, int passesPrecisos, int jogosSemSofrerGol, double forcaFisica) {
        super( nome, idade,nacionalidade, altura, peso, timeatual, num_camisa, posicao);
        this.desarmes = desarmes;
        this.bloqueios = bloqueios;
        this.passesPrecisos = passesPrecisos;
        this.jogosSemSofrerGol = jogosSemSofrerGol;
        this.forcaFisica = forcaFisica;
    }


    public int getDesarmes() {
        return this.desarmes;
    }

    public void setDesarmes(int desarmes) {
        this.desarmes = desarmes;
    }

    public int getBloqueios() {
        return this.bloqueios;
    }

    public void setBloqueios(int bloqueios) {
        this.bloqueios = bloqueios;
    }

    public int getPassesPrecisos() {
        return this.passesPrecisos;
    }

    public void setPassesPrecisos(int passesPrecisos) {
        this.passesPrecisos = passesPrecisos;
    }

    public int getJogosSemSofrerGol() {
        return this.jogosSemSofrerGol;
    }

    public void setJogosSemSofrerGol(int jogosSemSofrerGol) {
        this.jogosSemSofrerGol = jogosSemSofrerGol;
    }

    public double getForcaFisica() {
        return this.forcaFisica;
    }

    public void setForcaFisica(double forcaFisica) {
        this.forcaFisica = forcaFisica;
    }

}
