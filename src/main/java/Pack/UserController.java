
package Pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping ("/register")
    public String addForm(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @GetMapping ("/users")
    public String display (Model model,@ModelAttribute User user){
        model.addAttribute( "user", userRepository.findAll());
        return "users";
    }

    @PostMapping("/register")
    public String addSubmit(@ModelAttribute User user, Model model) {
        userRepository.save(user);
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        model.addAttribute("user", userRepository);
        return "users";
    }


}

