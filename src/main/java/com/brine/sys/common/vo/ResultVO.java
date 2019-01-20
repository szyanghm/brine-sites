package com.brine.sys.common.vo;

public class ResultVO<Object> {

    private Integer code=200;
    private String msg;
    private Object date;

    public ResultVO() {

    }

    public void setCode(Integer code) {
        this.code = code;
    }
    public int getCode() {
        return code;
    }
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getDate() {
        return date;
    }

    public void setDate(Object date) {
        this.date = date;
    }

    public ResultVO(Integer code, String msg, Object date) {
        this.code = code;
        this.msg = msg;
        this.date = date;
    }
}
