package futebol.br.maneger.model;

public class Atacante extends Jogador {
    private int golsMarcados;
    private int assistencias;
    private int finalizacoesCertas;
    private int driblesCompletos;
    private double velocidade;


    public Atacante(int idJogador, String nome, int idade, String nacionalidade, double altura, double peso, Time timeatual, int num_camisa, String posicao ,int golsMarcados, int assistencias, int finalizacoesCertas, int driblesCompletos, double velocidade) {
        super( nome, idade, nacionalidade, altura, peso, timeatual, num_camisa, posicao);
        this.golsMarcados = golsMarcados;
        this.assistencias = assistencias;
        this.finalizacoesCertas = finalizacoesCertas;
        this.driblesCompletos = driblesCompletos;
        this.velocidade = velocidade;
    }

    public int getGolsMarcados() {
        return this.golsMarcados;
    }

    public void setGolsMarcados(int golsMarcados) {
        this.golsMarcados = golsMarcados;
    }

    public int getAssistencias() {
        return this.assistencias;
    }

    public void setAssistencias(int assistencias) {
        this.assistencias = assistencias;
    }

    public int getFinalizacoesCertas() {
        return this.finalizacoesCertas;
    }

    public void setFinalizacoesCertas(int finalizacoesCertas) {
        this.finalizacoesCertas = finalizacoesCertas;
    }

    public int getDriblesCompletos() {
        return this.driblesCompletos;
    }

    public void setDriblesCompletos(int driblesCompletos) {
        this.driblesCompletos = driblesCompletos;
    }

    public double getVelocidade() {
        return this.velocidade;
    }

    public void setVelocidade(double velocidade) {
        this.velocidade = velocidade;
    }    
}
