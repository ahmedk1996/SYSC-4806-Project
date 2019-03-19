package UnitTest;

import Pack.Application;
import Pack.Student;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = Application.class)

public class StudentUnitTest {

    @Autowired
    private WebApplicationContext app;
    private MockMvc mockMVC;
    private Student stu;

    @Before
    public void setup() {
        stu = new Student("AK", 101008206, "Software Engineering");
    }

    @Test
    public void getIdTest(){
        assertEquals("Expected output is 101008206",(Integer) 101008206, stu.getId());
    }

    @Test
    public void getNameTest(){
        assertEquals("Expected output is AK","AK", stu.getName());
    }

    @Test
    public void getProjectIdTest(){ //testing student with not enrolled in a project yet
        assertEquals("Expected output should be null as a student has not enrolled in a project yet", null, stu.getProjectId());
    }

    @Test
    public void getProjectIDTest1(){ //testing if we can access the students project id once enrolled in a project
        stu.setProjectId(3456);
        assertEquals("Should output 3456", (Integer) 3456, stu.getProjectId());
    }

    @Test
    public void getProgramTest(){
        assertEquals("Expected output is Software Engineering", "Software Engineering", stu.getProgram());
    }


}


