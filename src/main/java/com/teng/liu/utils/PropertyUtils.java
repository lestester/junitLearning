package com.teng.liu.utils;

import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class PropertyUtils {

    private static Map<String, String> propertiesMap = Maps.newHashMap();
    private static Logger logger = LoggerFactory.getLogger(PropertyUtils.class);

    static {
        initMap();
    }

    private static void initMap() {

        Properties properties = new Properties();
        InputStream inputStream = PropertyUtils.class.getClassLoader().getResourceAsStream("config.properties");

        try {
            properties.load(inputStream);
        } catch (IOException e) {
            logger.error("load config.properties error", e);
        }

        Set<Map.Entry<Object, Object>> entries = properties.entrySet();
        for (Map.Entry<Object, Object> entry : entries) {
            String key = entry.getKey().toString().trim();
            String value = entry.getValue().toString().trim();
            propertiesMap.put(key, value);
        }
    }

    public static String getValue(String key) {
        return propertiesMap.get(key);
    }

    public static String getValue(String key ,String defaultValue){
        String strValue = propertiesMap.get(key);
        if(StringUtils.isBlank(strValue)){
            return defaultValue;
        } else {
            return strValue;
        }
    }

    public static String replaceConfigVariable(String origin){
        if(StringUtils.isBlank(origin)){
            return origin;
        }
        for(Map.Entry<String,String> entry : propertiesMap.entrySet()){
            origin = StringUtils.replace(origin,"$" +entry.getKey().trim() ,entry.getValue());
            origin = StringUtils.replace(origin,"${" +entry.getKey().trim() +"}" ,entry.getValue());
        }
        return origin;
    }

}
