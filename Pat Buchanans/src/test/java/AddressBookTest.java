import Pack.AddressBook;
import Pack.JBuddy;

import static org.junit.Assert.*;

public class AddressBookTest {

   AddressBook address;
   JBuddy budd;

    @org.junit.Test
    public void addBuddy() {
        address = new AddressBook();
        budd = new JBuddy("fly",333);
        address.addBuddy(budd);
        assertEquals("size should be 1" ,1,address.getSize());
    }
}