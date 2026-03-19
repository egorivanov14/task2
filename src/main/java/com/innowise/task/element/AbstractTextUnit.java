package com.innowise.task.element;

public abstract class AbstractTextUnit{
  private final TextType type;

  public AbstractTextUnit(TextType type) {
    this.type = type;
  }

  public TextType getType() {
    return type;
  }

  public abstract String buildText();
}