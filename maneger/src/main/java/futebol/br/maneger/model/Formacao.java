package futebol.br.maneger.model;

import java.util.ArrayList;

public class Formacao {
    private int idFormacao;
    private Time time;
    private ArrayList<Jogador> jogadores;

    public Formacao(int idFormacao, Time time, ArrayList<Jogador> jogadores) {
        this.idFormacao = idFormacao;
        this.time = time;
        this.jogadores = jogadores;
    }


    public int getIdFormacao() {
        return this.idFormacao;
    }

    public void setIdFormacao(int idFormacao) {
        this.idFormacao = idFormacao;
    }

    public Time getTime() {
        return this.time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public ArrayList<Jogador> getJogadores() {
        return this.jogadores;
    }

    public void addJogador(Jogador jogador) {
        this.jogadores.add(jogador);
    }
    public void removeJogador(int jogador){
        this.jogadores.remove(jogador);
    }

}
