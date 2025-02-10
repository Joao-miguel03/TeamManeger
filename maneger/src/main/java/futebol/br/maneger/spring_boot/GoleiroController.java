package futebol.br.maneger.spring_boot;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import futebol.br.maneger.model.Goleiro;
import futebol.br.maneger.model.Time;
import futebol.br.maneger.model.DAO.GoleiroDAO;
import futebol.br.maneger.model.DAO.JogadorDAO;
import futebol.br.maneger.model.DAO.TimeDAO;

@Controller
public class GoleiroController {
    private final JogadorDAO jogadorDAO;
    private final GoleiroDAO goleiroDAO;
    private final TimeDAO timeDAO;

    public GoleiroController(JogadorDAO jogadorDAO, GoleiroDAO goleiroDAO, TimeDAO timeDAO) {
        this.jogadorDAO = jogadorDAO;
        this.goleiroDAO = goleiroDAO;
        this.timeDAO = timeDAO;
    }

    
    @GetMapping("/goleiro/listar")
    public String listarJogadores(Model model){
        List<Goleiro> lista_jogadores = goleiroDAO.readAll();
        model.addAttribute("jogadores", lista_jogadores);
        return "listaJogadores";
    }

    @GetMapping("/goleiro/inserir")
    public String viewForm(Model model){
        List<Time> times = timeDAO.readAll();

        model.addAttribute("jogador", new Goleiro(0, null, 0, null, 0, 0, null, 0, null, 0, 0, 0, 0, 0));
        model.addAttribute("times", times);

        return "cadJogador";
    }

    @PostMapping("goleiro/inserir")
    public String inserirJogador(@ModelAttribute Goleiro goleiro, Model model){
        jogadorDAO.create(goleiro);
        goleiroDAO.create(goleiro);

        model.addAttribute("jogador", goleiro);
        model.addAttribute("mensagem", "Jogador Cadastrado com sucesso!");

        return "index";
    }

    @GetMapping("/goleiro/{id}")
    public String mostrarJogador(@PathVariable("id") int id, Model model){
        Goleiro goleiro = goleiroDAO.read(id);

        if (goleiro != null){
            model.addAttribute("jogador", goleiro);
            return "mostrarJogador";
        } else {
            model.addAttribute("mensagem", "Jogador não encontrado");
            return "index";
        }
    }

    @GetMapping("/goleiro/delete/{id}")
    public String deletarJogador(@PathVariable("id") int id, Model model){
        Goleiro goleiro = goleiroDAO.read(id);

        if(goleiro != null){
            goleiroDAO.delete(id);
            model.addAttribute("mensagem","Jogador Deletado");
        }else{
            model.addAttribute("mensagem", "Jogador não encontrado");
        }
    
        return "index";
    }

    @PostMapping("goleiro/update/{id}")
    public String atualizarJogador(@PathVariable("id") int id, Model model){
        Goleiro goleiro = goleiroDAO.read(id);

        if (goleiro != null){
            goleiroDAO.update(goleiro);
            model.addAttribute("mensagem", "Jogador Atualizado");
            return "index";
        } else {
            model.addAttribute("mensagem", "Erro ao atualizar jogador");
            return "index";
        }

    }    
    
}
