package com.epam.composite.service;

import com.epam.composite.component.TextComponent;

import static org.testng.Assert.assertEquals;

import com.epam.composite.exception.ReaderException;
import com.epam.composite.parser.Parser;
import com.epam.composite.parser.TextParser;
import com.epam.composite.reader.TextReader;
import com.epam.composite.service.impl.TextServiceImpl;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class TextServiceImplTest {
    private TextService service = new TextServiceImpl();
    private Parser parser = new TextParser();
    private TextReader reader = new TextReader();
    private TextComponent text1;
    private TextComponent text2;

    @DataProvider
    public Object[][] textsWithSortedParagraphs() {
        return new Object[][]{
                {text1,
                        "\tIt is a established fact that a reader will be of a page when looking at its layout…" +
                                "\n\tBye бандерлоги." +
                                "\n\tIt has survived - not only (five) centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the “Динамо” (Рига) with the release of Letraset sheets.toString() containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker Faclon9 including versions of Lorem Ipsum!" +
                                "\n\tIt is a long a!=b established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Ipsum is that it has a more-or-less normal distribution ob.toString(a?b:c), as opposed to using (Content here), content here's, making it look like readable English?",
                        true
                },

                {text2,
                        "\tA new study published in the journal Science shows definitive evidence of organic mat.equals(),ter on the surface of Mars. The data was collected by NASA's nuclear-powered rover Curiosity. It confirms earlier findings that the Red Planet once contained carbon-based compounds. These compounds - also called organic molecules - are essential ingredients for life as scientists understand it.\n" +
                                "\tThe organic molecules we.hashCode()re found in Mars's Gale Crater, a large area that may have been a watery lake over three billion years ago. The rover encountered traces of the molInteger_a=3;ecule in rocks extracted from the area. The rocks also contain sulfur, which scientists speculate helped preserve the organics even when the rocks were exposed to the harsh radiation on the surface of the planet.\n" +
                                "\tScientists are quick to state that the pre123,hashCodesence of these organic molecules is not sufficient evidence for anc.clone()ient life on Mars, as the molecules could have been formed by non-living processes. But it's still one of the most astonishing discoveries, which could lead to future revelations. Especially when one considers the other startling find that Curiosity uncovered around five years ago.",
                        false
                },
        };
    }

    @DataProvider
    public Object[][] sentencesWithMaxLengthWord() {
        return new Object[][]{
                {text1, "The point of using Ipsum is that it has a more-or-less normal distribution ob.toString(a?b:c), as opposed to using (Content here), content here's, making it look like readable English? "},
                {text2, "The rover encountered traces of the molInteger_a=3;ecule in rocks extracted from the area. Scientists are quick to state that the pre123,hashCodesence of these organic molecules is not sufficient evidence for anc.clone()ient life on Mars, as the molecules could have been formed by non-living processes. "},
        };
    }

    @DataProvider
    public Object[][] sentencesWithWordsAmountLessThanCurrent() {
        return new Object[][]{
                {text1, "\tIt was popularised in the “Динамо” (Рига) with the release of Letraset sheets.toString() containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker Faclon9 including versions of Lorem Ipsum!" +
                        "\n\tThe point of using Ipsum is that it has a more-or-less normal distribution ob.toString(a?b:c), as opposed to using (Content here), content here's, making it look like readable English?",
                        28},
                {text2, "\tA new study published in the journal Science shows definitive evidence of organic mat.equals(),ter on the surface of Mars." +
                        "\n\tThe organic molecules we.hashCode()re found in Mars's Gale Crater, a large area that may have been a watery lake over three billion years ago. The rocks also contain sulfur, which scientists speculate helped preserve the organics even when the rocks were exposed to the harsh radiation on the surface of the planet." +
                        "\n\tScientists are quick to state that the pre123,hashCodesence of these organic molecules is not sufficient evidence for anc.clone()ient life on Mars, as the molecules could have been formed by non-living processes.",
                        18},
        };
    }

    @DataProvider
    public Object[][] sameWords() {
        Map<String, Integer> sameWordsFromText1 = new LinkedHashMap<>();
        sameWordsFromText1.put("IT", 6);
        sameWordsFromText1.put("HAS", 2);
        sameWordsFromText1.put("THE", 5);
        sameWordsFromText1.put("WITH", 2);
        sameWordsFromText1.put("OF", 5);
        sameWordsFromText1.put("LOREM", 2);
        sameWordsFromText1.put("IPSUM", 3);
        sameWordsFromText1.put("LIKE", 2);
        sameWordsFromText1.put("IS", 3);
        sameWordsFromText1.put("A", 7);
        sameWordsFromText1.put("ESTABLISHED", 2);
        sameWordsFromText1.put("FACT", 2);
        sameWordsFromText1.put("THAT", 3);
        sameWordsFromText1.put("READER", 2);
        sameWordsFromText1.put("WILL", 2);
        sameWordsFromText1.put("BE", 2);
        sameWordsFromText1.put("READABLE", 2);
        sameWordsFromText1.put("CONTENT", 3);
        sameWordsFromText1.put("PAGE", 2);
        sameWordsFromText1.put("WHEN", 2);
        sameWordsFromText1.put("LOOKING", 2);
        sameWordsFromText1.put("AT", 2);
        sameWordsFromText1.put("ITS", 2);
        sameWordsFromText1.put("LAYOUT", 2);
        sameWordsFromText1.put("USING", 2);

        Map<String, Integer> sameWordsFromText2 = new LinkedHashMap<>();
        sameWordsFromText2.put("A", 3);
        sameWordsFromText2.put("IN", 3);
        sameWordsFromText2.put("THE", 18);
        sameWordsFromText2.put("EVIDENCE", 2);
        sameWordsFromText2.put("OF", 6);
        sameWordsFromText2.put("ORGANIC", 4);
        sameWordsFromText2.put("ON", 3);
        sameWordsFromText2.put("SURFACE", 2);
        sameWordsFromText2.put("MARS", 2);
        sameWordsFromText2.put("BY", 2);
        sameWordsFromText2.put("ROVER", 2);
        sameWordsFromText2.put("CURIOSITY", 2);
        sameWordsFromText2.put("IT", 2);
        sameWordsFromText2.put("THAT", 4);
        sameWordsFromText2.put("PLANET", 2);
        sameWordsFromText2.put("COMPOUNDS", 2);
        sameWordsFromText2.put("THESE", 2);
        sameWordsFromText2.put("ALSO", 2);
        sameWordsFromText2.put("MOLECULES", 4);
        sameWordsFromText2.put("ARE", 2);
        sameWordsFromText2.put("FOR", 2);
        sameWordsFromText2.put("LIFE", 2);
        sameWordsFromText2.put("AS", 2);
        sameWordsFromText2.put("SCIENTISTS", 3);
        sameWordsFromText2.put("AREA", 2);
        sameWordsFromText2.put("HAVE", 2);
        sameWordsFromText2.put("BEEN", 2);
        sameWordsFromText2.put("YEARS", 2);
        sameWordsFromText2.put("AGO", 2);
        sameWordsFromText2.put("ROCKS", 3);
        sameWordsFromText2.put("WHICH", 2);
        sameWordsFromText2.put("WHEN", 2);
        sameWordsFromText2.put("TO", 3);
        sameWordsFromText2.put("COULD", 2);
        sameWordsFromText2.put("ONE", 2);

        return new Object[][]{
                {text1, sameWordsFromText1},
                {text2, sameWordsFromText2},
        };
    }

    @BeforeClass
    public void initializeTextsComponents() throws ReaderException {
        text1 = parser.parse(reader.readText("data\\text1.txt"));
        text2 = parser.parse(reader.readText("data\\text2.txt"));
    }

    @Test(dataProvider = "textsWithSortedParagraphs")
    public void sortParagraphsBySentencesAmountTest(TextComponent text, String expected, boolean ascending) {
        String actual = service.sortParagraphsBySentencesAmount(text, ascending).toString();
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "sentencesWithMaxLengthWord")
    public void findSentencesWithMaxLengthWordTest(TextComponent text, String expected) {
        String actual = service.findSentencesWithMaxLengthWord(text).toString();
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "sentencesWithWordsAmountLessThanCurrent")
    public void deleteSentencesWithWordsAmountLessThanCurrentTest(TextComponent text, String expected, int wordsAmount) {
        String actual = service.deleteSentencesWithWordsAmountLessThanCurrent(text, wordsAmount).toString();
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "sameWords")
    public void findSameWordsTest(TextComponent text, Map<String, Integer> expected) {
        Map<String, Integer> actual = service.findSameWords(text);
        assertEquals(actual, expected);
    }
}
