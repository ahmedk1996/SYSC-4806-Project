package IntegrationTest;

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


import Pack.*;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = Application.class)
public class FileUploadIntegrationTests {
    @Autowired
    private WebApplicationContext app;
    private MockMvc mockMVC;

    @Before
    public void setup(){
        this.mockMVC = MockMvcBuilders.webAppContextSetup(this.app).build();
    }

    @Test
    public void testStudentsWithoutProjects() throws Exception{
        this.mockMVC.perform(get("/upload")).andExpect(status().isOk()).andExpect(view().name("uploadTemplate"));
    }



}


