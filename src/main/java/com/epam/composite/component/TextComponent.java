package com.epam.composite.component;

public interface TextComponent {
    void add(TextComponent component);
    void remove(TextComponent component);
    TextComponent getChild(int index);
    int size();
    boolean isWord();
    Layer getCurrentLayer();
    String toString();
}
