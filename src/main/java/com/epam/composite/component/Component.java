package com.epam.composite.component;

public interface Component {
    void add(Component component);
    void remove(Component component);
    Component getChild(int index);
    int size();
    boolean isWord();
    Layer getCurrentLayer();
    String toString();
}
