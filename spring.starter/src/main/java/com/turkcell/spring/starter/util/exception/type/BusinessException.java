package com.turkcell.spring.starter.util.exception.type;

public class BusinessException extends RuntimeException {
  private String errorMessage;
    public BusinessException(String message) {
      super(message);
    }

  public String getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }
}
