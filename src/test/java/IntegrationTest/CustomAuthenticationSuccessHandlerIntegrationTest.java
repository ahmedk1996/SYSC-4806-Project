package IntegrationTest;

import Pack.Application;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = Application.class)
public class CustomAuthenticationSuccessHandlerIntegrationTest {
    @Autowired
    private WebApplicationContext app;
    private MockMvc mockMvc;

    @Before
    public void setup(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.app).build();
    }

    @Test
    public void testLoginValid() throws Exception {
        SecurityMockMvcRequestBuilders.FormLoginRequestBuilder login = formLogin()
                .user("student2")
                .password("pass");

        mockMvc.perform(login)
                .andExpect(authenticated().withUsername("student2"));
    }

    @Test
    public void testLoginInValid() throws Exception {
        SecurityMockMvcRequestBuilders.FormLoginRequestBuilder login = formLogin()
                .user("invalid")
                .password("invalidpassword");

        mockMvc.perform(login)
                .andExpect(unauthenticated());
    }


    @Test
    @WithMockUser
    public void testAccess() throws Exception {
        mockMvc.perform(get("/index"))
                .andExpect(status().isOk());
    }


    @Test
    @WithMockUser(roles = "STUDENT")
    public void testLoginUser() throws Exception {
        mockMvc.perform(get("/index"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("STUDENT")));
    }

    @Test
    @WithMockUser(roles = "PROFESSOR")
    public void testLoginAdmin() throws Exception {
        mockMvc.perform(get("/professor"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("PROFESSOR")));
    }

    @Test
    @WithMockUser(roles = "PROFESSOR")
    public void testLoginRoles() throws Exception {
        mockMvc.perform(get("/professor"))
                .andExpect(status().isForbidden());
    }



}
