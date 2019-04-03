package Pack;
import java.text.DateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class CoordinatorController {


    @Autowired
    EventRepository eventRepository;
    @Autowired
    StudentRepository studentRepository;
    public static Date date;


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

    @GetMapping (value = "/projectDeadline")
    public String projectDeadline(Model model){

        model.addAttribute("deadline", new AvailabilityDate());


        return "projectDeadline";
    }

    @PostMapping (value= "/projectDeadline")
    public String deadline(@ModelAttribute AvailabilityDate dates, Model model) throws ParseException {
        String s = dates.getnewDate1().replace('-','/');
        String f = dates.getnewTime1();
        String l = s + " " + f;
        Date date1 = new SimpleDateFormat("yyyy/MM/dd HH:mm").parse(l);
        System.out.println("Deadline is: " + date1);
        date = date1;
        model.addAttribute("date", dates);
        return "Coordinator";
    }

}