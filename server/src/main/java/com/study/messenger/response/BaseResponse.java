package com.study.messenger.response;

import org.apache.poi.ss.formula.functions.T;

/**
 * Author：chenguoping
 * Date  : 2021/3/27 13:01
 * Desc  : 类的作用是什么......
 **/
public class BaseResponse<T> {

    private String code;
    private String msg;
    private T date;

    public BaseResponse() {
    }

    public BaseResponse(StatusCode statusCode) {
        this.code = statusCode.getCode();
        this.msg = statusCode.getMsg();
    }

    public BaseResponse(StatusCode statusCode, T date) {
        this.code = statusCode.getCode();
        this.msg = statusCode.getMsg();
        this.date = date;
    }

    public BaseResponse(String code, String msg, T date) {
        this.code = code;
        this.msg = msg;
        this.date = date;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getDate() {
        return date;
    }

    public void setDate(T date) {
        this.date = date;
    }
}
