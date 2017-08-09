package com.mina.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by menai on 2017-03-21.
 */
public class SimpleUrlAuthenticationFailHandler implements AuthenticationFailureHandler {

    private static final Logger logger = LoggerFactory.getLogger(SimpleUrlAuthenticationFailHandler.class);

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception)
            throws IOException, ServletException {

        String responseJson = "{\"statusCode\" : \"" + HttpServletResponse.SC_UNAUTHORIZED + "\", \"message\" : \"Invalid Credentials\" }";
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        logger.debug("Invalid login : {}", exception.getMessage());

        PrintWriter writer = response.getWriter();
        writer.write(responseJson);
        writer.flush();
    }

}
