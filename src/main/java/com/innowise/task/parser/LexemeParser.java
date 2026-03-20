package com.innowise.task.parser;

import com.innowise.task.entity.TextType;
import com.innowise.task.entity.impl.TextRoot;

public class LexemeParser extends AbstractTextParser {

  public LexemeParser() {
    super.setNextSuccessor(new WordParser());
  }

  @Override
  public void parse(String content, TextRoot parent) {
    String[] sentenceComponents = content.split(LEXEMES_DELIMITER);

    AbstractTextParser nextSuccessor = getNextSuccessor();
    for (String component : sentenceComponents) {
      TextRoot lexemeRoot = new TextRoot(TextType.LEXEME);
      parent.addComponent(lexemeRoot);
      nextSuccessor.parse(component, lexemeRoot);
    }
  }
}