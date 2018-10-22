package com.zab.mybatis.common;

public class MessageCenterException extends RuntimeException {

    public MessageCenterException(GeneralResponse generalResponse, Exception exception){
        this.generalResponse = generalResponse;
        this.exception = exception;
    }

    private Exception exception;
    private GeneralResponse generalResponse;

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    public GeneralResponse getGeneralResponse() {
        return generalResponse;
    }

    public void setGeneralResponse(GeneralResponse generalResponse) {
        this.generalResponse = generalResponse;
    }
}
