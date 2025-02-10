package futebol.br.maneger.model;

public abstract class Jogador {

    private Integer idJogador;
    private String nome;
    private int idade;
    private String nacionalidade;
    private double altura;
    private double peso;
    private Time timeatual;
    private int num_camisa;
    private String posicao;


    public Jogador(String nome, int idade, String nacionalidade, double altura, double peso, Time timeatual, int num_camisa, String posicao) {
        
        this.nome = nome;
        this.idade = idade;
        this.nacionalidade = nacionalidade;
        this.altura = altura;
        this.peso = peso;
        this.timeatual = timeatual;
        this.num_camisa = num_camisa;
        this.posicao = posicao;
    }


    public int getIdJogador() {
        return this.idJogador;
    }

    public void setIdJogador(int idJogador) {
        this.idJogador = idJogador;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return this.idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNacionalidade() {
        return this.nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public double getAltura() {
        return this.altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return this.peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public Time getTimeatual() {
        return this.timeatual;
    }

    public void setTimeatual(Time timeatual) {
        this.timeatual = timeatual;
    }

    public int getNum_camisa() {
        return this.num_camisa;
    }

    public void setNum_camisa(int num_camisa) {
        this.num_camisa = num_camisa;
    }

    public String getPosicao() {
        return this.posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

}
