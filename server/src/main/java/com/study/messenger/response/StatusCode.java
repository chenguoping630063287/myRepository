package com.study.messenger.response;

/**
 * Author：chenguoping
 * Date  : 2021/3/27 13:02
 * Desc  : 类的作用是什么......
 **/
public enum StatusCode {
    SECCESS("10000","成功"),
    FAIL("10001","失败"),
    UNKNOW("10002","未知");

    StatusCode() {
    }

    StatusCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private String code;
    private String msg;

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
}
