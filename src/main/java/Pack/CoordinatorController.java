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

    @GetMapping ("/coordinator")
    public String coordinatorForm(Model model) {
        model.addAttribute( "event", eventRepository.findAll());
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
}