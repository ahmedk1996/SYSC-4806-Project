package Pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProfController {

    @Autowired
    private ProfRepository addressRepo;

    @RequestMapping ("/create")
    public Prof newbook (@RequestParam (value = "name", defaultValue = "1") int id, Model model){

        Prof book = new Prof();
        book.setId(id);
        addressRepo.save(book);
        return book;

    }

    @RequestMapping ("/print")
    public int print (@RequestParam (value = "id") int id){
        Prof newBook = new Prof();

        for (Prof address : addressRepo.findProfById(id)) {
            newBook= address;
        }

        return newBook.getSize();

    }
/*
    @PostMapping("/create")
    public String printAddressBook(@ModelAttribute AddressBook print){
        return "Created";

    }
*/
}
