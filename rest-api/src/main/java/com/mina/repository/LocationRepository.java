package com.mina.repository;

import com.mina.domain.LocationEntity;

/**
 * Created by menai on 2017-03-21.
 */
public interface LocationRepository {

    LocationEntity findLocationById(Long id);

}
