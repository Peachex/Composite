package com.epam.composite.parser.impl;

import com.epam.composite.model.component.Component;
import com.epam.composite.model.component.Level;
import com.epam.composite.model.component.impl.Composite;
import com.epam.composite.parser.Parser;

import java.util.ArrayList;
import java.util.List;

public class WordParser implements Parser {
    private Parser nextParser = new CharacterParser();

    @Override
    public Component parse(String text) {
        Component result = new Composite(Level.SENTENCE);
        List<String> words = parseText(text);
        for (String word : words) {
            Component character = nextParser.parse(word);
            result.add(character);
        }
        return result;
    }

    private List<String> parseText(String text) {
        List<String> words = new ArrayList<>();
        return words;
    }
}
