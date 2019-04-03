package IntegrationTest;

import Pack.Application;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = Application.class)
public class ProfIntegrationTest {
    @Autowired
    private WebApplicationContext app;
    private MockMvc mockMVC;

    @Before
    public void setup(){
        this.mockMVC = MockMvcBuilders.webAppContextSetup(this.app).build();
    }

    @Test
    public void testProfPage() throws Exception{
        this.mockMVC.perform(get("/prof")).andExpect(status().isOk()).andExpect(view().name("Prof"));
    }
    @Test
    public void testProfViewTopicPage() throws Exception{
        this.mockMVC.perform(get("/prof/topic")).andExpect(status().isOk()).andExpect(view().name("ProfTopic"));
    }
    @Test
    public void testProfDelete() throws Exception{
        this.mockMVC.perform(get("/delete")).andExpect(status().isOk()).andExpect(view().name("Prof"));
    }
    @Test
    public void testProfArchive() throws Exception{
        this.mockMVC.perform(get("/archive")).andExpect(status().isOk()).andExpect(view().name("Prof"));
    }
    @Test
    public void testProfActivate() throws Exception{
        this.mockMVC.perform(get("/activate")).andExpect(status().isOk()).andExpect(view().name("Prof"));
    }
    public void testProfAddTopicPage() throws Exception{
        this.mockMVC.perform(get("/add")).andExpect(status().isOk()).andExpect(view().name("Addform"));
    }
}