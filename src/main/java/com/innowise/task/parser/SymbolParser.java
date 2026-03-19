package com.innowise.task.parser;

import com.innowise.task.element.impl.TextLeaf;
import com.innowise.task.element.impl.TextRoot;

public class SymbolParser extends AbstractTextParser {
  @Override
  public void parse(String content, TextRoot parent) {
    char[] symbols = content.toCharArray();

    for (char symbol : symbols) {
      TextLeaf symbolLeaf = new TextLeaf(symbol);
      parent.addElement(symbolLeaf);
    }
  }
}