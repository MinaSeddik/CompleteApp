package com.mina.mapper.converter;

import com.mina.domain.LocationEntity;
import com.mina.model.City;
import com.mina.model.Location;
import com.mina.service.CityService;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by menai on 2017-03-22.
 */
@Component
public class LocationMapper extends CustomMapper<LocationEntity, Location> {

    @Autowired
    private CityService cityService;

    @Override
    public void mapAtoB(LocationEntity locationEntity, Location location, MappingContext context) {
        Long cityId = locationEntity.getCityId();
        City city = cityService.getCityById(cityId);

        location.setId(locationEntity.getId());
        location.setAddress1(locationEntity.getAddress1());
        location.setAddress2(locationEntity.getAddress2());
        location.setCity(city);
        location.setActive(locationEntity.isActive());
        location.setUpdatedBy(locationEntity.getUpdatedBy());
        location.setUpdatedOn(locationEntity.getUpdatedOn());
    }

    @Override
    public void mapBtoA(Location location, LocationEntity locationEntity, MappingContext context) {
        locationEntity.setId(location.getId());
        locationEntity.setAddress1(location.getAddress1());
        locationEntity.setAddress2(location.getAddress2());
        locationEntity.setCityId(location.getCity().getId());
        locationEntity.setActive(location.isActive());
        locationEntity.setUpdatedBy(location.getUpdatedBy());
        locationEntity.setUpdatedOn(location.getUpdatedOn());
    }

}
