package com.mina.mapper;

import ma.glasnost.orika.Mapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by menai on 2017-03-22.
 */
@Component
public class OrikaBeanMapper extends ConfigurableMapper {

    private MapperFactory mapperFactory;

    @Autowired
    public void setOrikaBeanMapper(List<Mapper<?, ?>> mappers) {
        mappers.stream().forEach(mapper -> mapperFactory.registerMapper(mapper));
    }

    @Override
    protected void configure(MapperFactory factory) {
        super.configure(factory);
        this.mapperFactory = factory;
    }


}
