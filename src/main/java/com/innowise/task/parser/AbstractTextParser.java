package com.innowise.task.parser;

public abstract class AbstractTextParser {
  protected AbstractTextParser nextParser;

  public AbstractTextParser(AbstractTextParser nextParser) {
    this.nextParser = nextParser;
  }

  public abstract void parse(String content);
}