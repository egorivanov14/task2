package com.innowise.task.parser;

import com.innowise.task.entity.TextType;
import com.innowise.task.entity.impl.TextRoot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ParagraphParser extends AbstractTextParser {
  private static final Logger logger = LogManager.getLogger(ParagraphParser.class);

  public ParagraphParser() {
    super.setNextSuccessor(new SentenceParser());
  }

  @Override
  public void parse(String content, TextRoot parent) {
    logger.info("Parsing text to paragraphs.");
    String[] paragraphs = content.split(PARAGRAPH_DELIMITER);

    for (String paragraph : paragraphs) {
      TextRoot paragraphRoot = new TextRoot(TextType.PARAGRAPH);
      parent.addComponent(paragraphRoot);
      AbstractTextParser nextSuccessor = getNextSuccessor();
      nextSuccessor.parse(paragraph, paragraphRoot);
      logger.debug("Text has {} paragraphs.", paragraphs.length);
    }
  }
}