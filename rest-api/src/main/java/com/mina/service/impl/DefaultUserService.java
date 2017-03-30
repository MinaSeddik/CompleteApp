package com.mina.service.impl;

import com.mina.domain.UserEntity;
import com.mina.mapper.OrikaBeanMapper;
import com.mina.model.User;
import com.mina.repository.UserRepository;
import com.mina.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by menai on 2017-03-21.
 */
@Service
public class DefaultUserService implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(DefaultUserService.class);

    @Autowired
    private UserRepository userRepository;

    private OrikaBeanMapper orikaMapper;

    @Autowired
    public void setOrikaMapper(OrikaBeanMapper orikaMapper) {
        this.orikaMapper = orikaMapper;
    }

    @Override
    public User getUserByUsername(String login) {
        UserEntity userEntity = userRepository.findUserByUsername(login);

        return orikaMapper.map(userEntity, User.class);
    }


}
