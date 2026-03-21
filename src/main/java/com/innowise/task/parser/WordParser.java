package com.innowise.task.parser;

import com.innowise.task.entity.TextType;
import com.innowise.task.entity.impl.TextRoot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WordParser extends AbstractTextParser {
  private static final Logger logger = LogManager.getLogger(WordParser.class);

  public WordParser() {
    super.setNextSuccessor(new SymbolParser());
  }

  @Override
  public void parse(String content, TextRoot parent) {
    AbstractTextParser nextSuccessor = getNextSuccessor();
    String[] components = content.split(WORD_DELIMITER);

    for (String component : components) {
      if (WORD_PATTERN.matcher(component).matches()) {
        TextRoot wordRoot = new TextRoot(TextType.WORD);
        parent.addComponent(wordRoot);
        nextSuccessor.parse(component, wordRoot);
      } else {
        nextSuccessor.parse(component, parent);
      }
    }
  }
}