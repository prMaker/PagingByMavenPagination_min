package com.kaishengit.util;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 2016/6/18.
 */
public class ConnectionManager {
    private static Logger logger = LoggerFactory.getLogger(ConnectionManager.class);

    private static BasicDataSource dataSource = new BasicDataSource();
    static{
        dataSource.setDriverClassName(Config.getProperty("jdbc.driver"));
        dataSource.setUrl(Config.getProperty("jdbc.url"));
        dataSource.setUsername(Config.getProperty("jdbc.username"));
        dataSource.setPassword(Config.getProperty("jdbc.password"));

        dataSource.setInitialSize(Integer.parseInt(Config.getProperty("jdbc.initsize","5")));
        dataSource.setMaxTotal(Integer.parseInt(Config.getProperty("jdbc.maxsize","20")));
        dataSource.setMinIdle(Integer.parseInt(Config.getProperty("jdbc.minidle","5")));
        dataSource.setMaxIdle(Integer.parseInt(Config.getProperty("jdbc.maxidle","10")));
        dataSource.setMaxWaitMillis(Integer.parseInt(Config.getProperty("jdbc.maxwait","5000")));

        logger.debug(Config.getProperty("jdbc.url")+":"+Config.getProperty("jdbc.username"));
    }

    public static BasicDataSource getDataSource() {
        return dataSource;
    }
}
