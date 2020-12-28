package com.epam.composite.parser.impl;

import com.epam.composite.model.component.Component;
import com.epam.composite.model.component.Layer;
import com.epam.composite.model.component.impl.CharacterLeaf;
import com.epam.composite.model.component.impl.Composite;
import com.epam.composite.parser.Parser;

import java.util.ArrayList;
import java.util.List;

public class CharacterParser implements Parser {
    @Override
    public Component parse(String text) {
        Component result = new Composite(Layer.WORD);
        List<String> characters = parseText(text);
        for (String character : characters) {
            Component ch = new CharacterLeaf(character.charAt(0));
            result.add(ch);
        }
        return result;
    }

    private List<String> parseText(String text) {
        List<String> characters = new ArrayList<>();
        // parse characters
        return characters;
    }
}
