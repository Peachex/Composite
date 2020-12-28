package com.epam.composite.model.component.impl;

import com.epam.composite.model.component.Component;
import com.epam.composite.model.component.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CharacterLeaf implements Component {
    private final static Logger logger = LogManager.getLogger();
    private final Level level;
    private char character;

    public CharacterLeaf(char character) {
        this.level = Level.CHARACTER;
        this.character = character;
    }

    public char getCharacter() {
        return this.character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    @Override
    public void add(Component component) {
        logger.log(org.apache.logging.log4j.Level.FATAL, "Not implemented for this component.");
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public Component getChild(int index) {
        logger.log(org.apache.logging.log4j.Level.FATAL, "Not implemented for this component.");
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public void remove(Component component) {
        logger.log(org.apache.logging.log4j.Level.FATAL, "Not implemented for this component.");
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public int size() {
        return 1;
    }

    @Override
    public Level getCurrentLevel() {
        return this.level;
    }

    @Override
    public String toString() {
        return String.valueOf(this.character);
    }
}
