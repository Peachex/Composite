package com.epam.composite.service.impl;

import com.epam.composite.comparator.ParagraphComparator;
import com.epam.composite.component.TextComponent;
import com.epam.composite.component.Layer;
import com.epam.composite.component.TextComposite;
import com.epam.composite.service.TextService;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TextServiceImpl implements TextService {
    public TextComponent sortParagraphsBySentencesAmount(TextComponent text, boolean ascending) {
        List<TextComponent> sortedParagraphs = new ArrayList<>();
        for (int i = 0; i < text.size(); i++) {
            sortedParagraphs.add(text.getChild(i));
        }
        sortedParagraphs.sort(ascending ? ParagraphComparator.SENTENCES_AMOUNT : ParagraphComparator.SENTENCES_AMOUNT.reversed());
        TextComponent sortedText = new TextComposite(Layer.TEXT);
        for (TextComponent paragraph : sortedParagraphs) {
            sortedText.add(paragraph);
        }
        return sortedText;
    }

    public TextComponent findSentencesWithMaxLengthWord(TextComponent text) {
        TextComponent sentences = new TextComposite(Layer.SENTENCE);
        int maxLength = 0;
        for (int i = 0; i < text.size(); i++) {
            for (int j = 0; j < text.getChild(i).size(); j++) {
                for (int k = 0; k < text.getChild(i).getChild(j).size(); k++) {
                    TextComponent word = text.getChild(i).getChild(j).getChild(k);
                    if (word.size() > maxLength) {
                        maxLength = word.size();
                    }
                }
            }
        }
        for (int i = 0; i < text.size(); i++) {
            for (int j = 0; j < text.getChild(i).size(); j++) {
                int k = 0;
                while (k < text.getChild(i).getChild(j).size()) {
                    TextComponent word = text.getChild(i).getChild(j).getChild(k++);
                    if (word.size() == maxLength) {
                        sentences.add(text.getChild(i).getChild(j));
                        break;
                    }
                }
            }
        }
        return sentences;
    }

    public TextComponent deleteSentencesWithWordsAmountLessThanCurrent(TextComponent text, int wordsAmount) {
        TextComponent result = new TextComposite(Layer.TEXT);
        for (int i = 0; i < text.size(); i++) {
            TextComponent paragraph = new TextComposite(Layer.PARAGRAPH);
            for (int j = 0; j < text.getChild(i).size(); j++) {
                TextComponent sentence = text.getChild(i).getChild(j);
                if (findWordsAmount(sentence) >= wordsAmount) {
                    paragraph.add(sentence);
                }
            }
            if (paragraph.size() > 0) {
                result.add(paragraph);
            }
        }
        return result;
    }

    public Map<String, Integer> findSameWords(TextComponent text) {
        List<String> words = new ArrayList<>();
        for (int i = 0; i < text.size(); i++) {
            for (int j = 0; j < text.getChild(i).size(); j++) {
                for (int k = 0; k < text.getChild(i).getChild(j).size(); k++) {
                    TextComponent word = text.getChild(i).getChild(j).getChild(k);
                    if (word.getCurrentLayer() == Layer.WORD) {
                        words.add(word.toString().toUpperCase());
                    }
                }
            }
        }
        Map<String, Integer> result = new LinkedHashMap<>();
        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            if (!result.containsKey(word)) {
                int amount = findRepeatedWordsAmount(words, word);
                if (amount > 1) {
                    result.put(word, amount);
                }
            }
        }
        return result;
    }

    private int findWordsAmount(TextComponent sentence) {
        int result = 0;
        for (int i = 0; i < sentence.size(); i++) {
            TextComponent word = sentence.getChild(i);
            if ((word.getCurrentLayer() == Layer.WORD && word.isWord())) {
                result++;
            }
        }
        return result;
    }

    private int findRepeatedWordsAmount(List<String> words, String word) {
        int amount = 0;
        for (String currentWord : words) {
            if (currentWord.equals(word)) {
                amount++;
            }
        }
        return amount;
    }
}
