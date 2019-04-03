package UnitTest;

import Pack.Application;
import Pack.Event;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = Application.class)
public class EventTest {
    @Autowired
    private WebApplicationContext app;
    private MockMvc mockMVC;
    private Event testEvent;
    @Before
    public void setUp() throws Exception {
        this.mockMVC = MockMvcBuilders.webAppContextSetup(this.app).build();
        testEvent = new Event("Presentation","10 minutes", 1);
    }

    @Test
    public void getIdTest(){
        assertEquals("Expected output is 1",(1), testEvent.getId());
    }

    @Test
    public void getNameTest(){
        assertEquals("Expected output is Presentation","Presentation", testEvent.getEventName());
    }

    @Test
    public void setNameTest() {
        testEvent.setEventName("testy");
        assertEquals("Expected: testy is the new name","testy",testEvent.getEventName());
    }

    @Test
    public void setIdTest() {
        testEvent.setId(2);
        assertEquals("Expected: testie new id is 2",2,testEvent.getId());
    }

    @Test
    public void getDescriptionTest() {
        assertEquals("Expected output is 10 minutes","10 minutes", testEvent.getDescription());
    }
    @Test
    public void setDescriptionTest() {
        testEvent.setDescription("5 minutes");
        assertEquals("Expected output is 5 minutes","5 minutes", testEvent.getDescription());

    }
}
