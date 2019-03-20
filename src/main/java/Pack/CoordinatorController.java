/*
package Pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CoordinatorController {


    @Autowired
    EventRepository eventRepository;

    @GetMapping ("/coordinator")
    public String coordinatorForm(Model model) {
        model.addAttribute("event", new Event());
        return "Coordinator";
    }

    @PostMapping("/addEvents")
    public String addSubmit(@ModelAttribute Event event, Model model) {
        Event newEvent;
        newEvent = event;
        eventRepository.save(newEvent);
        model.addAttribute("event", newEvent);
        return "AddEvents";
    }

    @GetMapping ("/allevents")
    public String displayEvents (Model model,@ModelAttribute Event event){
        model.addAttribute( "event", eventRepository.findAll());
        return "DisplayEvents";
    }


}
*/
