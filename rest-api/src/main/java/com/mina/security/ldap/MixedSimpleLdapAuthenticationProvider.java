package com.mina.security.ldap;


import com.mina.model.User;
import com.mina.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by menai on 2017-03-15.
 */
//@Component
public class MixedSimpleLdapAuthenticationProvider implements AuthenticationProvider {

    private static final Logger logger = LoggerFactory.getLogger(MixedSimpleLdapAuthenticationProvider.class);

    @Autowired
    private LdapTemplate ldapTemplate;

    @Autowired
    private UserService userService;

    @Value("${ldap.base}")
    private String ldapBase;

    @Value("${ldap.groups.search.filter}")
    private String searchFilter;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName = authentication.getName();

        logger.debug("find LDAP groups for user: {}", userName);
        List<String> groups = findLdapGroups(userName);

        logger.debug("there are {} LDAP groups for user: {}, {}", groups.size(), userName, groups);

        logger.debug("authenticate user: {}", userName);
        User user = userService.getUserByUsername(userName);

        if (user != null && user.isActive()) {
            String password = authentication.getCredentials().toString();
            if (password.equals(user.getPassword())) {
                List authorities = new ArrayList(user.getAuthorities());
                authorities.addAll(groups);
                Authentication auth = new UsernamePasswordAuthenticationToken(user, password, authorities);
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

    private List<String> findLdapGroups(String userName) {

        logger.info("searchFilter : {}", searchFilter);
        logger.info("ldapBase : {}", ldapBase);

        String searchfilterForUser = searchFilter.replace("{0}", userName);
        logger.info("searchfilterForUser : {}", searchfilterForUser);

        List<String> list = ldapTemplate.search("", searchfilterForUser,
                new AttributesMapper() {
                    public Object mapFromAttributes(Attributes attrs)
                            throws NamingException {


                        return attrs.get("cn").get().toString();
                    }
                });

        logger.info("list size : {}", list.size());
        logger.info("groups : {}", list);
        return list;
    }

}
