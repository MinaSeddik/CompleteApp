package com.mina.service;

import com.mina.model.User;

/**
 * Created by menai on 2017-03-21.
 */
public interface UserService {

    User getUserByUsername(String login);
}
