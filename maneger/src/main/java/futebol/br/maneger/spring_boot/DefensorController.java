package futebol.br.maneger.spring_boot;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import futebol.br.maneger.model.Defensor;
import futebol.br.maneger.model.Time;
import futebol.br.maneger.model.DAO.DefensorDAO;
import futebol.br.maneger.model.DAO.JogadorDAO;
import futebol.br.maneger.model.DAO.TimeDAO;

@Controller
public class DefensorController {
    private final JogadorDAO jogadorDAO;
    private final DefensorDAO defensorDAO;
    private final TimeDAO timeDAO;

    public DefensorController(JogadorDAO jogadorDAO, DefensorDAO defensorDAO, TimeDAO timeDAO) {
        this.jogadorDAO = jogadorDAO;
        this.defensorDAO = defensorDAO;
        this.timeDAO = timeDAO;
    }

  
    @GetMapping("/defensor/listar")
    public String listarJogadores(Model model){
        List<Defensor> lista_jogadores = defensorDAO.readAll();
        model.addAttribute("jogadores", lista_jogadores);
        return "listaJogadores";
    }
    
    @GetMapping("/defensor/inserir")
    public String viewForm(Model model){
        List<Time> times = timeDAO.readAll();

        model.addAttribute("jogador", new Defensor(0, null, 0, null, 0, 0, null, 0, null, 0, 0, 0, 0, 0));
        model.addAttribute("times", times);

        return "cadJogador";
    }

    @PostMapping("defensor/inserir")
    public String inserirJogador(@ModelAttribute Defensor defensor, Model model){
        jogadorDAO.create(defensor);
        defensorDAO.create(defensor);

        model.addAttribute("jogador", defensor);
        model.addAttribute("mensagem", "Jogador Cadastrado com sucesso!");

        return "index";
    }

    @GetMapping("/defensor/{id}")
    public String mostrarJogador(@PathVariable("id") int id, Model model){
        Defensor defensor = defensorDAO.read(id);

        if (defensor != null){
            model.addAttribute("jogador", defensor);
            return "mostrarJogador";
        } else {
            model.addAttribute("mensagem", "Jogador não encontrado");
            return "index";
        }
    }

    @GetMapping("/defensor/delete/{id}")
    public String deletarJogador(@PathVariable("id") int id, Model model){
        Defensor defensor = defensorDAO.read(id);

        if(defensor != null){
            defensorDAO.delete(id);
            model.addAttribute("mensagem","Jogador Deletado");
        }else{
            model.addAttribute("mensagem", "Jogador não encontrado");
        }
    
        return "index";
    }

    @PostMapping("defensor/update/{id}")
    public String atualizarJogador(@PathVariable("id") int id, Model model){
        Defensor defensor = defensorDAO.read(id);

        if (defensor != null){
            defensorDAO.update(defensor);
            model.addAttribute("mensagem", "Jogador Atualizado");
            return "index";
        } else {
            model.addAttribute("mensagem", "Erro ao atualizar jogador");
            return "index";
        }

    }

    
}
