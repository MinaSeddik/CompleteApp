package com.mina.test;

import com.mina.scenario.AppScenario;
import org.junit.Test;

/**
 * Created by menai on 2017-03-24.
 */
public class LoginTest {

    @Test
    public void loginTest() {

        String userName = "root";
        String password = "root";

        AppScenario.startAppScenario()
                .startSimpleLoginScenario()
                .login(userName, password);


    }
}
