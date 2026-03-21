package com.innowise.task.service.impl;

import com.innowise.task.entity.AbstractTextComponent;
import com.innowise.task.entity.TextType;
import com.innowise.task.entity.impl.TextRoot;
import com.innowise.task.service.TextService;

import java.util.List;

public class TextServiceImpl implements TextService {
  @Override
  public void replaceLexemesInSentences(List<AbstractTextComponent> components) {
    for (AbstractTextComponent component : components) {
      TextType type = component.getType();
      if (type.equals(TextType.SENTENCE)) {
        int size = ((TextRoot) component).getSize();
        if (size > 1) {
          AbstractTextComponent firstLexeme = getLexeme((TextRoot) component, 0);
          AbstractTextComponent lastLexeme = getLexeme((TextRoot) component, size - 1);
          ((TextRoot) component).setComponent(firstLexeme, size - 1);
          ((TextRoot) component).setComponent(lastLexeme, 0);
        }
      } else if (!(type.equals(TextType.WORD)
              || type.equals(TextType.SYMBOL)
              || type.equals(TextType.LETTER))) {
        replaceLexemesInSentences(((TextRoot) component).getComponents());
      }
    }
  }

  private AbstractTextComponent getLexeme(TextRoot sentence, int index) {
    List<AbstractTextComponent> lexemes = sentence.getComponents();
    return lexemes.get(index);
  }
}