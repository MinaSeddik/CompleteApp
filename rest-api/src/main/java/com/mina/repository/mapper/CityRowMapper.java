package com.mina.repository.mapper;

import com.mina.domain.CityEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by menai on 2017-03-22.
 */
public class CityRowMapper implements RowMapper<CityEntity> {

    @Override
    public CityEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        CityEntity cityEntity = new CityEntity();
        cityEntity.setId(rs.getLong("id"));
        cityEntity.setName(rs.getString("name"));
        cityEntity.setCountryId(rs.getLong("country_id"));
        cityEntity.setActive(rs.getBoolean("isActive"));
        cityEntity.setUpdatedBy(rs.getLong("updatedBy"));
        cityEntity.setUpdatedOn(rs.getDate("updatedOn"));

        return cityEntity;
    }

}
