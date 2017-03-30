package com.mina.service.impl;

import com.mina.domain.LocationEntity;
import com.mina.mapper.OrikaBeanMapper;
import com.mina.model.Location;
import com.mina.repository.LocationRepository;
import com.mina.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by menai on 2017-03-22.
 */
@Service
public class DefaultLocationService implements LocationService {

    @Autowired
    private LocationRepository locationRepository;

    private OrikaBeanMapper orikaMapper;

    @Autowired
    public void setOrikaMapper(OrikaBeanMapper orikaMapper) {
        this.orikaMapper = orikaMapper;
    }

    @Override
    public Location getLocationById(Long id) {
        LocationEntity locationEntity = locationRepository.findLocationById(id);

        return orikaMapper.map(locationEntity, Location.class);
    }


}
