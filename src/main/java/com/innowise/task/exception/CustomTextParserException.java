package com.innowise.task.exception;

public class CustomTextParserException extends Exception {
  public CustomTextParserException(String message) {
    super(message);
  }

  public CustomTextParserException(String message, Throwable cause) {
    super(message, cause);
  }

  public CustomTextParserException() {
    super();
  }

  public CustomTextParserException(Throwable cause) {
    super(cause);
  }
}