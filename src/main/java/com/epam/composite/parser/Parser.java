package com.epam.composite.parser;

import com.epam.composite.component.Component;

public interface Parser {
    Component parse(String text);
}
