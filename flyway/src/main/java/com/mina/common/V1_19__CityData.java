package com.mina.common;

import org.apache.commons.lang3.StringUtils;
import org.flywaydb.core.api.migration.spring.SpringJdbcMigration;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * Created by menai on 2017-03-27.
 */
public class V1_19__CityData implements SpringJdbcMigration {

    private static final String INSET_SQL = "INSERT INTO city (name, country_id, isActive, updatedBy, updatedOn) VALUES ";

    @Override
    public void migrate(JdbcTemplate jdbcTemplate) throws Exception {

        String city1 = "('Montreal', 1, true, 1, now())";
        String city2 = "('Ottwa', 1, true, 1, now())";

        List cities = Arrays.asList(city1, city2);

        jdbcTemplate.execute(INSET_SQL + StringUtils.join(cities, ','));
    }

}
