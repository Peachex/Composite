package com.epam.composite.parser;

import com.epam.composite.component.TextComponent;

public interface Parser {
    TextComponent parse(String text);
}
