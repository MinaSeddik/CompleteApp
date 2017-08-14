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
        String city2 = "('Ottawa', 1, true, 1, now())";
        String city3 = "('Vancouver', 1, true, 1, now())";
        String city4 = "('Toronto', 1, true, 1, now())";
        String city5 = "('Calgary', 1, true, 1, now())";
        String city6 = "('Victoria', 1, true, 1, now())";
        String city7 = "('Winnipeg', 1, true, 1, now())";
        String city8 = "('Quebec City', 1, true, 1, now())";
        String city9 = "('Halifax', 1, true, 1, now())";


        String city10 = "('Cairo', 2, true, 1, now())";
        String city11 = "('Alex', 2, true, 1, now())";
        String city12 = "('Marsa Matrouh', 2, true, 1, now())";
        String city13 = "('Sharm EL-shekh', 2, true, 1, now())";
        String city14 = "('Sainai', 2, true, 1, now())";
        String city15 = "('Giza', 2, true, 1, now())";

        List cities = Arrays.asList(city1, city2, city3, city4, city5,
                city6, city7, city8, city9, city10,
                city11, city12, city13, city14, city15);

        jdbcTemplate.execute(INSET_SQL + StringUtils.join(cities, ','));
    }

}
