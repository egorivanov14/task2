package com.innowise.task.parser;

import com.innowise.task.entity.TextType;
import com.innowise.task.entity.impl.TextLeaf;
import com.innowise.task.entity.impl.TextRoot;

public class SymbolParser extends AbstractTextParser {
  @Override
  public void parse(String content, TextRoot parent) {
    char[] symbols = content.toCharArray();

    for (char symbol : symbols) {
      TextLeaf symbolLeaf;
      if(Character.isLetter(symbol)){
        symbolLeaf = new TextLeaf(symbol, TextType.LETTER);
      }
      else{
        symbolLeaf = new TextLeaf(symbol, TextType.SYMBOL);
      }
      parent.addComponent(symbolLeaf);
    }
  }
}