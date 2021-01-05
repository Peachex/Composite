package com.epam.composite.parser;

import com.epam.composite.component.Component;
import com.epam.composite.component.Layer;
import com.epam.composite.component.TextComposite;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParagraphParser implements Parser {
    private static final  String PARAGRAPH_DELIMITER = "\\n\\s{4}|\\s{4}|\\t+";
    private static final String NULL_CHARACTER = "";
    private Parser nextParser = new SentenceParser();

    @Override
    public Component parse(String text) {
        Component result = new TextComposite(Layer.TEXT);
        List<String> paragraphs = parseText(text);
        for (String paragraph : paragraphs) {
            Component sentence = nextParser.parse(paragraph);
            result.add(sentence);
        }
        return result;
    }

    private List<String> parseText(String text) {
        List<String> paragraphs = Arrays.stream(text
                .split(PARAGRAPH_DELIMITER))
                .filter(s -> !s.equals(NULL_CHARACTER))
                .collect(Collectors.toList());
        return paragraphs;
    }
}
