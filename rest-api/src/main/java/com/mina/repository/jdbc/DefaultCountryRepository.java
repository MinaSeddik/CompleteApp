package com.mina.repository.jdbc;

import com.mina.domain.CountryEntity;
import com.mina.repository.CountryRepository;
import com.mina.repository.cache.QueryController;
import com.mina.repository.mapper.CountryRowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by menai on 2017-03-21.
 */
@Repository
public class DefaultCountryRepository extends QueryController implements CountryRepository {

    private static final Logger logger = LoggerFactory.getLogger(DefaultLocationRepository.class);

    private static final String SELECT_COUNTRY_BY_ID = "SELECT * FROM country WHERE id = :id";

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public DefaultCountryRepository(DataSource dataSource) {
        super(dataSource);
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public CountryEntity findCountryById(Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);

        List<CountryEntity> countryEntityList = jdbcTemplate.query(SELECT_COUNTRY_BY_ID, parameterSource,
                new CountryRowMapper());

        logger.debug("CountryEntity Id: {}, there is {} elements", id, countryEntityList.size());

        return countryEntityList.get(0);
    }

}
