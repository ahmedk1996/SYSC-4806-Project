package Pack;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;


@Configuration
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {


    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {

        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());

        /*if (roles.contains("ROLE_ADMIN")) {
            httpServletResponse.sendRedirect("/admin");

        } else if (roles.contains("ROLE_USER")) {
            httpServletResponse.sendRedirect("/user");
        }else{
            httpServletResponse.sendRedirect("/index");
        }*/
        if (roles.contains("ROLE_PROFESSOR")) {
            httpServletResponse.sendRedirect("/professor");

        } else if (roles.contains("ROLE_COORDINATOR")) {
            httpServletResponse.sendRedirect("/coord");
        } else if (roles.contains("ROLE_STUDENT")) {
            httpServletResponse.sendRedirect("/index");
        }

    }
}


