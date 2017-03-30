package com.mina.repository.mapper;

import com.mina.domain.LocationEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by menai on 2017-03-21.
 */
public class LocationRowMapper implements RowMapper<LocationEntity> {

    @Override
    public LocationEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        LocationEntity locationEntity = new LocationEntity();
        locationEntity.setId(rs.getLong("id"));
        locationEntity.setAddress1(rs.getString("address1"));
        locationEntity.setAddress2(rs.getString("address2"));
        locationEntity.setCityId(rs.getLong("city_id"));
        locationEntity.setActive(rs.getBoolean("isActive"));
        locationEntity.setUpdatedBy(rs.getLong("updatedBy"));
        locationEntity.setUpdatedOn(rs.getDate("updatedOn"));

        return locationEntity;
    }

}