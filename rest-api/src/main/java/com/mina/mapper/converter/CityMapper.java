package com.mina.mapper.converter;

import com.mina.domain.CityEntity;
import com.mina.model.City;
import com.mina.model.Country;
import com.mina.service.CountryService;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by menai on 2017-03-22.
 */
@Component
public class CityMapper extends CustomMapper<CityEntity, City> {

    @Autowired
    private CountryService countryService;

    @Override
    public void mapAtoB(CityEntity cityEntity, City city, MappingContext context) {
        Long countryId = cityEntity.getCountryId();
        Country country = countryService.getCountryById(countryId);

        city.setId(cityEntity.getId());
        city.setName(cityEntity.getName());
        city.setCountry(country);
        city.setActive(cityEntity.isActive());
        city.setUpdatedBy(cityEntity.getUpdatedBy());
        city.setUpdatedOn(cityEntity.getUpdatedOn());
    }

    @Override
    public void mapBtoA(City city, CityEntity cityEntity, MappingContext context) {
        cityEntity.setId(city.getId());
        cityEntity.setName(city.getName());
        cityEntity.setCountryId(city.getCountry().getId());
        cityEntity.setActive(city.isActive());
        cityEntity.setUpdatedBy(city.getUpdatedBy());
        cityEntity.setUpdatedOn(city.getUpdatedOn());
    }

}
