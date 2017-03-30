package com.mina.repository;

import com.mina.domain.UserEntity;

/**
 * Created by menai on 2017-03-21.
 */
public interface UserRepository {

    UserEntity findUserByUsername(String user);

}
