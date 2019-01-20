package com.brine.sys.utils;

import com.google.common.collect.Maps;
import org.apache.commons.lang.StringUtils;

import java.util.Map;

/**
 * @author: yanghm
 * @date: 2018/12/11 0011 下午 5:18
 */
public class GlobalUtil {

    private static Map<String,String> map = Maps.newHashMap();

    private static PropertiesLoader loader = new PropertiesLoader("system.properties");

    public static String getConfig(String key){
        String value = map.get(key);
        if(value==null){
            value = loader.getProperty(key);
            map.put(key,value!=null?value: StringUtils.EMPTY);
        }
        return value;
    }
}
