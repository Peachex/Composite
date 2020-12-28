package com.epam.composite.parser.impl;

import com.epam.composite.model.component.Component;
import com.epam.composite.model.component.Level;
import com.epam.composite.model.component.impl.Composite;
import com.epam.composite.parser.Parser;

import java.util.ArrayList;
import java.util.List;

public class SentenceParser implements Parser {
    private Parser nextParser = new WordParser();

    @Override
    public Component parse(String text) {
        Component result = new Composite(Level.PARAGRAPH);
        List<String> sentences = parseText(text);
        for (String sentence : sentences) {
            Component word = nextParser.parse(sentence);
            result.add(word);
        }
        return result;
    }

    private List<String> parseText(String text) {
        List<String> sentences = new ArrayList<>();
        // parse sentences
        return sentences;
    }
}
