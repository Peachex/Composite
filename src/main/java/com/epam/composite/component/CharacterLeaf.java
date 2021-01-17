package com.epam.composite.component;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CharacterLeaf implements TextComponent {
    private final static Logger logger = LogManager.getLogger();
    private final Layer layer;
    private char character;

    public CharacterLeaf(char character, Layer layer) {
        this.layer = layer;
        this.character = character;
    }

    public char getCharacter() {
        return this.character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    @Override
    public void add(TextComponent component) {
        logger.log(Level.ERROR, "Not implemented for this component.");
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public TextComponent getChild(int index) {
        logger.log(Level.ERROR, "Not implemented for this component.");
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public void remove(TextComponent component) {
        logger.log(Level.ERROR, "Not implemented for this component.");
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public int size() {
        return 1;
    }

    @Override
    public boolean isWord() {
        logger.log(Level.ERROR, "Not implemented for this component.");
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public Layer getCurrentLayer() {
        return this.layer;
    }

    @Override
    public String toString() {
        return String.valueOf(this.character);
    }
}
