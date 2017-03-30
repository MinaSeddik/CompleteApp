package com.mina.util;

import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;
import java.util.ResourceBundle;

/**
 * Created by menai on 2017-03-27.
 */
public class DatasourceFactory {

    private static final String CONFIG_FILE = "flyway-" + System.getenv("ENV_MODE");

    private static ResourceBundle resourceBundle;

    static {
        try {
            resourceBundle = ResourceBundle.getBundle(CONFIG_FILE);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private static String getDriver() {
        return resourceBundle.getString("flyway.driver");
    }

    private static String getUrl() {
        return resourceBundle.getString("flyway.url");
    }

    private static String getUserName() {
        return resourceBundle.getString("flyway.user");
    }

    private static String getPassword() {
        return resourceBundle.getString("flyway.password");
    }

    public DataSource getDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(getDriver());
        dataSource.setUrl(getUrl());
        dataSource.setUsername(getUserName());
        dataSource.setPassword(getPassword());

        return dataSource;
    }

}
