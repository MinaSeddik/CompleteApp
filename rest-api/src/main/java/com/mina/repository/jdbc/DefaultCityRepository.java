package com.mina.repository.jdbc;

import com.mina.domain.CityEntity;
import com.mina.mapper.OrikaBeanMapper;
import com.mina.repository.CityRepository;
import com.mina.repository.cache.QueryController;
import com.mina.repository.mapper.CityRowMapper;
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
public class DefaultCityRepository extends QueryController implements CityRepository {

    private static final Logger logger = LoggerFactory.getLogger(DefaultCityRepository.class);

    private static final String SELECT_CITY_BY_ID = "SELECT * FROM city WHERE id = :id";

    private static final String SELECT_ALL_CITIES= "SELECT * FROM city";

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public DefaultCityRepository(DataSource dataSource) {
        super(dataSource);
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public CityEntity findCityById(Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);

        List<CityEntity> locationEntityList = jdbcTemplate.query(SELECT_CITY_BY_ID, parameterSource,
                new CityRowMapper());

        logger.debug("CityEntity Id: {}, there is {} elements", id, locationEntityList.size());

        return locationEntityList.get(0);
    }

    @Override
    public List<CityEntity> getAllCities() {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();

        List<CityEntity> locationEntityList = jdbcTemplate.query(SELECT_ALL_CITIES, new CityRowMapper());

        logger.debug("CityEntity -> there are {} elements", locationEntityList.size());

        return locationEntityList;
    }

}
