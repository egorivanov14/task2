package com.innowise.task.parser;

import com.innowise.task.element.impl.TextRoot;
import com.innowise.task.exception.CustomTextParserException;

public abstract class AbstractTextParser {
  private AbstractTextParser nextParser;

  public void setNextParser(AbstractTextParser nextParser) {
    this.nextParser = nextParser;
  }

  public AbstractTextParser getNextParser() {
    return nextParser;
  }

  public abstract void parse(String content, TextRoot parent) throws CustomTextParserException;
}