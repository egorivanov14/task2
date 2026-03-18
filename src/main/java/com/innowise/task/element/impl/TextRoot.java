package com.innowise.task.element.impl;

import com.innowise.task.element.AbstractTextUnit;
import com.innowise.task.element.TextElement;
import com.innowise.task.element.TextType;

import java.util.ArrayList;
import java.util.List;

public class TextRoot extends AbstractTextUnit {
  private final List<TextElement> units = new ArrayList<>();

  public TextRoot(TextType type) {
    super(type);
  }

  public void addElement(TextElement element) {
    units.add(element);
  }

  @Override
  public String buildText() {
    StringBuilder content = new StringBuilder();
    for (TextElement element : units) {
      if (element.getType().equals(TextType.PARAGRAPH)) {
        content.append("\n\t");
      }
      content.append(element.buildText());
    }
    return content.toString();
  }
}