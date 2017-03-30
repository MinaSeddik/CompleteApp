package com.mina.controller;

import com.mina.security.ldap.LdapAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by menai on 2017-03-12.
 */
@Controller
public class SimpleController {

//    @Autowired
//    private final LdapAuthenticationProvider ldapClass;

//    @Autowired
//    public SimpleController(LdapAuthenticationProvider ldapClass) {
//        this.ldapClass = ldapClass;
//    }

    @RequestMapping(path = "/koko", method = RequestMethod.GET)
    public List<String> simpleEntryForTest() {

//        List<String> list = ldapClass.login("eee");

        return null;
    }

}
