package com.mina.repository.jdbc;

import com.mina.domain.UserEntity;
import com.mina.repository.UserRepository;
import com.mina.repository.cache.QueryController;
import com.mina.repository.mapper.UserRowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by menai on 2017-03-21.
 */
@Repository
public class DefaultUserRepository extends QueryController implements UserRepository {

    private static final Logger logger = LoggerFactory.getLogger(DefaultUserRepository.class);

    private static final String SELECT_USER = "SELECT * FROM user WHERE login = :login";

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public DefaultUserRepository(DataSource dataSource) {
        super(dataSource);
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public UserEntity findUserByUsername(String user) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("login", user);

        List<UserEntity> userList = null;
        try {
            userList = jdbcTemplate.query(SELECT_USER, parameterSource,
                    new UserRowMapper());
        } catch (DataAccessException ex) {
            logger.debug("DataAccessException : {}", ex.getMessage());
        } catch (Exception ex) {
            logger.debug("Exception : {}", ex.getMessage());
        }

        logger.debug("UserEntity: {}, there is {} elements", user, userList.size());

        return CollectionUtils.isEmpty(userList) ? null : userList.get(0);
    }

}
