package com.epam.composite.service;

import com.epam.composite.component.TextComponent;

import java.util.Map;

public interface TextService {
    TextComponent sortParagraphsBySentencesAmount(TextComponent text, boolean ascending);

    TextComponent findSentencesWithMaxLengthWord(TextComponent text);

    TextComponent deleteSentencesWithWordsAmountLessThanCurrent(TextComponent text, int wordsAmount);

    Map<String, Integer> findSameWords(TextComponent text);
}
