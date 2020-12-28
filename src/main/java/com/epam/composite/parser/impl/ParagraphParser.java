package com.epam.composite.parser.impl;

import com.epam.composite.model.component.Component;
import com.epam.composite.model.component.Level;
import com.epam.composite.model.component.impl.Composite;
import com.epam.composite.parser.Parser;

import java.util.ArrayList;
import java.util.List;

public class ParagraphParser implements Parser {
    private Parser nextParser = new SentenceParser();

    @Override
    public Component parse(String text) {
        Component result = new Composite(Level.TEXT);
        List<String> paragraphs = parseText(text);
        for (String paragraph : paragraphs) {
            Component sentence = nextParser.parse(paragraph);
            result.add(sentence);
        }
        return result;
    }

    private List<String> parseText(String text) {
        List<String> paragraphs = new ArrayList<>();
        // parse paragraphs
        return paragraphs;
    }
}
