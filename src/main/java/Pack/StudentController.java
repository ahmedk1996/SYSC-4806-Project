package Pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller

public class StudentController {

    @Autowired
    private TopicRepository topicRepository;
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/StudentHome")
    public String studentName(Model model){
        model.addAttribute("topicList", topicRepository.findAll());
        String name= "Hunho Ha";
        model.addAttribute("name",name);
        return "StudentHome";
    }


    @GetMapping("/join")
    public String joinTopic(){

        return "StudentHome";
    }

    @GetMapping("/detail")
    public String detailTopic(){

        return "ProjectDetail";
    }

    @GetMapping("/ProjectDetail")
    public String ProjectDetail(@RequestAttribute Topic topic,Model model){
        model.addAttribute("topicdetail",topic);
        return "ProjectDetail";
    }


}
