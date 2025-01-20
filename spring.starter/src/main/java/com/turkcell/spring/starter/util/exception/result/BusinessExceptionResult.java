package com.turkcell.spring.starter.util.exception.result;

public class BusinessExceptionResult extends ExceptionResult {
    private String errorMessage;

    public BusinessExceptionResult(String errorMessage) {
        super("BusinessException");
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
