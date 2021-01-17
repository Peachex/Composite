package com.epam.composite.parser;

import com.epam.composite.component.TextComponent;

public class TextParser implements Parser {
    private Parser nextParser = new ParagraphParser();

    @Override
    public TextComponent parse(String text) {
        TextComponent result = nextParser.parse(text);
        return result;
    }
}
