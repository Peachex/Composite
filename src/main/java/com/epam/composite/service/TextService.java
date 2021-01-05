package com.epam.composite.service;

import com.epam.composite.component.Component;

import java.util.Map;

public interface TextService {
    Component sortParagraphsBySentencesAmount(Component text, boolean ascending);

    Component findSentencesWithMaxLengthWord(Component text);

    Component deleteSentencesWithWordsAmountLessThanCurrent(Component text, int wordsAmount);

    Map<String, Integer> findSameWords(Component text);
}
