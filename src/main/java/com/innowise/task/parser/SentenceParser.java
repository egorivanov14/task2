package com.innowise.task.parser;

import com.innowise.task.entity.TextType;
import com.innowise.task.entity.impl.TextRoot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SentenceParser extends AbstractTextParser {
  private static final Logger logger = LogManager.getLogger(SentenceParser.class);

  public SentenceParser() {
    super.setNextSuccessor(new LexemeParser());
  }

  @Override
  public void parse(String content, TextRoot parent){
    logger.info("Parsing paragraph to sentences.");
    String[] sentences = content.split(SENTENCE_DELIMITER);

    for (String sentence : sentences) {
      TextRoot sentenceRoot = new TextRoot(TextType.SENTENCE);
      parent.addComponent(sentenceRoot);
      AbstractTextParser nextSuccessor = getNextSuccessor();
      nextSuccessor.parse(sentence, sentenceRoot);
    }
  }
}