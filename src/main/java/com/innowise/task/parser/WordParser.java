package com.innowise.task.parser;

import com.innowise.task.element.TextType;
import com.innowise.task.element.impl.TextRoot;
import com.innowise.task.exception.CustomTextParserException;

public class WordParser extends AbstractTextParser {
  private static final String WORD_DELIMITER = "\\s";

  public WordParser(SymbolParser nextParser) {
    super.setNextParser(nextParser);
  }

  @Override
  public void parse(String content, TextRoot parent) throws CustomTextParserException {
    String[] words = content.split(WORD_DELIMITER);

    for (String word : words) {
      TextRoot wordRoot = new TextRoot(TextType.WORD);
      parent.addElement(wordRoot);
      AbstractTextParser nextParser = getNextParser();
      nextParser.parse(word, wordRoot);
    }
  }
}