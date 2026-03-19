package com.innowise.task.parser;

import com.innowise.task.element.TextType;
import com.innowise.task.element.impl.TextRoot;
import com.innowise.task.exception.CustomTextParserException;

public class SentenceParser extends AbstractTextParser {
  private static final String SENTENCE_DELIMITER = "[.!?]\\s+";

  public SentenceParser(WordParser nextParser) {
    super.setNextParser(nextParser);
  }

  @Override
  public void parse(String content, TextRoot parent) throws CustomTextParserException {
    String[] sentences = content.split(SENTENCE_DELIMITER);

    for (String sentence : sentences) {
      TextRoot sentenceRoot = new TextRoot(TextType.SENTENCE);
      parent.addElement(sentenceRoot);
      AbstractTextParser nextParser = getNextParser();
      nextParser.parse(sentence, sentenceRoot);
    }
  }
}