package com.innowise.task.service;

import com.innowise.task.entity.AbstractTextComponent;
import com.innowise.task.entity.impl.TextRoot;

public interface TextService {
  void replaceLexemesInSentences(TextRoot root);

  AbstractTextComponent sortByLexemesLength(TextRoot root);
}