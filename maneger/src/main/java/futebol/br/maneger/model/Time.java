package futebol.br.maneger.model;

import java.util.ArrayList;

public class Time {
    private int idTime;
    private String nome;
    private String cidade;
    private String fundacao;
    private String estadio;
    private ArrayList<String> titulos;

    public Time(int idTime, String nome, String cidade, String fundacao, String estadio, ArrayList<String> titulos) {
        this.idTime = idTime;
        this.nome = nome;
        this.cidade = cidade;
        this.fundacao = fundacao;
        this.estadio = estadio;
        this.titulos = titulos;
    }

    public int getIdTime() {
        return this.idTime;
    }

    public void setIdTime(int idTime) {
        this.idTime = idTime;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return this.cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getFundacao() {
        return this.fundacao;
    }

    public void setFundacao(String fundacao) {
        this.fundacao = fundacao;
    }

    public String getEstadio() {
        return this.estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public ArrayList<String> getTitulos() {
        return this.titulos;
    }

    public void addTitulo(String titulo) {
        this.titulos.add(titulo); 
    }
    public void removeTitulo(String titulo){
        this.titulos.remove(titulo);
    }
}
