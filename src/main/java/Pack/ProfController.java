package Pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProfController {

    private static final String downloadDirectory = "C:/";
    private static final String downloadedFileName = "projectsubmission.pdf";
    @Autowired
    ProfRepository profRepository;
    @Autowired
    TopicRepository topicRepository;

    @GetMapping ("/add")
    public String addForm(Model model) {
        model.addAttribute("topic", new Topic());
        return "Addform";
    }

    @GetMapping ("/prof/topic")
    public String profViewTopic(Model model) {
        model.addAttribute("topic", new Topic());
        return "ProfTopic";
    }

    @GetMapping ("/archive")
    public String archive(@RequestParam int topicId) {
        Topic topic = topicRepository.findById(topicId);
        topic.setAvailability(false);
        return "Prof";
    }

    @GetMapping ("/activate")
    public String activate(@RequestParam int topicId) {
        Topic topic = topicRepository.findById(topicId);
        topic.setAvailability(true);
        return "Prof";
    }
    @GetMapping ("/delete")
    public String delete(@RequestParam int topicId) {
        topicRepository.deleteById(topicId);
        return "Prof";
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
