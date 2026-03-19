package com.innowise.task.parser;

import com.innowise.task.element.AbstractTextUnit;
import com.innowise.task.element.TextType;
import com.innowise.task.element.impl.TextLeaf;
import com.innowise.task.element.impl.TextRoot;
import com.innowise.task.exception.CustomTextParserException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextParserTest {

  @Test
  void shouldParseWordToSymbols() {
    String word = "Innowise";
    TextRoot parent = new TextRoot(TextType.WORD);
    SymbolParser parser = new SymbolParser();

    parser.parse(word, parent);
    List<AbstractTextUnit> expected = new ArrayList<>(){{
      add(new TextLeaf('I'));
      add(new TextLeaf('n'));
      add(new TextLeaf('n'));
      add(new TextLeaf('o'));
      add(new TextLeaf('w'));
      add(new TextLeaf('i'));
      add(new TextLeaf('s'));
      add(new TextLeaf('e'));
    }};
    List<AbstractTextUnit> actual = parent.getUnits();
    assertEquals(expected, actual);
  }
}