package com.epam.composite.component;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextComposite implements TextComponent {
    private static final String SPACE_SYMBOL = " ";
    private static final String NEW_LINE_SYMBOL = "\n";
    private static final String TAB_SYMBOL = "\t";
    private static final String WORD_REGEX = "[\\p{L}\\p{N}]+([\\p{P}\\p{S}]+[\\p{L}\\p{N})]+)*";
    private final Layer layer;
    private final List<TextComponent> components;

    public TextComposite(Layer layer) {
        this.components = new ArrayList<>();
        this.layer = layer;
    }

    @Override
    public void add(TextComponent component) {
        components.add(component);
    }

    @Override
    public void remove(TextComponent component) {
        components.remove(component);
    }

    @Override
    public TextComponent getChild(int index) {
        return components.get(index);
    }

    @Override
    public int size() {
        return this.components.size();
    }

    @Override
    public boolean isWord() {
        Pattern wordPattern = Pattern.compile(WORD_REGEX);
        Matcher matcher = wordPattern.matcher(this.components.toString());
        boolean result = matcher.find();
        return result;
    }

    @Override
    public Layer getCurrentLayer() {
        return this.layer;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < components.size(); i++) {
            TextComponent currentComponent = components.get(i);
            if (currentComponent.getCurrentLayer() == Layer.CHARACTER) {
                sb.append(currentComponent);
            } else {
                if (currentComponent.getCurrentLayer() == Layer.PUNCTUATION) {
                    if (currentComponent.toString().matches("[”),:;-]")) {
                        if (i < components.size() - 1) {
                            TextComponent nextComponent = components.get(i + 1);
                            sb.append((nextComponent.getCurrentLayer() == Layer.PUNCTUATION && nextComponent.toString().matches("[,:;]")) ?
                                    currentComponent : currentComponent + SPACE_SYMBOL);
                        } else {
                            sb.append(currentComponent).append(SPACE_SYMBOL);
                        }
                    } else {
                        sb.append(currentComponent);
                    }
                } else {
                    if (currentComponent.getCurrentLayer() == Layer.WORD || currentComponent.getCurrentLayer() == Layer.SENTENCE) {
                        if (i < components.size() - 1) {
                            TextComponent nextComponent = components.get(i + 1);
                            sb.append((nextComponent.getCurrentLayer() == Layer.PUNCTUATION && !nextComponent.toString().matches("[“(-]")) ?
                                    currentComponent : currentComponent + SPACE_SYMBOL);
                        } else {
                            sb.append(currentComponent).append(SPACE_SYMBOL);
                        }
                    } else {
                        sb.append(NEW_LINE_SYMBOL).append(TAB_SYMBOL).append(currentComponent.toString().trim());
                    }
                }
            }
        }
        return sb.toString().replaceFirst("\n", "");
    }
}
