package UnitTest;

import Pack.Student;
import Pack.Topic;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TopicTest {
    Topic topicTest;
    String announcement;
    @Before
    public void setUp() throws Exception {
        topicTest = new Topic("testName","testDescription","none",1);
    }

    @Test
    public void isAvailable() {
        Assert.assertTrue("Expected Value is True", topicTest.isAvailable());
    }

    @Test
    public void getAnnouncementList() {
        topicTest.setAnnouncement("");
        assertEquals("Null Test", "" ,topicTest.getAnnouncement());

    }


    @Test
    public void getMax_Students() {
        Assert.assertNotEquals("Expected Value : 3",3,topicTest.getMax_Students());
    }

    @Test
    public void isFull() {
        Assert.assertFalse("Expected Value : False",topicTest.isFull());
        Student test = new Student("Hun",123,"Soft");
        topicTest.addStudent(test);
        Assert.assertTrue("Expected Value : True",topicTest.isFull());

    }


}