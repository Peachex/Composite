package com.epam.composite.parser;

import com.epam.composite.component.Component;

public class TextParser implements Parser {
    private Parser nextParser = new ParagraphParser();

    @Override
    public Component parse(String text) {
        Component result = nextParser.parse(text);
        return result;
    }
}
