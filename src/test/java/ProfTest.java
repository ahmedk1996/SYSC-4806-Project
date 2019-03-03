import Pack.Prof;
import Pack.Topic;

import static org.junit.Assert.*;

public class ProfTest {

   Prof prof;
   Topic topic;

    @org.junit.Test
    public void addBuddy() {
        prof = new Prof();
        topic = new Topic("fly","software",333);
        prof.addTopic(topic);
        assertEquals("size should be 1" ,1, prof.getSize());
    }
}