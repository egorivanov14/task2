package com.innowise.task.writer.impl;

import com.innowise.task.writer.CustomFileWriter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CustomFileWriterImpl implements CustomFileWriter {
  private static final Path path = Path.of("C:\\Users\\Admin\\IdeaProjects\\second-task\\data\\output.txt");

  @Override
  public void write(String content) throws IOException {
    Files.writeString(path, content);
  }
}
