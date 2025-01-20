package com.turkcell.spring.starter.util.exception.result;

public class ExceptionResult {
    private String type;

    public ExceptionResult() {
    }

    public ExceptionResult(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}