package com.innowise.task.entity.impl;

import com.innowise.task.entity.AbstractTextComponent;
import com.innowise.task.entity.TextType;

import java.util.ArrayList;
import java.util.List;

public class TextRoot extends AbstractTextComponent {

  private final List<AbstractTextComponent> components = new ArrayList<>();

  public TextRoot(TextType type) {
    super(type);
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
    for (AbstractTextComponent element : components) {
      TextType type = element.getType();
      switch (type){
        case PARAGRAPH -> content.append(PARAGRAPH_BREAK);
        case LEXEME -> content.append(SPACE_SYMBOL);
      }
      content.append(element.toString());
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
    int hashCode = 0;
    for (AbstractTextComponent composite : components) {
      hashCode += composite.hashCode();
    }
    return hashCode;
  }
}