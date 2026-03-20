package com.innowise.task.entity.impl;

import com.innowise.task.entity.AbstractTextComponent;
import com.innowise.task.entity.TextType;

public class TextLeaf extends AbstractTextComponent {
  private final Character symbol;

  public TextLeaf(Character symbol, TextType type) {
    super(type);
    this.symbol = symbol;
  }

  public Character getSymbol() {
    return symbol;
  }

  @Override
  public String toString() {
    return symbol.toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null) {
      return false;
    }

    if (o.getClass().equals(this.getClass())) {
      TextLeaf leaf = (TextLeaf) o;
      if (this.symbol.equals(leaf.symbol)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public int hashCode() {
    return symbol.hashCode() + getType().hashCode();
  }
}