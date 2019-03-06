package Pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Iterator;

@Controller
public class StudentController {

    @Autowired
    private TopicRepository topicRepository;
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping(value = "/student")
    public String display ( Model model){

        model.addAttribute( "topicList", topicRepository.findAll());
        return "Student";
    }

    @RequestMapping(params = "join")
    public String joiningTopic(Model model){

        return "Student";
    }


/*
    @GetMapping(value = "/student" )
    public String studentNew(Model model) {
        model.addAttribute("student", new Student());
        return "Student" ;
    }

    @PostMapping(value = "/student" )
    public String studentSubmit(@ModelAttribute Student student) {
        studentRepository.save(student);

        return "Student";
    }
  */




/*
    @GetMapping("/projectdisplay")
    public String displayBuddy(@RequestParam(value="topic") Topic topic, Model model ){

       String topicList = studentRepository.toString();
        System.out.println(topicList);
        model.addAttribute("print", topicList);
        return "Student";
    }
*/
}
