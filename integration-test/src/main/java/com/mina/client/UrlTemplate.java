package com.mina.client;

import java.util.ResourceBundle;

/**
 * Created by menai on 2017-03-24.
 */
public class UrlTemplate {

    private static String baseUrl;

    private static final String LOGIN_URL = "/login";


    static {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("config");
        baseUrl = resourceBundle.getString("test.baseurl");
    }

    public static String getLoginUrl() {
        return baseUrl + LOGIN_URL;
    }


}
