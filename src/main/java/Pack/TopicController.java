package Pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TopicController {

    @Autowired
    ProfRepository addressRepo;
    Prof newBook;
    @Autowired
    TopicRepository BuddyRepo;

    @GetMapping ("/add")
    public String addForm(Model model) {
        model.addAttribute("buddy", new Topic());
        return "Addform";
    }

    @PostMapping("/add")
    public String addSubmit(@ModelAttribute Topic buddyinfo, Model model) {
        Topic bud;
        bud = buddyinfo;
        BuddyRepo.save(bud);
        model.addAttribute("buddy", bud);
        return "AddResult";
    }

    @GetMapping ("/all")
    public String display (Model model){
        model.addAttribute( "buddies", BuddyRepo.findAll());
        return "Display";
    }

    @RequestMapping ("/add")
    public String addBuddy (@RequestParam (value = "name") String name, @RequestParam (value = "name") String programRestrictions,@RequestParam (value = "number") int number, @RequestParam (value = "book") int addressBookID, Model model){


        for (Prof address : addressRepo.findProfById(addressBookID)) {
            newBook= address;
        }

        Topic newBuddy = new Topic(name,programRestrictions ,number);
        newBuddy.setId(number);

        BuddyRepo.save(newBuddy);
        newBook.addTopic(newBuddy);


        addressRepo.save(newBook);
        model.addAttribute("addressbook", newBook);
        return "AddressBook";
    }

}