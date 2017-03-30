package com.mina.mapper.converter;

import com.mina.domain.UserEntity;
import com.mina.model.Location;
import com.mina.model.User;
import com.mina.service.LocationService;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by menai on 2017-03-22.
 */
@Component
public class UserMapper extends CustomMapper<UserEntity, User> {

    @Autowired
    private LocationService locationService;

    @Override
    public void mapAtoB(UserEntity userEntity, User user, MappingContext context) {
        Long locationId = userEntity.getLocationId();
        Location location = locationService.getLocationById(locationId);

        user.setId(userEntity.getId());
        user.setUsername(userEntity.getLogin());
        user.setPassword(userEntity.getPassword());
        user.setEmail(userEntity.getEmail());
        user.setFirstName(userEntity.getFirstName());
        user.setLastName(userEntity.getLastName());
        user.setPhone(userEntity.getPhone());
        user.setRoles(Arrays.asList(userEntity.getRoles().split(",")));
        user.setLocation(location);
        user.setActive(userEntity.isActive());
        user.setUpdatedBy(userEntity.getUpdatedBy());
        user.setUpdatedOn(userEntity.getUpdatedOn());
    }

    @Override
    public void mapBtoA(User user, UserEntity userEntity, MappingContext context) {
        userEntity.setId(user.getId());
        userEntity.setLogin(user.getUsername());
        userEntity.setPassword(user.getPassword());
        userEntity.setEmail(user.getEmail());
        userEntity.setFirstName(user.getFirstName());
        userEntity.setLastName(user.getLastName());
        userEntity.setPhone(user.getPhone());
        userEntity.setRoles(StringUtils.join(user.getRoles(), ","));
        userEntity.setLocationId(user.getLocation().getId());
        userEntity.setActive(user.isActive());
        userEntity.setUpdatedBy(user.getUpdatedBy());
        userEntity.setUpdatedOn(user.getUpdatedOn());
    }

}
