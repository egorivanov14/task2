package com.innowise.task.entity;

public abstract class AbstractTextComponent {
  protected static final String PARAGRAPH_BREAK = "\n\t";
  protected static final String SPACE_SYMBOL = "\\s";

  private final TextType type;

  public AbstractTextComponent(TextType type) {
    this.type = type;
  }

  public TextType getType() {
    return type;
  }

  public abstract String toString();
}