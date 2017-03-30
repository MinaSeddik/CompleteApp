package com.mina.mapper.converter;

import com.mina.domain.CountryEntity;
import com.mina.model.Country;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;
import org.springframework.stereotype.Component;

/**
 * Created by menai on 2017-03-22.
 */
@Component
public class CountryMapper extends CustomMapper<CountryEntity, Country> {

    @Override
    public void mapAtoB(CountryEntity countryEntity, Country country, MappingContext context) {
        country.setId(countryEntity.getId());
        country.setName(countryEntity.getName());
        country.setActive(countryEntity.isActive());
        country.setUpdatedBy(countryEntity.getUpdatedBy());
        country.setUpdatedOn(countryEntity.getUpdatedOn());
    }

    @Override
    public void mapBtoA(Country country, CountryEntity countryEntity, MappingContext context) {
        countryEntity.setId(country.getId());
        countryEntity.setName(country.getName());
        countryEntity.setActive(country.isActive());
        countryEntity.setUpdatedBy(country.getUpdatedBy());
        countryEntity.setUpdatedOn(country.getUpdatedOn());
    }

}
