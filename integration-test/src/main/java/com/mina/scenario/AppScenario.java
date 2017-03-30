package com.mina.scenario;

/**
 * Created by menai on 2017-03-24.
 */
public class AppScenario {

    public static AppScenario startAppScenario(){
        return new AppScenario();
    }

    public static SimpleLoginScenario startSimpleLoginScenario() {
        return new SimpleLoginScenario();
    }

}
