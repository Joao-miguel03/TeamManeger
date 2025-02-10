package futebol.br.maneger.model.DAO;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;
import futebol.br.maneger.model.Time;

@Repository
public class TimeDAO {
    private final JdbcClient jdbcClient;

    public TimeDAO(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public int create(Time time) {
        return jdbcClient.sql("INSERT INTO Time (nome, cidade, fundacao, estadio) VALUES (:nome, :cidade, :fundacao, :estadio)")
                .param("nome", time.getNome())
                .param("cidade", time.getCidade())
                .param("fundacao", time.getFundacao())
                .param("estadio", time.getEstadio())
                .update();
    }

    public Time read(int id) {
        return jdbcClient.sql("SELECT * FROM Time WHERE idTime = :id")
                .param("id", id)
                .query(Time.class)
                .single();
    }

    public List<Time> readAll() {
        return jdbcClient.sql("SELECT * FROM Time")
                .query(Time.class)
                .list();
    }

    public int update(Time time) {
        return jdbcClient.sql("UPDATE Time SET nome = :nome, cidade = :cidade, fundacao = :fundacao, estadio = :estadio WHERE idTime = :id")
                .param("nome", time.getNome())
                .param("cidade", time.getCidade())
                .param("fundacao", time.getFundacao())
                .param("estadio", time.getEstadio())
                .param("id", time.getIdTime())
                .update();
    }

    public int delete(int id) {
        return jdbcClient.sql("DELETE FROM Time WHERE idTime = :id")
                .param("id", id)
                .update();
    }
}
