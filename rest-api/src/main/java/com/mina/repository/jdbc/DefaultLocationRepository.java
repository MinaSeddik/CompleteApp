package com.mina.repository.jdbc;

import com.mina.domain.LocationEntity;
import com.mina.mapper.OrikaBeanMapper;
import com.mina.repository.LocationRepository;
import com.mina.repository.cache.QueryController;
import com.mina.repository.mapper.LocationRowMapper;
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
public class DefaultLocationRepository extends QueryController implements LocationRepository {

    private static final Logger logger = LoggerFactory.getLogger(DefaultLocationRepository.class);

    private static final String SELECT_LOCATION_BY_ID = "SELECT * FROM location WHERE id = :id";

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public DefaultLocationRepository(DataSource dataSource) {
        super(dataSource);
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public LocationEntity findLocationById(Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);

        List<LocationEntity> locationEntityList = jdbcTemplate.query(SELECT_LOCATION_BY_ID, parameterSource,
                new LocationRowMapper());

        logger.debug("LocationEntity Id: {}, there is {} elements", id, locationEntityList.size());

        return locationEntityList.get(0);
    }

}
