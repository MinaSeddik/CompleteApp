package com.mina.security.ldap;

import org.springframework.ldap.core.DirContextOperations;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.ldap.userdetails.LdapAuthoritiesPopulator;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashSet;

/**
 * Created by menai on 2017-03-29.
 */
@Component
public class CustomLdapAuthoritiesPopulator implements LdapAuthoritiesPopulator {

    @Override
    public Collection<? extends GrantedAuthority> getGrantedAuthorities(DirContextOperations userData, String username) {
        Collection<GrantedAuthority> gas = new HashSet<GrantedAuthority>();
        if (username.equals("spapas")) {
            gas.add(new SimpleGrantedAuthority("admin"));
        }
        gas.add(new SimpleGrantedAuthority("user"));
        return gas;
    }

}
