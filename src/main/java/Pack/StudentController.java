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

    @GetMapping(value= "/dateSubmit")
    public String dateSubmit(Model model){
        model.addAttribute("date", new AvailabilityDate());

        return "datePicker";
    }


    @PostMapping(value = "/dateSubmit")
    public String studentDate(@ModelAttribute AvailabilityDate dates, Model model){
        model.addAttribute("dates", dates);
        return "dateConfirmed";
    }


    @GetMapping("/join")
    public String join(@RequestParam String topicName,Model model){
        Topic topic = topicRepository.findByTopicName(topicName);
        model.addAttribute("topicdetail",topic);
        if(topic.isFull()){
            return "StudentHome";
        }else{
            
            topic.addStudent()
            return "StudentHome";
        }

    }

    @GetMapping("/detail")
    public String detail(@RequestParam String topicName,Model model){
        Topic topic = topicRepository.findByTopicName(topicName);
        model.addAttribute("topicdetail",topic);
        model.addAttribute(topicName,topic.getTopicName());

        return "ProjectDetail";
    }

    @GetMapping("/StudentHome/ProjectDetail")
    public String ProjectDetail(){
//        Topic topic = topicRepository.findByTopicName(topicName);
//        model.addAttribute("topicdetail",topic);
        return "ProjectDetail";
    }





}
