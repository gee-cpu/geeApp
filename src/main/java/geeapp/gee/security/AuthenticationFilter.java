package geeapp.gee.security;


import com.fasterxml.jackson.databind.ObjectMapper;
import geeapp.gee.userdetailsrequestmodel.UserLogInModel;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager;

    public AuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }
    @Override
    public Authentication attemptAuthentication(HttpServletRequest req ,
                                                HttpServletResponse)throws {
        try {
            UserLogInModel creds=new ObjectMapper().
                    readValue(req.getInputStream(),UserLogInModel.class);
            return AuthenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            creds.getEmail(),
                            creds.getPassword(),
                            new ArrayList<>()
                    )
            );
        }
        catch (IOException e){ throw new RuntimeException(e);}
    }

}
