package com.mina.common;

import org.apache.commons.lang3.StringUtils;
import org.flywaydb.core.api.migration.spring.SpringJdbcMigration;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * Created by menai on 2017-03-27.
 */
public class V1_21__UserData implements SpringJdbcMigration {

    private static final String INSET_SQL = "INSERT INTO user (login, password, email, firstName, lastName, phone, roles, location_id, isActive, updatedBy, updatedOn) VALUES ";

    @Override
    public void migrate(JdbcTemplate jdbcTemplate) throws Exception {
        List roles = Arrays.asList("ROLE_ADMIN", "ROLE_USR");

        String user1 = "('root', 'root', 'root@mina.com', 'first', 'last', '514-987-5646', '" + StringUtils.join(roles, ',') + "', 1, true, 1, now())";
        String user2 = "('admin', 'pwd', 'adminot@mina.com', 'first', 'last', '514-987-6666', '" + StringUtils.join(roles, ',') + "', 1, true, 1, now())";

        List users = Arrays.asList(user1, user2);

        jdbcTemplate.execute(INSET_SQL + StringUtils.join(users, ','));
    }

}
