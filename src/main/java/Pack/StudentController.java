package Pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/StudentHome")
public class StudentController {

    @Autowired
    private TopicRepository topicRepository;
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping()
    public String studentName(Model model){
        String name= "Hunho Ha";
        model.addAttribute("name",name);
        return "StudentHome";
    }


    @GetMapping("/")
    public String studentHome(){
        return "StudentHome";
    }

//    @GetMapping
//    public String getList (Model model){
//       model.addAttribute("topic", topicRepository.findAll());
//       return "StudentHome";
//    }

    @PostMapping("/display")
    public String display(Model model,@ModelAttribute Topic topic){

        model.addAttribute("topic", topicRepository.findAll());

        return "StudentHome";
    }







}
