package com.mina.repository;

import com.mina.domain.CityEntity;

import java.util.List;

/**
 * Created by menai on 2017-03-21.
 */
public interface CityRepository {

    CityEntity findCityById(Long id);

    List<CityEntity> getAllCities();
}
