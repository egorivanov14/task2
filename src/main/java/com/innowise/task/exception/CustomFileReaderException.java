package com.innowise.task.exception;

public class CustomFileReaderException extends Exception{
  public CustomFileReaderException(String message){
    super(message);
  }

  public CustomFileReaderException(String message, Throwable cause){
    super(message, cause);
  }
}
