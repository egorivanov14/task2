package com.innowise.task.service;

import com.innowise.task.entity.AbstractTextComponent;
import com.innowise.task.entity.impl.TextRoot;

import java.util.List;

public interface TextService {
  void replaceLexemesInSentences(TextRoot root);

  List<AbstractTextComponent> sortByLexemesLength(TextRoot root);
}