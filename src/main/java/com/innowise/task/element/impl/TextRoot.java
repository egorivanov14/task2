package com.innowise.task.element.impl;

import com.innowise.task.element.AbstractTextUnit;
import com.innowise.task.element.TextType;

import java.util.ArrayList;
import java.util.List;

public class TextRoot extends AbstractTextUnit {
  private final List<AbstractTextUnit> units = new ArrayList<>();

  public TextRoot(TextType type) {
    super(type);
  }

  public void addElement(AbstractTextUnit element) {
    units.add(element);
  }

  public List<AbstractTextUnit> getUnits(){
    return units;
  }

  @Override
  public String buildText() {
    StringBuilder content = new StringBuilder();
    for (AbstractTextUnit element : units) {
      TextType elementType = element.getType();
      if (elementType.equals(TextType.PARAGRAPH)) {
        content.append("\n\t");
      }
      content.append(element.buildText());
    }
    return content.toString();
  }
}