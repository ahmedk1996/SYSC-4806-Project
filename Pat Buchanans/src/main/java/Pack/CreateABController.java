package Pack;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
public class CreateABController {

    @Autowired
    private AddressBookRepository addressBookR;


    @GetMapping("/create")
    public AddressBook createApplication(@RequestParam(value="buddy",defaultValue = "1") Integer buddy){
      AddressBook addressBook=  new  AddressBook();
        addressBook.setId(buddy);
        addressBookR.save(addressBook);

        return addressBook  ;
    }



}
