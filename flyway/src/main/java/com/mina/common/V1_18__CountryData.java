package com.mina.common;

import org.apache.commons.lang3.StringUtils;
import org.flywaydb.core.api.migration.spring.SpringJdbcMigration;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Arrays;
import java.util.List;


/**
 * Created by menai on 2017-03-27.
 */
public class V1_18__CountryData implements SpringJdbcMigration {

    private static final String INSET_SQL = "INSERT INTO country (name, isActive, updatedBy, updatedOn) VALUES ";

    @Override
    public void migrate(JdbcTemplate jdbcTemplate) throws Exception {
        String country1 = "('Canada', true, 1, now())";
        String country2 = "('Egypt', true, 1, now())";

        List countries = Arrays.asList(country1, country2);

        String sql = INSET_SQL + StringUtils.join(countries, ',');
        jdbcTemplate.execute(sql);
    }

}