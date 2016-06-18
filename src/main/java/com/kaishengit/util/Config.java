package com.kaishengit.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Administrator on 2016/6/18.
 */
public class Config {

    private static Properties properties = new Properties();

    private static Logger logger = LoggerFactory.getLogger(Config.class);
    static {
        try {
            properties.load(Config.class.getClassLoader().getResourceAsStream("config.properties"));
            for (Map.Entry<Object,Object> ent : properties.entrySet()) {
                logger.debug("{}:{}",ent.getKey(),ent.getValue());
            }
        } catch (IOException e) {
            throw new RuntimeException("配置文件加载异常",e);
        }
    }

    public static String getProperty(String key){
        return properties.getProperty(key);
    }

    public static String getProperty(String key,String defaultProperty){
        return properties.getProperty(key,defaultProperty);
    }

}
