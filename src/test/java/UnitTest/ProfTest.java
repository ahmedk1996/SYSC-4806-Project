package UnitTest;

import Pack.Application;
import Pack.Prof;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = Application.class)
public class ProfTest {

    @Autowired
    private WebApplicationContext app;
    private MockMvc mockMVC;
    private Prof testProf;
    @Before
    public void setUp() throws Exception {
        this.mockMVC = MockMvcBuilders.webAppContextSetup(this.app).build();
        testProf = new Prof("Mr.Testy", 1);
    }

    @Test
    public void getIdTest(){
        assertEquals("Expected output is 1",1, testProf.getId());
    }

    @Test
    public void getNameTest(){
        assertEquals("Expected output is Mr.Testy","Mr.Testy", testProf.getName());
    }

    @Test
    public void setNameTest() {
        testProf.setName("Testie");
        assertEquals("Expected: testie is the new name","Testie",testProf.getName());
    }

    @Test
    public void setIdTest() {
        testProf.setId(2);
        assertEquals("Expected: testie new id is 2",2,testProf.getId());
    }
}
