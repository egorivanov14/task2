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

  public void setComponent(AbstractTextComponent component, int index) {
    components.set(index, component);
  }

  public List<AbstractTextComponent> getComponents() {
    return new ArrayList<>(components);
  }

  @Override
  public int getSize() {
    return components.size();
  }

  @Override
  public String toString() {
    StringBuilder content = new StringBuilder();
    int componentsSize = components.size();
    for (int i = 0; i < componentsSize; i++) {
      AbstractTextComponent component = components.get(i);
      TextType type = component.getType();
      switch (type) {
        case PARAGRAPH -> {
          if (componentsSize > 1) {
            content.append(TABULATION);
          }
          content.append(component);
          if (i < componentsSize - 1) {
            content.append(NEW_LINE);
          }
        }
        case LEXEME -> {
          content.append(component);
          content.append(SPACE_SYMBOL);
        }
        default -> content.append(component);
      }
    }
    return content.toString();
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object != null) {
      if (object.getClass().equals(this.getClass())) {
        TextRoot objectRoot = (TextRoot) object;
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