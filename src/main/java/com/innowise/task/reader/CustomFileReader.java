package com.innowise.task.reader;

import com.innowise.task.exception.CustomFileReaderException;

import java.nio.file.Path;
import java.util.List;

public interface CustomFileReader {
  public List<String> read(Path path) throws CustomFileReaderException;
}
