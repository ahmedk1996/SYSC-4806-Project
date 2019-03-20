package Pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProfController {

    @Autowired
    ProfRepository profRepository;
    Prof newBook;
    @Autowired
    TopicRepository topicRepository;

    @GetMapping ("/add")
    public String addForm(Model model) {
        model.addAttribute("topic", new Topic());
        return "Addform";
    }

    @PostMapping("/add")
    public String addSubmit(@ModelAttribute Topic topic, Model model) {
        Topic newTopic;
        newTopic = topic;
        topicRepository.save(newTopic);
        model.addAttribute("topic", newTopic);
        return "ProfTopicResultsForm";
    }

    @GetMapping ("/all")
    public String display (Model model,@ModelAttribute Topic topic){
        model.addAttribute( "topic", topicRepository.findAll());
        return "Display";
    }


}