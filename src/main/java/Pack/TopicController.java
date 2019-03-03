package Pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class TopicController {

    @Autowired
    private ProfRepository profRepository;


    @GetMapping("/create")
    public String greetingForm(Model model) {
        model.addAttribute("addressBook", new Prof());
        return "createAddressBook";
    }

    @PostMapping("/create")
    public String greetingSubmit(@ModelAttribute Prof prof) {
        profRepository.save(prof);
        return "createAddressBook";
}
}