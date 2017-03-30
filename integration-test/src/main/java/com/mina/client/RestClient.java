package com.mina.client;

import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * Created by menai on 2017-03-24.
 */
public class RestClient {

    public static <T> T sendGetWithParameters(String path, MultiValueMap<String, String> map, Class<T> clazz) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject(path, map, clazz);
    }


}
