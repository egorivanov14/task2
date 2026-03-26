package com.innowise.task.service;

import com.innowise.task.composite.AbstractTextComponent;
import com.innowise.task.composite.TextRoot;

public interface TextService {
  void replaceLexemesInSentences(TextRoot root);

  AbstractTextComponent sortByLexemesLength(TextRoot root);
}