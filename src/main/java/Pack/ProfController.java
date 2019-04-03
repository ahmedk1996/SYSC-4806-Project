package Pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProfController {

    @Autowired
    ProfRepository profRepository;
    @Autowired
    TopicRepository topicRepository;

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
        model.addAttribute("topic", topicRepository.findAll());
        return "Prof";
    }

    @GetMapping ("/all")
    public String display (Model model,@ModelAttribute Topic topic){
        model.addAttribute( "topic", topicRepository.findAll());
        return "Display";
    }


}
