package com.moneyware.application.message;

public class MWResponseMessage {
  private String message;

  public MWResponseMessage(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

}
