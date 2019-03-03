import Pack.Topic;
import org.junit.Test;

import static org.junit.Assert.*;

public class TopicTest {
    Topic topic;
    @Test
    public void getName() {
        topic = new Topic("hh","software",555);
        assertEquals("The name should be hh","hh", topic.getDescription());
    }

    @Test
    public void setName() {
        topic = new Topic("hh","software",555);
        topic.setDescription("ah");
        assertEquals("The name should be ah","ah", topic.getDescription());
    }

    @Test
    public void getPhoneN() {
        topic = new Topic("hh","software",555);
        assertEquals("The number should be 555",555, topic.getMax_Students());
    }

    @Test
    public void setPhoneN() {
        topic = new Topic("hh","software",555);
        topic.setMax_Students(44);
        assertEquals("The number should be 44",44, topic.getMax_Students());
    }




}