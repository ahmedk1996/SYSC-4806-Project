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


    private TopicRepository TopicRepository;
    @Autowired
    private StudentRepository studentRepository;



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
/*
    @RequestMapping(value = "/studentshow", method = RequestMethod.GET)
    public ModelAndView getdata() {

        List<String> list = getList();

        //return back to index.jsp
        ModelAndView model = new ModelAndView("index");
        model.addObject("lists", list);

        return model;

    }

    private List<String> getList() {

        List<String> list = new ArrayList<String>();
        list.add("List A");
        list.add("List B");
        list.add("List C");
        list.add("List D");
        list.add("List 1");
        list.add("List 2");
        list.add("List 3");

        return list;

    }
*/

    @GetMapping ("/students")
    public String display (Model model){
        model.addAttribute( "studentList", studentRepository.findAll());
        return "Student";
    }
    

    @GetMapping("/projectdisplay")
    public String displayBuddy(@RequestParam(value="topic") Topic topic, Model model ){

       String topicList = studentRepository.toString();
        System.out.println(topicList);
        model.addAttribute("print", topicList);
        return "Student";
    }

}
