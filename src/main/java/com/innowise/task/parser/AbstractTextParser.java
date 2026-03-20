package com.innowise.task.parser;

import com.innowise.task.entity.impl.TextRoot;

import java.util.regex.Pattern;

public abstract class AbstractTextParser {
  protected static final String PARAGRAPH_DELIMITER = "\\n\\s*\\n";
  protected static final String SENTENCE_DELIMITER = "(?<=[.!?])\\s+";
  protected static final String LEXEMES_DELIMITER = "\\s+";
  protected static final String WORD_DELIMITER = "(?=[\\p{Punct}])|(?<=[\\p{Punct}])";
  protected static final Pattern WORD_PATTERN = Pattern.compile("\\p{L}+");

  private AbstractTextParser nextParser;

  public void setNextParser(AbstractTextParser nextParser) {
    this.nextParser = nextParser;
  }

  public AbstractTextParser getNextParser() {
    return nextParser;
  }

  public abstract void parse(String content, TextRoot parent);
}