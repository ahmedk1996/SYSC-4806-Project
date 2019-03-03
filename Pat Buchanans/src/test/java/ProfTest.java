import Pack.Prof;
import Pack.Topic;

import static org.junit.Assert.*;

public class ProfTest {

   Prof address;
   Topic budd;

    @org.junit.Test
    public void addBuddy() {
        address = new Prof();
        budd = new Topic("fly",333);
        address.addBuddy(budd);
        assertEquals("size should be 1" ,1,address.getSize());
    }
}