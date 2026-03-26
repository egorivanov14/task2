package com.innowise.task.composite;

public abstract class AbstractTextComponent {
  private final TextType type;

  public AbstractTextComponent(TextType type) {
    this.type = type;
  }

  public TextType getType() {
    return type;
  }

  public abstract int getSize();

  public abstract int countSymbols();

  public abstract String toString();
}