package com.innowise.task.reader;

import com.innowise.task.exception.CustomFileReaderException;

import java.nio.file.Path;

public interface CustomFileReader {
  public String read(Path path) throws CustomFileReaderException;
}
