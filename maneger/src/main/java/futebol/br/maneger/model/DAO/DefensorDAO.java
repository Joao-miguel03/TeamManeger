package futebol.br.maneger.model.DAO;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;
import futebol.br.maneger.model.Defensor;

@Repository
public class DefensorDAO {
    private final JdbcClient jdbcClient;

    public DefensorDAO(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public int create(Defensor defensor) {
        return jdbcClient.sql("INSERT INTO Defensor (idJogador, desarmes, bloqueios, passesPrecisos, jogosSemSofrerGol, forcaFisica) VALUES (:idJogador, :desarmes, :bloqueios, :passesPrecisos, :jogosSemSofrerGol, :forcaFisica)")
                .param("idJogador", defensor.getIdJogador())
                .param("desarmes", defensor.getDesarmes())
                .param("bloqueios", defensor.getBloqueios())
                .param("passesPrecisos", defensor.getPassesPrecisos())
                .param("jogosSemSofrerGol", defensor.getJogosSemSofrerGol())
                .param("forcaFisica", defensor.getForcaFisica())
                .update();
    }

    public Defensor read(int id) {
        return jdbcClient.sql("SELECT * FROM Defensor WHERE idJogador = :id")
                .param("id", id)
                .query(Defensor.class)
                .single();
    }

    public List<Defensor> readAll() {
        return jdbcClient.sql("SELECT * FROM Defensor")
                .query(Defensor.class)
                .list();
    }

    public int update(Defensor defensor) {
        return jdbcClient.sql("UPDATE Defensor SET desarmes = :desarmes, bloqueios = :bloqueios, passesPrecisos = :passesPrecisos, jogosSemSofrerGol = :jogosSemSofrerGol, forcaFisica = :forcaFisica WHERE idJogador = :id")
                .param("desarmes", defensor.getDesarmes())
                .param("bloqueios", defensor.getBloqueios())
                .param("passesPrecisos", defensor.getPassesPrecisos())
                .param("jogosSemSofrerGol", defensor.getJogosSemSofrerGol())
                .param("forcaFisica", defensor.getForcaFisica())
                .param("id", defensor.getIdJogador())
                .update();
    }

    public int delete(int id) {
        return jdbcClient.sql("DELETE FROM Defensor WHERE idJogador = :id")
                .param("id", id)
                .update();
    }
}
