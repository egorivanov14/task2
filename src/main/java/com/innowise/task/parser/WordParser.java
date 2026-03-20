package com.innowise.task.parser;

import com.innowise.task.entity.TextType;
import com.innowise.task.entity.impl.TextRoot;

public class WordParser extends AbstractTextParser {

  public WordParser() {
    super.setNextParser(new SymbolParser());
  }

  @Override
  public void parse(String content, TextRoot parent) {
    AbstractTextParser nextParser = getNextParser();
    String[] components = content.split(WORD_DELIMITER);
    for (String component : components) {
      if (WORD_PATTERN.matcher(component).matches()) {
        TextRoot wordRoot = new TextRoot(TextType.WORD);
        parent.addComponent(wordRoot);
        nextParser.parse(component, wordRoot);
      } else {
        nextParser.parse(component, parent);
      }
    }
  }
}