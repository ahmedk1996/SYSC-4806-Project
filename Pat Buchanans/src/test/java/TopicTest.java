import Pack.Topic;
import org.junit.Test;

import static org.junit.Assert.*;

public class TopicTest {
    Topic budd;
    @Test
    public void getName() {
        budd = new Topic("hh",555);
        assertEquals("The name should be hh","hh",budd.getDescription());
    }

    @Test
    public void setName() {
        budd = new Topic("hh",555);
        budd.setDescription("ah");
        assertEquals("The name should be ah","ah",budd.getDescription());
    }

    @Test
    public void getPhoneN() {
        budd = new Topic("hh",555);
        assertEquals("The number should be 555",555,budd.getMax_Students());
    }

    @Test
    public void setPhoneN() {
        budd = new Topic("hh",555);
        budd.setMax_Students(44);
        assertEquals("The number should be 44",44,budd.getMax_Students());
    }






}