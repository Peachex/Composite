package com.epam.composite.parser;

import com.epam.composite.component.Component;
import com.epam.composite.component.Layer;
import com.epam.composite.component.TextComposite;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SentenceParser implements Parser {
    private static final String SENTENCE_DELIMITER = "(?<=[.!?…]\\s)";
    private Parser nextParser = new WordParser();

    @Override
    public Component parse(String text) {
        Component result = new TextComposite(Layer.PARAGRAPH);
        List<String> sentences = parseText(text);
        for (String sentence : sentences) {
            Component word = nextParser.parse(sentence);
            result.add(word);
        }
        return result;
    }

    private List<String> parseText(String text) {
        List<String> sentences = Arrays.stream(text
                .split(SENTENCE_DELIMITER))
                .collect(Collectors.toList());
        return sentences;
    }
}
