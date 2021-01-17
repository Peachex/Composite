package com.epam.composite.comparator;

import com.epam.composite.component.TextComponent;

import java.util.Comparator;

public enum ParagraphComparator implements Comparator<TextComponent> {
    SENTENCES_AMOUNT {
        @Override
        public int compare(TextComponent o1, TextComponent o2) {
            return Integer.compare(o1.size(), o2.size());
        }
    }
}
