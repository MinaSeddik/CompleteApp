package com.mina.scenario;

import com.mina.client.RestClient;
import com.mina.client.UrlTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * Created by menai on 2017-03-24.
 */
public class SimpleLoginScenario {

    public static SimpleLoginScenario startSimpleLoginScenario(){
        return new SimpleLoginScenario();
    }

    public SimpleLoginScenario login(String userName, String password) {

        String path = UrlTemplate.getLoginUrl();
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("username", userName);
        map.add("password", password);

        RestClient.sendGetWithParameters(path, map, String.class);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.postForEntity(path, map, String.class);
        if (response.getStatusCode() != HttpStatus.OK) {
            throw new RuntimeException(response.getBody());
        }

        return this;
    }
}
