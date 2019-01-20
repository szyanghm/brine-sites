package com.brine.sys.common.exception;

/**
 * @author: Administrator
 * @date: 2019/1/15 0015 下午 5:46
 */
public class CustomUnauthorizedException extends RuntimeException{

    public CustomUnauthorizedException(String msg){
        super(msg);
    }

    public CustomUnauthorizedException() {
        super();
    }
}
