package com.mina.service.impl;

import com.mina.domain.CountryEntity;
import com.mina.mapper.OrikaBeanMapper;
import com.mina.model.Country;
import com.mina.repository.CountryRepository;
import com.mina.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by menai on 2017-03-22.
 */
@Component
public class DefaultCountryService implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    private OrikaBeanMapper orikaMapper;

    @Autowired
    public void setOrikaMapper(OrikaBeanMapper orikaMapper) {
        this.orikaMapper = orikaMapper;
    }

    @Override
    public Country getCountryById(Long id) {
        CountryEntity countryEntity = countryRepository.findCountryById(id);

        return orikaMapper.map(countryEntity, Country.class);
    }

}
