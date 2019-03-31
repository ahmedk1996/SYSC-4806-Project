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

    @GetMapping ("/addNotifications")
    public String createNotification (Model model, Topic topic){
        model.addAttribute("topic", topicRepository);
        return "addNotifications";
    }
    @PostMapping("/addNotifications")
    public String submitNotification(@ModelAttribute Topic event, Model model) {
        eventRepository.save(event);
        model.addAttribute("notification", event);
        return "addNotifications";
    }

}