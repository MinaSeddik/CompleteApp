package com.mina.repository.cache;

import javax.sql.DataSource;

/**
 * Created by menai on 2017-03-21.
 */
public class QueryController {

    private final DataSource dataSource;

    public QueryController(DataSource dataSource) {
        this.dataSource = dataSource;
    }


}
