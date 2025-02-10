package futebol.br.maneger.model.DAO;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;
import futebol.br.maneger.model.Formacao;
import futebol.br.maneger.model.Time;

@Repository
public class FormacaoDAO {
    private final JdbcClient jdbcClient;

    public FormacaoDAO(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    // Criar uma nova formação
    public int create(Formacao formacao) {
        return jdbcClient.sql("INSERT INTO Formacao (idTime) VALUES (:idTime)")
                .param("idTime", formacao.getTime())
                .update();
    }

    // Ler formação por id
    public Formacao read(int id) {
        return jdbcClient.sql("SELECT * FROM Formacao WHERE idFormacao = :id")
                .param("id", id)
                .query(Formacao.class)
                .single();
    }

    // Ler todas as formações
    public List<Formacao> readAll() {
        return jdbcClient.sql("SELECT * FROM Formacao")
                .query(Formacao.class)
                .list();
    }

    // Atualizar uma formação
    public int update(Formacao formacao) {
        return jdbcClient.sql("UPDATE Formacao SET idTime = :idTime WHERE idFormacao = :id")
                .param("idTime", formacao.getTime())
                .param("id", formacao.getIdFormacao())
                .update();
    }

    // Deletar uma formação
    public int delete(int id) {
        return jdbcClient.sql("DELETE FROM Formacao WHERE idFormacao = :id")
                .param("id", id)
                .update();
    }
}
