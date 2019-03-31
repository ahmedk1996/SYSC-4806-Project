package Pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
public class ProfController {

    @Autowired
    ProfRepository profRepository;
    @Autowired
    TopicRepository topicRepository;
    Date date;

    @GetMapping ("/add")
    public String addForm(Model model) {
        model.addAttribute("topic", new Topic());
        return "Addform";
    }

    @GetMapping ("/prof")
    public String prof(Model model) {
        model.addAttribute( "topic", topicRepository.findAll());//2do:findTopicsByProfID(prof.getProfID()) -- How to get prof??
        return "Prof";
    }

    @PostMapping("/add")
    public String addSubmit(@ModelAttribute Topic topic, Model model) {
        topicRepository.save(topic);
        model.addAttribute("topic", topic);
        return "Prof";
    }

    @GetMapping ("/all")
    public String display (Model model,@ModelAttribute Topic topic){
        model.addAttribute( "topic", topicRepository.findAll());
        return "Display";
    }

    @GetMapping("/date")
    public  String pickDate (Model model){

        model.addAttribute("start", new String());
        model.addAttribute("end", new String());

        //model.addAttribute("date", new Date());
        return "datePicker";
    }

    @PostMapping("/date")
    public String datePicked (Model model, @ModelAttribute String start, @ModelAttribute String end){
        String s = start.toString();
        String f = end.toString();
        System.out.println("****************" + s + f + "*********************");
        //Date projectStart = start.
        return "dateConfirmed";
    }

}
