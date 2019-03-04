package Pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private TopicRepository TopicRepository;
    private StudentRepository studentRepository;



    /*public StudentController(StudentRepository studentRepository) {

        //this.studentRepository = studentRepository;
    }*/

    @GetMapping(value = "/student")
    public String studentNew(Model model) {
        model.addAttribute("student", new Student());
        return "Student";
    }

    @PostMapping(value = "/student")
    public String studentSubmit(@ModelAttribute Student student) {
        studentRepository.save(student);
        return "Student";
    }

   /* @RequestMapping(value = "/student", method = RequestMethod.GET)
    public ModelAndView getdata() {

        List<String> list = getList();

        //return back to index.jsp
        ModelAndView model = new ModelAndView("index");
        model.addObject("lists", list);

        return model;

    }*/

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



    @GetMapping("/projectdisplay")
    public String displayBuddy(@RequestParam(value="topic") Topic topic, Model model ){

       String topicList = studentRepository.toString();
        System.out.println(topicList);
        model.addAttribute("print", topicList);
        return "Student";
    }

}
