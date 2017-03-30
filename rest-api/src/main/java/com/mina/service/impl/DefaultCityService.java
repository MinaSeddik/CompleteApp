package com.mina.service.impl;

import com.mina.domain.CityEntity;
import com.mina.mapper.OrikaBeanMapper;
import com.mina.model.City;
import com.mina.repository.CityRepository;
import com.mina.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by menai on 2017-03-22.
 */
@Service
public class DefaultCityService implements CityService {

    @Autowired
    private CityRepository cityRepository;

    private OrikaBeanMapper orikaMapper;

    @Autowired
    public void setOrikaMapper(OrikaBeanMapper orikaMapper) {
        this.orikaMapper = orikaMapper;
    }

    @Override
    public City getCityById(Long id) {
        CityEntity cityEntity = cityRepository.findCityById(id);

        return orikaMapper.map(cityEntity, City.class);
    }

}
