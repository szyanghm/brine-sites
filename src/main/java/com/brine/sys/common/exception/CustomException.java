package com.brine.sys.common.exception;

/**
 * @author: Administrator
 * @date: 2019/1/15 0015 下午 5:33
 */
public class CustomException extends RuntimeException {

    public CustomException(String msg){
        super(msg);
    }

    public CustomException() {
        super();
    }

}
