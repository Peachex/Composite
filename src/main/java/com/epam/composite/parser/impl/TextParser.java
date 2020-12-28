package com.epam.composite.parser.impl;

import com.epam.composite.model.component.Component;
import com.epam.composite.parser.Parser;

public class TextParser implements Parser {
    private Parser nextParser = new ParagraphParser();

    @Override
    public Component parse(String text) {
        Component result = nextParser.parse(text);
        return result;
    }
}
