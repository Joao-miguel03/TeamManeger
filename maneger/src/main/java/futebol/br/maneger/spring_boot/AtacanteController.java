package futebol.br.maneger.spring_boot;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import futebol.br.maneger.model.Atacante;
import futebol.br.maneger.model.Time;
import futebol.br.maneger.model.DAO.AtacanteDAO;
import futebol.br.maneger.model.DAO.JogadorDAO;
import futebol.br.maneger.model.DAO.TimeDAO;

@Controller
public class AtacanteController {
    private final JogadorDAO jogadorDAO;
    private final AtacanteDAO atacanteDAO;
    private final TimeDAO timeDAO;

    public AtacanteController(JogadorDAO jogadorDAO, AtacanteDAO atacanteDAO, TimeDAO timeDAO) {
        this.jogadorDAO = jogadorDAO;
        this.atacanteDAO = atacanteDAO;
        this.timeDAO = timeDAO;
    }

    
    @GetMapping("/atacante/listar")
    public String listarJogadores(Model model){
        List<Atacante> lista_jogadores = atacanteDAO.readAll();
        model.addAttribute("jogadores", lista_jogadores);
        return "listaJogadores";
    }

    @GetMapping("/atacante/inserir")
    public String viewForm(Model model){
        List<Time> times = timeDAO.readAll();

        model.addAttribute("jogador", new Atacante(0, null, 0, null, 0, 0, null, 0, null, 0, 0, 0, 0, 0));
        model.addAttribute("times", times);

        return "cadJogador";
    }

    @PostMapping("atacante/inserir")
    public String inserirJogador(@ModelAttribute Atacante atacante, @RequestParam("timeatual") int idTime, Model model){
        Time time = timeDAO.read(idTime);

        if (time != null){
            atacante.setTimeatual(time);
        } else {
            atacante.setTimeatual(null);
        }

        jogadorDAO.create(atacante);
        atacanteDAO.create(atacante);

        model.addAttribute("jogador", atacante);
        model.addAttribute("mensagem", "Jogador Cadastrado com sucesso!");

        return "redirect:/";
    }

    @GetMapping("/atacante/{id}")
    public String mostrarJogador(@PathVariable("id") int id, Model model){
        Atacante atacante = atacanteDAO.read(id);

        if (atacante != null){
            model.addAttribute("jogador", atacante);
            return "mostrarJogador";
        } else {
            model.addAttribute("mensagem", "Jogador não encontrado");
            return "index";
        }
    }

    @GetMapping("/atacante/delete/{id}")
    public String deletarJogador(@PathVariable("id") int id, Model model){
        Atacante atacante = atacanteDAO.read(id);

        if(atacante != null){
            atacanteDAO.delete(id);
            model.addAttribute("mensagem","Jogador Deletado");
        }else{
            model.addAttribute("mensagem", "Jogador não encontrado");
        }
    
        return "index";
    }

    @PostMapping("atacante/update/{id}")
    public String atualizarJogador(@PathVariable("id") int id, Model model){
        Atacante atacante = atacanteDAO.read(id);

        if (atacante != null){
            atacanteDAO.update(atacante);
            model.addAttribute("mensagem", "Jogador Atualizado");
            return "index";
        } else {
            model.addAttribute("mensagem", "Erro ao atualizar jogador");
            return "index";
        }

    }

}