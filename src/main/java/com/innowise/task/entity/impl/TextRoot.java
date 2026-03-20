package com.innowise.task.entity.impl;

import com.innowise.task.entity.AbstractTextComponent;
import com.innowise.task.entity.TextType;

import java.util.ArrayList;
import java.util.List;

import static com.innowise.task.entity.TextType.*;

public class TextRoot extends AbstractTextComponent {

  private final List<AbstractTextComponent> components = new ArrayList<>();

  public TextRoot(TextType type) {
    super(type);
  }

  @Override
  public int countSymbols() {
    int counter = 0;
    for (AbstractTextComponent component : components) {
      counter += component.countSymbols();
    }
    return counter;
  }

  public void addComponent(AbstractTextComponent component) {
    components.add(component);
  }

  public List<AbstractTextComponent> getComponents() {
    return components;
  }

  @Override
  public String toString() {
    StringBuilder content = new StringBuilder();
    for (AbstractTextComponent component : components) {
      TextType type = component.getType();
      switch (type) {
        case PARAGRAPH -> {
          content.append(TABULATION);
          content.append(component.toString());
          content.append(NEW_LINE);
        }
        case LEXEME -> {
          content.append(component.toString());
          content.append(SPACE_SYMBOL);
        }
      }
    }
    return content.toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o != null) {
      if (o.getClass().equals(this.getClass())) {
        TextRoot objectRoot = (TextRoot) o;
        return components.equals(objectRoot.components);
      }
    }
    return false;
  }

  @Override
  public int hashCode() {
    TextType type = getType();
    int hashCode = (type != null) ? type.hashCode() : 0;
    return 31 * hashCode + components.hashCode();
  }
}