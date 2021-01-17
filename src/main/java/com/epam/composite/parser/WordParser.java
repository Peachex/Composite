package com.epam.composite.parser;

import com.epam.composite.component.CharacterLeaf;
import com.epam.composite.component.TextComponent;
import com.epam.composite.component.Layer;
import com.epam.composite.component.TextComposite;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordParser implements Parser {
    private static final String WORD_DELIMITER = "[\\p{L}\\p{N}]+([\\p{P}\\p{S}]+[\\p{L}\\p{N})]+)*|[\\p{P}\\p{S}]";
    private static final String PUNCTUATION_REGEX = "[\\p{P}\\p{S}]";
    private Parser nextParser = new CharacterParser();

    @Override
    public TextComponent parse(String text) {
        TextComponent result = new TextComposite(Layer.SENTENCE);
        List<String> words = parseText(text);
        for (String word : words) {
            TextComponent character;
            if (!word.matches(PUNCTUATION_REGEX)) {
                character = nextParser.parse(word);
            } else {
                character = new CharacterLeaf(word.charAt(0), Layer.PUNCTUATION);
            }
            result.add(character);
        }
        return result;
    }

    private List<String> parseText(String text) {
        List<String> words = new ArrayList<>();
        Pattern wordRegex = Pattern.compile(WORD_DELIMITER);
        Matcher matcher = wordRegex.matcher(text);
        while (matcher.find()) {
            words.add(matcher.group());
        }
        return words;
    }
}
