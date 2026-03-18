package com.innowise.task.element;

public abstract class AbstractTextUnit implements TextElement {
  private final TextType type;

  public AbstractTextUnit(TextType type) {
    this.type = type;
  }

  @Override
  public TextType getType() {
    return type;
  }
}