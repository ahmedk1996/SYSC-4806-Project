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

    @PostMapping("/add")
    public String addSubmit(@ModelAttribute Topic topic, Model model) {
        topicRepository.save(topic);
        model.addAttribute("topic", topicRepository.findAll());
        return "Prof";
    }
    @GetMapping ("/prof/topic")
    public String profViewTopic(@RequestParam int topicId, Model model) {
        model.addAttribute("topic", topicRepository.findById(topicId));
        return "ProfTopic";
    }

    @GetMapping ("/archive")
    public String archive(@RequestParam int topicId) {
        Topic topic = topicRepository.findById(topicId);
        System.out.println(topic.getId());
        topic.setAvailability(false);
        topicRepository.save(topic);
        return "redirect:/prof";
    }

    @GetMapping ("/activate")
    public String activate(@RequestParam int topicId) {
        Topic topic = topicRepository.findById(topicId);
        topic.setAvailability(true);
        topicRepository.save(topic);
        return "redirect:/prof";
    }
    @GetMapping ("/delete")
    public String delete(@RequestParam int topicId) {
        topicRepository.deleteById(topicId);
        return "redirect:/prof";
    }


    @GetMapping ("/prof")
    public String prof(Model model) {
        model.addAttribute( "topic", topicRepository.findAll());//2do:findTopicsByProfID(prof.getProfID()) -- How to get prof??
        return "Prof";
    }






}
