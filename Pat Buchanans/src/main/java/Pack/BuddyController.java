package Pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class BuddyController {

   private  JBuddy buddy;
   private AddressBook address;

    @Autowired
    private AddressBookRepository addressBookR;

    @GetMapping("/add")
    public String addBuddy(@RequestParam(value="name") String name,@RequestParam(value="number") int number, @RequestParam(value="addressBook") Integer addressBook  ){
        buddy = new JBuddy(name,number);
       address= addressBookR.findById(addressBook).get();
       return "addressBook";
    }

    @PostMapping("/add")
    public String greetingSubmit(@ModelAttribute AddressBook print) {
        return "addressBook";
    }

    @GetMapping("/remove")
    public void removeBuddy(@RequestParam(value="buddy") int buddy, @RequestParam(value="addressBook") Integer addressBook  ){

        addressBookR.findById(addressBook).get().removeBuddy(buddy);
    }


}
