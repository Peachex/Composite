package com.epam.composite.parser;

import com.epam.composite.component.TextComponent;
import com.epam.composite.component.Layer;
import com.epam.composite.component.CharacterLeaf;
import com.epam.composite.component.TextComposite;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CharacterParser implements Parser {
    private static final String CHARACTER_DELIMITER = "";

    @Override
    public TextComponent parse(String text) {
        TextComponent result = new TextComposite(Layer.WORD);
        List<String> characters = parseText(text);
        for (String character : characters) {
            TextComponent symbol = new CharacterLeaf(character.charAt(0), Layer.CHARACTER);
            result.add(symbol);
        }
        return result;
    }

    private List<String> parseText(String text) {
        List<String> characters = Arrays.stream(text
                .split(CHARACTER_DELIMITER))
                .filter(s -> !s.equals(CHARACTER_DELIMITER))
                .collect(Collectors.toList());
        return characters;
    }
}
