package com.innowise.task.parser;

import com.innowise.task.entity.TextType;
import com.innowise.task.entity.impl.TextRoot;

public class SentenceParser extends AbstractTextParser {

  public SentenceParser() {
    super.setNextSuccessor(new LexemeParser());
  }

  @Override
  public void parse(String content, TextRoot parent){
    String[] sentences = content.split(SENTENCE_DELIMITER);

    for (String sentence : sentences) {
      TextRoot sentenceRoot = new TextRoot(TextType.SENTENCE);
      parent.addComponent(sentenceRoot);
      AbstractTextParser nextSuccessor = getNextSuccessor();
      nextSuccessor.parse(sentence, sentenceRoot);
    }
  }
}