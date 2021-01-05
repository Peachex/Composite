package com.epam.composite.comparator;

import com.epam.composite.component.Component;

import java.util.Comparator;

public enum ParagraphComparator implements Comparator<Component> {
    SENTENCES_AMOUNT {
        @Override
        public int compare(Component o1, Component o2) {
            return Integer.compare(o1.size(), o2.size());
        }
    }
}
