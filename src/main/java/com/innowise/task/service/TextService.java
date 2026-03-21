package com.innowise.task.service;

import com.innowise.task.entity.AbstractTextComponent;

import java.util.List;

public interface TextService {
  void replaceLexemesInSentences(List<AbstractTextComponent> components);
}
