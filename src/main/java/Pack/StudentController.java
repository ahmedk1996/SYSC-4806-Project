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
    @Autowired
    private DateRepo dateRepo;

    @GetMapping("/StudentHome")
    public String studentName(Model model){
        model.addAttribute("topicList", topicRepository.findAll());
        String name= "Hunho Ha";
        model.addAttribute("name",name);
        return "StudentHome";
    }

    @GetMapping(value= "/dateSubmit")
    public String dateSubmit(Model model){
        model.addAttribute("date", new AvailabilityDate());

        return "datePicker";
    }


    @PostMapping(value = "/dateSubmit")
    public String studentDate(@ModelAttribute AvailabilityDate dates, Model model){
        dateRepo.save(dates);
        model.addAttribute("dates", dates);
        return "dateConfirmed";
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
