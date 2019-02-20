import Pack.JBuddy;
import org.junit.Test;

import static org.junit.Assert.*;

public class JBuddyTest {
    JBuddy budd;
    @Test
    public void getName() {
        budd = new JBuddy("hh",555);
        assertEquals("The name should be hh","hh",budd.getName());
    }

    @Test
    public void setName() {
        budd = new JBuddy("hh",555);
        budd.setName("ah");
        assertEquals("The name should be ah","ah",budd.getName());
    }

    @Test
    public void getPhoneN() {
        budd = new JBuddy("hh",555);
        assertEquals("The number should be 555",555,budd.getPhoneN());
    }

    @Test
    public void setPhoneN() {
        budd = new JBuddy("hh",555);
        budd.setPhoneN(44);
        assertEquals("The number should be 44",44,budd.getPhoneN());
    }






}