package com.innowise.task.parser;

import com.innowise.task.element.TextType;
import com.innowise.task.element.impl.TextRoot;
import com.innowise.task.exception.CustomTextParserException;

public class ParagraphParser extends AbstractTextParser {
  private static final String PARAGRAPH_DELIMITER = "\\n\\s*";

  public ParagraphParser(SentenceParser nextParser) {
    super.setNextParser(nextParser);
  }

  @Override
  public void parse(String content, TextRoot parent) throws CustomTextParserException {
    if (content != null && parent != null) {
      String[] paragraphs = content.split(PARAGRAPH_DELIMITER);

      for (String paragraph : paragraphs) {
        TextRoot paragraphRoot = new TextRoot(TextType.PARAGRAPH);
        parent.addElement(paragraphRoot);
        AbstractTextParser nextParser = getNextParser();
        nextParser.parse(paragraph, paragraphRoot);
      }
    } else {
      throw new CustomTextParserException("One of parameters in method is null.");
    }
  }
}