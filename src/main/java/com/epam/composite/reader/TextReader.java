package com.epam.composite.reader;

import com.epam.composite.exception.ReaderException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TextReader {
    private static final Logger logger = LogManager.getLogger();
    private static final String DEFAULT_PATH = "data\\text1.txt";
    private static final String NEW_LINE_SYMBOL = "\n";
    private static final String TAB_SYMBOL = "\t";

    public String readText(String path) throws ReaderException {
        if (path == null) {
            path = DEFAULT_PATH;
            logger.log(Level.ERROR, "Path is null, default path will be used.");
        }
        Path filePath = Paths.get(path);
        try {
            if (!(Files.exists(filePath) && Files.size(filePath) > 0)) {
                filePath = Paths.get(DEFAULT_PATH);
                logger.log(Level.ERROR, "Wrong user file, default file will be used.");
            }
        } catch (IOException e) {
            logger.log(Level.ERROR, e);
        }
        List<String> lines;
        try (Stream<String> lineStream = Files.lines(filePath)) {
            lines = lineStream.collect(Collectors.toList());
        } catch (IOException e) {
            logger.log(Level.ERROR, e);
            throw new ReaderException(e.getMessage());
        }
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < lines.size(); i++) {
            text.append(TAB_SYMBOL).append(lines.get(i));
            if (i < lines.size() - 1) {
                text.append(NEW_LINE_SYMBOL);
            }
        }
        return text.toString();
    }
}
