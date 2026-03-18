package com.innowise.task.element.impl;

import com.innowise.task.element.AbstractTextUnit;
import com.innowise.task.element.TextType;

public class TextLeaf extends AbstractTextUnit {
  private final Character symbol;

  public TextLeaf(Character symbol) {
    super(TextType.SYMBOL);
    this.symbol = symbol;
  }

  public Character getSymbol() {
    return symbol;
  }

  @Override
  public String buildText() {
    return symbol.toString();
  }
}