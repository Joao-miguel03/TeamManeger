package futebol.br.maneger.spring_boot;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import futebol.br.maneger.model.Jogador;
import futebol.br.maneger.model.Atacante;
import futebol.br.maneger.model.Defensor;
import futebol.br.maneger.model.Goleiro;
import futebol.br.maneger.model.DAO.JogadorDAO;

@Controller
public class JogadorController {
    private final JogadorDAO jogadorDAO;

    public JogadorController(JogadorDAO jogadorDAO) {
        this.jogadorDAO = jogadorDAO;
    }

    @GetMapping("/jogador/listar")
    public String listarJogadores(Model model) {
        Logger logger = LoggerFactory.getLogger(getClass());
        
        List<Jogador> lista_jogadores = Collections.emptyList();
        
        try {
            lista_jogadores = jogadorDAO.readAll();
        } catch (Exception e) {
            logger.error("Erro ao listar jogadores", e);
            model.addAttribute("erro", "Ocorreu um erro ao carregar os jogadores");
        }
        
        model.addAttribute("jogadores", lista_jogadores);
        return "listaJogadores";
    }
    


    @GetMapping("/jogador/{id}")
    public String mostrarJogador(@PathVariable("id") int id, Model model){
        Jogador jogador = jogadorDAO.read(id);

        if (jogador != null){
            model.addAttribute("jogador", jogador);
            return "mostrarJogador";
        } else {
            model.addAttribute("mensagem", "Jogador não encontrado");
            return "index";
        }
    }

    @GetMapping("/jogador/delete/{id}")
    public String deletarJogador(@PathVariable("id") int id, Model model){
        Jogador jogador = jogadorDAO.read(id);

        if(jogador != null){
            jogadorDAO.delete(id);
            model.addAttribute("mensagem","Jogador Deletado");
        }else{
            model.addAttribute("mensagem", "Jogador não encontrado");
        }
    
        return "index";
    }

    @PostMapping("jogador/update/{id}")
    public String atualizarJogador(@PathVariable("id") int id, Model model){
        Jogador jogador = jogadorDAO.read(id);

        if (jogador != null){
            jogadorDAO.update(jogador);
            model.addAttribute("mensagem", "Jogador Atualizado");
            return "index";
        } else {
            model.addAttribute("mensagem", "Erro ao atualizar jogador");
            return "index";
        }

    }

    
}
