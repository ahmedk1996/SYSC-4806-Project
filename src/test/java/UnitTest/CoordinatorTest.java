package UnitTest;

import Pack.Application;
import Pack.Coordinator;
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
public class CoordinatorTest {

        @Autowired
        private WebApplicationContext app;
        private MockMvc mockMVC;
        private Coordinator testCor;
        @Before
        public void setUp() throws Exception {
            this.mockMVC = MockMvcBuilders.webAppContextSetup(this.app).build();
            testCor = new Coordinator("Vicky", 1);
        }

        @Test
        public void getIdTest(){
            assertEquals("Expected output is 1",new Integer(1), testCor.getId());
        }

        @Test
        public void getNameTest(){
            assertEquals("Expected output is Vicky","Vicky", testCor.getName());
        }

        @Test
        public void setNameTest() {
            testCor.setName("Kunz");
            assertEquals("Expected: Kunz is the new name","Kunz",testCor.getName());
        }

        @Test
        public void setIdTest() {
            testCor.setId(2);
            assertEquals("Expected: testie new id is 2",new Integer(2),testCor.getId());
        }
}
