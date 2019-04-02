package Pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CoordinatorController {


    @Autowired
    EventRepository eventRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    TopicRepository topicRepository;

    @GetMapping ("/coordinator")
    public String coordinatorForm(Model model) {
        model.addAttribute( "topic", topicRepository.findAll());
        return "Coordinator";
    }

    @GetMapping(value = "/enrollment")
    private String studentsWithoutProjects(Model model){
        model.addAttribute("students", studentRepository.findAll());
        return "StudentEnrollment";
    }

    @GetMapping ("/createEvent")
    public String createEvent (Model model){
        return "AddEvents";
    }
    @PostMapping("/createEvent")
    public String addSubmit(@ModelAttribute Event event, Model model) {
        eventRepository.save(event);
        model.addAttribute("event", event);
        return "AddEvents";
    }


//    @GetMapping ("/notifyForm")
//    public String notifyForm(Model model) {
//        Topic temp = (Topic) topicRepository.findByTopicName("f");
//        String announcement = new String();
//        model.addAttribute( "noti", announcement);
//
//        //model.addAttribute( "noti", topicRepository.findByTopicName("f"));
//        return "addNotifications";
//    }
//    @GetMapping ("/notifyForm")
//    public String notifyForm(Model model) {
//        String announcement = new String();
//        model.addAttribute( "noti", announcement);
//        return "addNotifications";
//    }

    @GetMapping ("/notifyForm")
        public String submitNotification(@RequestParam String topicName,@RequestParam String notification) {
        Topic temp = topicRepository.findByTopicName(topicName);
        temp.setAnnouncement(notification);
        topicRepository.save(temp);

        return "redirect:/coordinator" ;
    }

}