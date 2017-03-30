package com.mina.repository.mapper;

import com.mina.domain.UserEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by menai on 2017-03-21.
 */
public class UserRowMapper implements RowMapper<UserEntity> {

    @Override
    public UserEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        UserEntity user = new UserEntity();
        user.setId(rs.getLong("id"));
        user.setLogin(rs.getString("login"));
        user.setPassword(rs.getString("password"));
        user.setEmail(rs.getString("email"));
        user.setFirstName(rs.getString("firstName"));
        user.setLastName(rs.getString("lastName"));
        user.setPhone(rs.getString("phone"));
        user.setRoles(rs.getString("roles"));
        user.setLocationId(rs.getLong("location_id"));
        user.setActive(rs.getBoolean("isActive"));
        user.setUpdatedBy(rs.getLong("updatedBy"));
        user.setUpdatedOn(rs.getDate("updatedOn"));

        return user;
    }

}
