package com.epam.composite.parser;

import com.epam.composite.model.component.Component;

public interface Parser {
    Component parse(String text);
}
