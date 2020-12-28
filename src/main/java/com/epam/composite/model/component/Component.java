package com.epam.composite.model.component;

public interface Component {
    void add(Component component);
    void remove(Component component);
    Component getChild(int index);
    int size();
    Layer getCurrentLayer();
    String toString();
}
