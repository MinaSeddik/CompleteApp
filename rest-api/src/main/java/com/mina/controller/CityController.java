package com.mina.controller;

import com.mina.model.City;
import com.mina.repository.jdbc.DefaultCityRepository;
import com.mina.service.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by menai on 2017-08-11.
 */
@Controller
public class CityController {

    private static final Logger logger = LoggerFactory.getLogger(CityController.class);

    @Autowired
    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }


    @RequestMapping(path = "/cities", method = RequestMethod.GET)
    @ResponseBody
    public List<City> getAllCities() {

        List<City> cities = cityService.getAllCities();

        return cities;
    }
}
