package com.innowise.task.parser;

import com.innowise.task.entity.TextType;
import com.innowise.task.entity.impl.TextRoot;

public class SentenceParser extends AbstractTextParser {

  public SentenceParser() {
    super.setNextParser(new LexemeParser());
  }

  @Override
  public void parse(String content, TextRoot parent){
    String[] sentences = content.split(SENTENCE_DELIMITER);

    for (String sentence : sentences) {
      TextRoot sentenceRoot = new TextRoot(TextType.SENTENCE);
      parent.addComponent(sentenceRoot);
      AbstractTextParser nextParser = getNextParser();
      nextParser.parse(sentence, sentenceRoot);
    }
  }
}