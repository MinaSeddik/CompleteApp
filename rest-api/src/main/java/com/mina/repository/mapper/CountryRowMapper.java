package com.mina.repository.mapper;

import com.mina.domain.CountryEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by menai on 2017-03-22.
 */
public class CountryRowMapper implements RowMapper<CountryEntity> {

    @Override
    public CountryEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        CountryEntity countryEntity = new CountryEntity();
        countryEntity.setId(rs.getLong("id"));
        countryEntity.setName(rs.getString("name"));
        countryEntity.setActive(rs.getBoolean("isActive"));
        countryEntity.setUpdatedBy(rs.getLong("updatedBy"));
        countryEntity.setUpdatedOn(rs.getDate("updatedOn"));

        return countryEntity;
    }

}