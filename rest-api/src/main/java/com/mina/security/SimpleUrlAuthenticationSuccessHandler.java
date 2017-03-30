package com.mina.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by menai on 2017-03-21.
 */
@Component
public class SimpleUrlAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private static final Logger logger = LoggerFactory.getLogger(SimpleUrlAuthenticationFailHandler.class);

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException {
        String responseJson = "{statusCode : \"OK\", message : \"Successful login\" }";
        response.setStatus(HttpServletResponse.SC_OK);

        logger.debug("Successful login for: {}", SecurityContextHolder.getContext().getAuthentication().getName());

        PrintWriter writer = response.getWriter();
        writer.write(responseJson);
        writer.flush();
    }

}
