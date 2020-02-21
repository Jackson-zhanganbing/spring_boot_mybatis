package com.zab.mybatis.common;

/**
 * @author zhang anbing
 * @date 2018/8/21
 */
public class Msg<T> {
    /**
     * 1表示正常，0表示异常
     */
    private String code;
    /**
     * 面向用户的消息
     */
    private String message;
    /**
     * 返回给前端的数据
     */
    private T data;

    public Msg(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static Msg success(String message, String detail) {
        return new Msg("1", message, null);
    }

    public static Msg fail(String message, String detail) {
        return new Msg("0", message, null);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
