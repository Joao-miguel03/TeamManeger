package futebol.br.maneger.model.DAO;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;
import futebol.br.maneger.model.Jogador;
import futebol.br.maneger.model.Atacante;
import futebol.br.maneger.model.Defensor;
import futebol.br.maneger.model.Goleiro;

@Repository
public class JogadorDAO {
    private final JdbcClient jdbcClient;

    public JogadorDAO(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    // Criar jogador
    public int create(Jogador jogador) {
        String sql = "INSERT INTO Jogador (nome, idade, nacionalidade, altura, peso, num_camisa, posicao, timeatual) " +
                     "VALUES (:nome, :idade, :nacionalidade, :altura, :peso, :num_camisa, :posicao, :timeatual)";
        return jdbcClient.sql(sql)
                .param("nome", jogador.getNome())
                .param("idade", jogador.getIdade())
                .param("nacionalidade", jogador.getNacionalidade())
                .param("altura", jogador.getAltura())
                .param("peso", jogador.getPeso())
                .param("num_camisa", jogador.getNum_camisa())
                .param("posicao", jogador.getPosicao())
                .param("timeatual", jogador.getTimeatual().getIdTime())
                .update();
    }

    // Ler jogador por ID
    public Jogador read(int id) {
        String sql = "SELECT * FROM Jogador WHERE idJogador = :id";
        Jogador jogador = jdbcClient.sql(sql)
                .param("id", id)
                .query(Jogador.class)
                .single();

        // Para determinar o tipo de jogador (Atacante, Defensor, ou Goleiro)
        if (jogador.getPosicao().equals("Atacante")) {
            return jdbcClient.sql("SELECT * FROM Atacante WHERE idJogador = :id")
                             .param("id", id)
                             .query(Atacante.class)
                             .single();
        } else if (jogador.getPosicao().equals("Defensor")) {
            return jdbcClient.sql("SELECT * FROM Defensor WHERE idJogador = :id")
                             .param("id", id)
                             .query(Defensor.class)
                             .single();
        } else if (jogador.getPosicao().equals("Goleiro")) {
            return jdbcClient.sql("SELECT * FROM Goleiro WHERE idJogador = :id")
                             .param("id", id)
                             .query(Goleiro.class)
                             .single();
        }
        
        return jogador;
    }

    // Ler todos os jogadores
    public List<Jogador> readAll() {
        return jdbcClient.sql("SELECT * FROM Jogador")
                         .query(Jogador.class)
                         .list();
    }

    // Atualizar jogador
    public int update(Jogador jogador) {
        String sql = "UPDATE Jogador SET nome = :nome, idade = :idade, nacionalidade = :nacionalidade, " +
                     "altura = :altura, peso = :peso, num_camisa = :num_camisa, posicao = :posicao, timeatual = :timeatual " +
                     "WHERE idJogador = :id";
        return jdbcClient.sql(sql)
                .param("nome", jogador.getNome())
                .param("idade", jogador.getIdade())
                .param("nacionalidade", jogador.getNacionalidade())
                .param("altura", jogador.getAltura())
                .param("peso", jogador.getPeso())
                .param("num_camisa", jogador.getNum_camisa())
                .param("posicao", jogador.getPosicao())
                .param("timeatual", jogador.getTimeatual().getIdTime())
                .param("id", jogador.getIdJogador())
                .update();
    }

    // Deletar jogador
    public int delete(int id) {
        return jdbcClient.sql("DELETE FROM Jogador WHERE idJogador = :id")
                         .param("id", id)
                         .update();
    }
    
}
