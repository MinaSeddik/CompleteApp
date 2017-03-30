package com.mina.repository;

import com.mina.domain.CountryEntity;

/**
 * Created by menai on 2017-03-21.
 */
public interface CountryRepository {

    CountryEntity findCountryById(Long id);
}
