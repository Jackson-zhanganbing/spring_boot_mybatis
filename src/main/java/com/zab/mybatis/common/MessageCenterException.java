package com.zab.mybatis.common;

public class MessageCenterException extends RuntimeException {

    public MessageCenterException(Msg msg, Exception exception){
        this.msg = msg;
        this.exception = exception;
    }

    private Exception exception;
    private Msg msg;

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    public Msg getMsg() {
        return msg;
    }

    public void setMsg(Msg msg) {
        this.msg = msg;
    }
}
