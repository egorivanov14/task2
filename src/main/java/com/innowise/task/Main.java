package com.innowise.task;

import com.innowise.task.entity.TextType;
import com.innowise.task.entity.impl.TextRoot;
import com.innowise.task.exception.CustomFileReaderException;
import com.innowise.task.parser.ParagraphParser;
import com.innowise.task.reader.CustomFileReader;
import com.innowise.task.reader.impl.CustomFileReaderImpl;
import com.innowise.task.writer.CustomFileWriter;
import com.innowise.task.writer.impl.CustomFileWriterImpl;

import java.io.IOException;
import java.nio.file.Path;

public class Main {
  public static void main(String[] args) throws CustomFileReaderException, IOException {
    Path inputPath = Path.of("data/input.txt");

    CustomFileReader reader = new CustomFileReaderImpl();
    String inputText = reader.read(inputPath);
    System.out.println(inputText);

    TextRoot textRoot = new TextRoot(TextType.TEXT);
    ParagraphParser parser = new ParagraphParser();
    parser.parse(inputText, textRoot);

    String outputText = textRoot.toString();
    CustomFileWriter writer = new CustomFileWriterImpl();

    writer.write(outputText);

    int symbolsCount = textRoot.countSymbols();
    System.out.println(symbolsCount);
  }
}