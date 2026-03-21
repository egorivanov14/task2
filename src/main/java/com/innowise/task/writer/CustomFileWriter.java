package com.innowise.task.writer;

import java.io.IOException;

public interface CustomFileWriter {
  void write(String content) throws IOException;
}