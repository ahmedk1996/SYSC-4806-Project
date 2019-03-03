package Pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProfController {

   private Topic topic;
   private Prof prof;

    @Autowired
    private ProfRepository profRepository;
    @Autowired
    private TopicRepository topicRepository;

    @GetMapping("/add")
    public String addTopic(Model model,@RequestParam Integer addressBook){

       model.addAttribute("topic", new Topic());
       model.addAttribute("addressBook",new Prof());

        return "addJBuddy";
    }

    @PostMapping("/add")
    public String addTopicView(@ModelAttribute Topic topic_param, @RequestParam Integer addressBookId ) {
        Topic topic_var = new Topic();
        topic_var = topic_param;
        topicRepository.save(topic_var);

        prof = profRepository.findById(addressBookId).orElse(null);
        prof.addTopic(topic_param);
        profRepository.save(prof);
        return "addressBook";
    }

    @GetMapping("/remove")
    public void removeBuddy(@RequestParam(value="topic") int topic, @RequestParam(value="addressBook") Integer addressBook  ){

        profRepository.findById(addressBook).get().removeTopic(topic);

    }

    @GetMapping("/display")
    public String displayBuddy(@RequestParam(value="addressBook") Integer addressBook, Model model ){

        prof = profRepository.findById(addressBook).orElse(null);
        System.out.println(prof);
        model.addAttribute("print", prof);
        return "addressBook";
    }



}
