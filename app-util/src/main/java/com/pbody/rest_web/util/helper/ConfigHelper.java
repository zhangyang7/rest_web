package com.pbody.rest_web.util.helper;

import org.apache.commons.lang.math.NumberUtils;

import java.util.Properties;

/**
 * @author Pbody
 * @create 2017-12-07 16:04
 * @description： ConfigHelper.java
 */
public class ConfigHelper {

    private static final ConfigHelper instance         = new ConfigHelper();

    private final Properties          configProperties = FileUtil.loadPropFile("config.properties");

    private ConfigHelper() {
    }

    public static ConfigHelper getInstance() {
        return instance;
    }
    
    public Properties getConfigProerties(){
        return configProperties;
    }

    public String getStringProperty(String key) {
        String value = "";
        if (configProperties.containsKey(key)) {
            value = configProperties.getProperty(key);
        }
        return value;
    }

    public int getNumberProperty(String key) {
        int value = 0;
        String sValue = getStringProperty(key);
        if (NumberUtils.isNumber(sValue)) {
            value = Integer.parseInt(sValue);
        }
        return value;
    }
}
