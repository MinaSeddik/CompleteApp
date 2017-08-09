package com.mina.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by menai on 2017-08-08.
 */
@Component
public class SimpleLogoutSuccessHandler implements LogoutSuccessHandler{

    private static final Logger logger = LoggerFactory.getLogger(SimpleLogoutSuccessHandler.class);

    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {


        try {
            httpServletRequest.getSession().invalidate();
            logger.debug("User Successfully Logout");
        } catch (Exception ex) {
            logger.debug("User Logout ex: ", ex);
        }

        String responseJson = "{\"statusCode\" : \"OK\", \"message\" : \"Successful logout\" }";
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);

        logger.debug("Successful logout");

        PrintWriter writer = httpServletResponse.getWriter();
        writer.write(responseJson);
        writer.flush();
    }


}
