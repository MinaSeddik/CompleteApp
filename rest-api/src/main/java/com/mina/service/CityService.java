package com.mina.service;

import com.mina.model.City;

import java.util.List;

/**
 * Created by menai on 2017-03-22.
 */
public interface CityService {

    City getCityById(Long cityId);

    List<City> getAllCities();

}
