package com.economysa.motor.error;

/**
 * @author QuickDev
 * @version 1.0
 */
public class ValidationError {

  private String code;
  private String message;

  public ValidationError() {}

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
}
