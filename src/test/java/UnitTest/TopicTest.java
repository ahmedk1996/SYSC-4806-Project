package UnitTest;

import Pack.Student;
import Pack.Topic;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
        List<String> empty = new ArrayList<>();
        Assert.assertEquals("Null Test", empty ,topicTest.getAnnouncementList());

    }

    @Test
    public void addAnnouncement() {
        announcement = "test";
        topicTest.addAnnouncement(announcement);
        Assert.assertEquals("injection Test", announcement ,topicTest.getAnnouncementList().get(0));
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