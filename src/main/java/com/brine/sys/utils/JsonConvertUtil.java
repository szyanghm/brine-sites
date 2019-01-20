package com.brine.sys.utils;

import com.alibaba.fastjson.JSONObject;

/**
 * @author: Administrator
 * @date: 2019/1/15 0015 下午 5:40
 */
public class JsonConvertUtil {

    /**
     * JSON 转 Object
     */
    public static <T> T jsonToObject(String pojo, Class<T> clazz) {
        return JSONObject.parseObject(pojo, clazz);
    }

    /**
     * Object 转 JSON
     */
    public static <T> String objectToJson(T t){
        return JSONObject.toJSONString(t);
    }
}
