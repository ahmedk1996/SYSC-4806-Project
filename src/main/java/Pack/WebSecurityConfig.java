package Pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private AuthenticationSuccessHandler authenticationSuccessHandler;

    @Autowired
    public WebSecurityConfig(AuthenticationSuccessHandler authenticationSuccessHandler) {
        this.authenticationSuccessHandler = authenticationSuccessHandler;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/professor").hasRole("PROFESSOR")
                .antMatchers("/all").hasRole("PROFESSOR")
                .antMatchers("/allStudents").hasRole("PROFESSOR")
                .antMatchers("/add").hasRole("PROFESSOR")
                .antMatchers("/display").hasRole("PROFESSOR")
                .antMatchers("/date").hasRole("PROFESSOR")
                .antMatchers("/datePicker").hasRole("PROFESSOR")
                .antMatchers("/dateConfirmed").hasRole("PROFESSOR")
                .antMatchers("/prof/topic").hasRole("PROFESSOR")
                .antMatchers("/prof").hasRole("PROFESSOR")
                .antMatchers("/Prof").hasRole("PROFESSOR")
                .antMatchers("/addform").hasRole("PROFESSOR")
                .antMatchers("/Addform").hasRole("PROFESSOR")
                .antMatchers("/createEvent").hasRole("PROFESSOR")
                .antMatchers("/displayEvents").hasRole("PROFESSOR")
                .antMatchers("/coord").hasRole("COORDINATOR")
                .antMatchers("/addEvents").hasRole("COORDINATOR")
                .antMatchers("/studentEnrollment").hasRole("COORDINATOR")
                .antMatchers("/Availability").hasRole("COORDINATOR")
                .antMatchers("/AddEvents").hasRole("COORDINATOR")
                .antMatchers("/projectDeadline").hasRole("COORDINATOR")
                .antMatchers("/CreateEvent").hasRole("COORDINATOR")
                .antMatchers("/display").hasRole("STUDENT")
                .antMatchers("/student").hasRole("STUDENT")
                .antMatchers("/students").hasRole("STUDENT")
                .antMatchers("/studentHome").hasRole("STUDENT")
                .antMatchers("/uploadTemplate").hasRole("STUDENT")
                .antMatchers("/OverdueError").hasRole("STUDENT")
                .antMatchers("/projectDetail").hasRole("STUDENT")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .successHandler(authenticationSuccessHandler)
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .and().csrf().disable();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager users = new InMemoryUserDetailsManager();
        users.createUser(User.withDefaultPasswordEncoder()
                .username("alybarolia")
                .password("123")
                .roles("STUDENT").build());
        users.createUser(User.withDefaultPasswordEncoder()
                .username("hun")
                .password("123")
                .roles("STUDENT").build());
        users.createUser(User.withDefaultPasswordEncoder()
                .username("jefftudor")
                .password("123")
                .roles("STUDENT").build());
        users.createUser(User.withDefaultPasswordEncoder()
                .username("ahmad")
                .password("123")
                .roles("STUDENT").build());
        users.createUser(User.withDefaultPasswordEncoder()
                .username("jenna")
                .password("sysc")
                .roles("COORDINATOR").build());
        users.createUser(User.withDefaultPasswordEncoder()
                .username("babak")
                .password("sysc")
                .roles("PROFESSOR").build());

        return users;
    }




}