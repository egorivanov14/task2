package com.innowise.task.parser;

import com.innowise.task.composite.TextType;
import com.innowise.task.composite.TextLeaf;
import com.innowise.task.composite.TextRoot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SymbolParser extends AbstractTextParser {
  private static final Logger logger = LogManager.getLogger(SymbolParser.class);

  @Override
  public void setNextSuccessor(AbstractTextParser nextSuccessor) {
  }

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