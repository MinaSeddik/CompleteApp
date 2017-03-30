package com.mina.security.auth;

import com.mina.model.User;
import com.mina.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

/**
 * Created by menai on 2017-03-22.
 */
@Component
public class SimpleAuthenticationProvider implements AuthenticationProvider {

    private static final Logger logger = LoggerFactory.getLogger(SimpleAuthenticationProvider.class);

    @Autowired
    private UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName = authentication.getName();

        logger.debug("authenticate user: {}", userName);
        User user = userService.getUserByUsername(userName);

        if (user != null && user.isActive()) {
            String password = authentication.getCredentials().toString();
            if (password.equals(user.getPassword())) {
                Authentication auth = new UsernamePasswordAuthenticationToken(user, password, user.getAuthorities());
                logger.debug("user: {} has been authenticated successfully", userName);
                return auth;
            } else {
                logger.debug("Invalid Credentials for  user: {}", userName);
                return null;
            }

        } else {
            logger.debug("Invalid authentication for  user: {}", userName);
            return null;
        }

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}
