package com.epam.composite.model.component.impl;

import com.epam.composite.model.component.Component;
import com.epam.composite.model.component.Level;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {
    private final Level level;
    private final List<Component> components;

    public Composite(Level level) {
        this.components = new ArrayList<>();
        this.level = level;
    }

    @Override
    public void add(Component component) {
        components.add(component);
    }

    @Override
    public void remove(Component component) {
        components.remove(component);
    }

    @Override
    public Component getChild(int index) {
        return components.get(index);
    }

    @Override
    public int size() {
        return this.components.size();
    }

    @Override
    public Level getCurrentLevel() {
        return this.level;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Component component : this.components) {
            sb.append(component.toString());
        }
        return sb.toString();
    }
}
