package com.innowise.task.reader.impl;

import com.innowise.task.exception.CustomFileReaderException;
import com.innowise.task.reader.CustomFileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CustomFileReaderImpl implements CustomFileReader {
  private static final Logger logger = LogManager.getLogger(CustomFileReaderImpl.class);

  @Override
  public String read(Path path) throws CustomFileReaderException {
    logger.info("Reading exercise text from file.");
    String content;
    try{
      content = Files.readString(path);
    } catch (IOException e) {
      logger.error("Failed to read file.");
      throw new CustomFileReaderException("Failed to read file.", e);
    }
    return content;
  }
}