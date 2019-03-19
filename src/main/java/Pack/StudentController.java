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

    @GetMapping(value = "/students")
    public String display ( Model model){

        model.addAttribute( "topicList", topicRepository.findAll());
        return "Student";
    }

    @GetMapping(value = "/StudentHome")
    public String studentHome(){


        return "StudentHome";
    }

    @GetMapping(value = "/unenrolled")
    private String studentsWithoutProjects(Model model){

        model.addAttribute("noTopic", studentRepository.findAll());
        return "UnenrolledStudents";
    }

}
