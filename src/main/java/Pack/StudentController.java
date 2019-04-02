package Pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.websocket.server.PathParam;

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

    @PostMapping("/detail")
    public String detailTopic(){
        return "ProjectDetail";
    }


//    @GetMapping
//    public String getList (Model model){
//       model.addAttribute("topic", topicRepository.findAll());
//       return "StudentHome";
//    }







}
