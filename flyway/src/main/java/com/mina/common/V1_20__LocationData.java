package com.mina.common;

import org.apache.commons.lang3.StringUtils;
import org.flywaydb.core.api.migration.spring.SpringJdbcMigration;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * Created by menai on 2017-03-27.
 */
public class V1_20__LocationData implements SpringJdbcMigration {

    private static final String INSET_SQL = "INSERT INTO location (address1, address2, city_id, isActive, updatedBy, updatedOn) VALUES ";

    @Override
    public void migrate(JdbcTemplate jdbcTemplate) throws Exception {

        String location1 = "('Duke', 'Mcgill', 1, true, 1, now())";
        String location2 = "('Willington', 'Ottwa', 1, true, 1, now())";

        List locations = Arrays.asList(location1, location2);

        jdbcTemplate.execute(INSET_SQL + StringUtils.join(locations, ','));
    }

}
