package futebol.br.maneger.model.DAO;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;
import futebol.br.maneger.model.Goleiro;

@Repository
public class GoleiroDAO {
    private final JdbcClient jdbcClient;

    public GoleiroDAO(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public int create(Goleiro goleiro) {
        return jdbcClient.sql("INSERT INTO Goleiro (idJogador, defesas, penaltisDefendidos, golsSofridos, jogosSemSofrerGol, alcance) VALUES (:idJogador, :defesas, :penaltisDefendidos, :golsSofridos, :jogosSemSofrerGol, :alcance)")
                .param("idJogador", goleiro.getIdJogador())
                .param("defesas", goleiro.getDefesas())
                .param("penaltisDefendidos", goleiro.getPenaltisDefendidos())
                .param("golsSofridos", goleiro.getGolsSofridos())
                .param("jogosSemSofrerGol", goleiro.getJogosSemSofrerGol())
                .param("alcance", goleiro.getAlcance())
                .update();
    }

    public Goleiro read(int id) {
        return jdbcClient.sql("SELECT * FROM Goleiro WHERE idJogador = :id")
                .param("id", id)
                .query(Goleiro.class)
                .single();
    }

    public List<Goleiro> readAll() {
        return jdbcClient.sql("SELECT * FROM Goleiro")
                .query(Goleiro.class)
                .list();
    }

    public int update(Goleiro goleiro) {
        return jdbcClient.sql("UPDATE Goleiro SET defesas = :defesas, penaltisDefendidos = :penaltisDefendidos, golsSofridos = :golsSofridos, jogosSemSofrerGol = :jogosSemSofrerGol, alcance = :alcance WHERE idJogador = :id")
                .param("defesas", goleiro.getDefesas())
                .param("penaltisDefendidos", goleiro.getPenaltisDefendidos())
                .param("golsSofridos", goleiro.getGolsSofridos())
                .param("jogosSemSofrerGol", goleiro.getJogosSemSofrerGol())
                .param("alcance", goleiro.getAlcance())
                .param("id", goleiro.getIdJogador())
                .update();
    }

    public int delete(int id) {
        return jdbcClient.sql("DELETE FROM Goleiro WHERE idJogador = :id")
                .param("id", id)
                .update();
    }
}
