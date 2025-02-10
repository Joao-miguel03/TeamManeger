package futebol.br.maneger.spring_boot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import futebol.br.maneger.model.Time;
import futebol.br.maneger.model.DAO.TimeDAO;

@Controller
public class TimeController {
    
    private final TimeDAO timeDAO;

    public TimeController(TimeDAO timeDAO) {
        this.timeDAO = timeDAO;
    }

    @GetMapping("time/inserir")
    public String formularioTime(Model model){

        model.addAttribute("time", new Time(0, null, null, null, null, null));

        return "cadTime";
    }

    @PostMapping("time/inserir")
    public String inserirTime(@ModelAttribute Time time, Model model){
        
        timeDAO.create(time);

        model.addAttribute("time", model);
        model.addAttribute("mensagem", "Time cadastrado com sucesso");

        return "redirect:/";
    }

}
