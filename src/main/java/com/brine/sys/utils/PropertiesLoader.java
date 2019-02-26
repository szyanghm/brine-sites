package com.brine.sys.utils;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;
import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Properties;

/**
 * Properties文件载入工具类
 * @author yanghm
 */
public class PropertiesLoader {

    private static Logger logger = LoggerFactory.getLogger(PropertiesLoader.class);

    private static ResourceLoader resourceLoader = new DefaultResourceLoader();

    private final Properties properties;

    public PropertiesLoader(String... resourcesPaths){
        properties = loadProperties(resourcesPaths);
    }


    public Properties getProperties(){
        return properties;
    }

    /**
     * 取出String类型的Property,但以System的Property优先，取不到返回空字符串。
     * @param key
     * @return
     */
    private String getValue(String key){
        String systemProperty = System.getProperty(key);
        if(StringUtils.isNotBlank(systemProperty)){
            return systemProperty;
        }
        if(properties.containsKey(key)){
            return properties.getProperty(key);
        }
        return "";
    }

    /**
     * 取出String类型的Property,但以System的Property优先，如果都为Null则抛异常。
     * @param key
     * @return
     */
    public String getProperty(String key){
        String value = getValue(key);
        if(value==null){
            throw new NoSuchElementException();
        }
        return value;
    }


    /**
     * 载入多个文件，文件路径使用Spring Resource格式
     * @param resourcesPaths
     * @return
     */
    private Properties loadProperties(String... resourcesPaths){
        Properties props = new Properties();
        for(String location : resourcesPaths){
            InputStream is = null;
            try{
                Resource resource = resourceLoader.getResource(location);
                is = resource.getInputStream();
                props.load(is);
            }catch (IOException ex){
                logger.info("Could not load properties from path"+location+","+ex.getMessage());
            }finally {
                IOUtils.closeQuietly(is);
            }
        }
        return props;
    }

}
