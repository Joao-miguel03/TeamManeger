package futebol.br.maneger.model.DAO;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;
import futebol.br.maneger.model.Atacante;

@Repository
public class AtacanteDAO {
    private final JdbcClient jdbcClient;

    public AtacanteDAO(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public int create(Atacante atacante) {
        return jdbcClient.sql("INSERT INTO Atacante (idJogador, golsMarcados, assistencias, finalizacoesCertas, driblesCompletos, velocidade) VALUES (:idJogador, :golsMarcados, :assistencias, :finalizacoesCertas, :driblesCompletos, :velocidade)")
                .param("idJogador", atacante.getIdJogador())
                .param("golsMarcados", atacante.getGolsMarcados())
                .param("assistencias", atacante.getAssistencias())
                .param("finalizacoesCertas", atacante.getFinalizacoesCertas())
                .param("driblesCompletos", atacante.getDriblesCompletos())
                .param("velocidade", atacante.getVelocidade())
                .update();
    }

    public Atacante read(int id) {
        return jdbcClient.sql("SELECT * FROM Atacante WHERE idJogador = :id")
                .param("id", id)
                .query(Atacante.class)
                .single();
    }

    public List<Atacante> readAll() {
        return jdbcClient.sql("SELECT * FROM Atacante")
                .query(Atacante.class)
                .list();
    }

    public int update(Atacante atacante) {
        return jdbcClient.sql("UPDATE Atacante SET golsMarcados = :golsMarcados, assistencias = :assistencias, finalizacoesCertas = :finalizacoesCertas, driblesCompletos = :driblesCompletos, velocidade = :velocidade WHERE idJogador = :id")
                .param("golsMarcados", atacante.getGolsMarcados())
                .param("assistencias", atacante.getAssistencias())
                .param("finalizacoesCertas", atacante.getFinalizacoesCertas())
                .param("driblesCompletos", atacante.getDriblesCompletos())
                .param("velocidade", atacante.getVelocidade())
                .param("id", atacante.getIdJogador())
                .update();
    }

    public int delete(int id) {
        return jdbcClient.sql("DELETE FROM Atacante WHERE idJogador = :id")
                .param("id", id)
                .update();
    }
}
