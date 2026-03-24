package com.innowise.task.service;

import com.innowise.task.entity.AbstractTextComponent;
import com.innowise.task.entity.TextType;
import com.innowise.task.entity.impl.TextRoot;
import com.innowise.task.parser.ParagraphParser;
import com.innowise.task.service.impl.TextServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextServiceTest {
  private static TextRoot textRoot;
  private static ParagraphParser parser;
  private static TextService service;
  private final String TEXT = "This is my text. And it is the first paragraph.\n\tThis is the second paragraph. I am proud of this text.";
  private final String REPLACE_LEXEMES_TEXT = "\ttext. is my This paragraph. it is the first And \n\tparagraph. is the second This text. am proud of this I ";
  private final String SORTED_BT_SENTENCES_TEXT = "This is my text. This is the second paragraph. And it is the first paragraph. I am proud of this text. ";

  @BeforeAll
  static void setUp(){
    parser = new ParagraphParser();
    service = new TextServiceImpl();
  }

  @BeforeEach
  void setUpText(){
    textRoot = new TextRoot(TextType.TEXT);
    parser.parse(TEXT, textRoot);
  }

  @Test
  void shouldShouldReplaceLexemesInSentences(){
    String excepted = REPLACE_LEXEMES_TEXT;
    service.replaceLexemesInSentences(textRoot);
    String actual = textRoot.toString();
    assertEquals(excepted, actual);
  }

  @Test
  void shouldSortTextByLexemesLength(){
    String excepted = SORTED_BT_SENTENCES_TEXT;
    AbstractTextComponent sortedRoot = service.sortByLexemesLength(textRoot);
    String actual = sortedRoot.toString();
    assertEquals(excepted, actual);
  }
}