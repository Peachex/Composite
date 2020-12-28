package com.epam.composite.model.component.impl;

import com.epam.composite.model.component.Component;
import com.epam.composite.model.component.Layer;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {
    private final Layer layer;
    private final List<Component> components;

    public Composite(Layer layer) {
        this.components = new ArrayList<>();
        this.layer = layer;
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
    public Layer getCurrentLayer() {
        return this.layer;
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
