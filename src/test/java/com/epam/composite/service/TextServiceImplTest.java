package com.epam.composite.service;

import com.epam.composite.component.Component;

import static org.testng.Assert.assertEquals;

import com.epam.composite.parser.Parser;
import com.epam.composite.parser.TextParser;
import com.epam.composite.service.impl.TextServiceImpl;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class TextServiceImplTest {
    private TextService service = new TextServiceImpl();
    private Parser parser = new TextParser();
    private Component text1;
    private Component text2;

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
        Map<String, Integer> sameWords1 = new LinkedHashMap<>();
        sameWords1.put("IT", 6);
        sameWords1.put("HAS", 2);
        sameWords1.put("THE", 5);
        sameWords1.put("WITH", 2);
        sameWords1.put("OF", 5);
        sameWords1.put("LOREM", 2);
        sameWords1.put("IPSUM", 3);
        sameWords1.put("LIKE", 2);
        sameWords1.put("IS", 3);
        sameWords1.put("A", 7);
        sameWords1.put("ESTABLISHED", 2);
        sameWords1.put("FACT", 2);
        sameWords1.put("THAT", 3);
        sameWords1.put("READER", 2);
        sameWords1.put("WILL", 2);
        sameWords1.put("BE", 2);
        sameWords1.put("READABLE", 2);
        sameWords1.put("CONTENT", 3);
        sameWords1.put("PAGE", 2);
        sameWords1.put("WHEN", 2);
        sameWords1.put("LOOKING", 2);
        sameWords1.put("AT", 2);
        sameWords1.put("ITS", 2);
        sameWords1.put("LAYOUT", 2);
        sameWords1.put("USING", 2);

        Map<String, Integer> sameWords2 = new LinkedHashMap<>();
        sameWords2.put("A", 3);
        sameWords2.put("IN", 3);
        sameWords2.put("THE", 18);
        sameWords2.put("EVIDENCE", 2);
        sameWords2.put("OF", 6);
        sameWords2.put("ORGANIC", 4);
        sameWords2.put("ON", 3);
        sameWords2.put("SURFACE", 2);
        sameWords2.put("MARS", 2);
        sameWords2.put("BY", 2);
        sameWords2.put("ROVER", 2);
        sameWords2.put("CURIOSITY", 2);
        sameWords2.put("IT", 2);
        sameWords2.put("THAT", 4);
        sameWords2.put("PLANET", 2);
        sameWords2.put("COMPOUNDS", 2);
        sameWords2.put("THESE", 2);
        sameWords2.put("ALSO", 2);
        sameWords2.put("MOLECULES", 4);
        sameWords2.put("ARE", 2);
        sameWords2.put("FOR", 2);
        sameWords2.put("LIFE", 2);
        sameWords2.put("AS", 2);
        sameWords2.put("SCIENTISTS", 3);
        sameWords2.put("AREA", 2);
        sameWords2.put("HAVE", 2);
        sameWords2.put("BEEN", 2);
        sameWords2.put("YEARS", 2);
        sameWords2.put("AGO", 2);
        sameWords2.put("ROCKS", 3);
        sameWords2.put("WHICH", 2);
        sameWords2.put("WHEN", 2);
        sameWords2.put("TO", 3);
        sameWords2.put("COULD", 2);
        sameWords2.put("ONE", 2);

        return new Object[][]{
                {text1, sameWords1},
                {text2, sameWords2},
        };
    }

    @BeforeClass
    public void initializeTextsComponents() {
        text1 = parser.parse("\tIt has survived - not only (five) centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the “Динамо” (Рига) with the release of Letraset sheets.toString() containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker Faclon9 including versions of Lorem Ipsum!" +
                "\n\tIt is a long a!=b established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Ipsum is that it has a more-or-less normal distribution ob.toString(a?b:c), as opposed to using (Content here), content here's, making it look like readable English?" +
                "\n\tIt is a established fact that a reader will be of a page when looking at its layout…" +
                "\n\tBye бандерлоги.");

        text2 = parser.parse("\tA new study published in the journal Science shows definitive evidence of organic mat.equals(),ter on the surface of Mars. The data was collected by NASA's nuclear-powered rover Curiosity. It confirms earlier findings that the Red Planet once contained carbon-based compounds. These compounds - also called organic molecules - are essential ingredients for life as scientists understand it." +
                "\n\tThe organic molecules we.hashCode()re found in Mars's Gale Crater, a large area that may have been a watery lake over three billion years ago. The rover encountered traces of the molInteger_a=3;ecule in rocks extracted from the area. The rocks also contain sulfur, which scientists speculate helped preserve the organics even when the rocks were exposed to the harsh radiation on the surface of the planet." +
                "\n\tScientists are quick to state that the pre123,hashCodesence of these organic molecules is not sufficient evidence for anc.clone()ient life on Mars, as the molecules could have been formed by non-living processes. But it's still one of the most astonishing discoveries, which could lead to future revelations. Especially when one considers the other startling find that Curiosity uncovered around five years ago.");
    }

    @Test(dataProvider = "textsWithSortedParagraphs")
    public void sortParagraphsBySentencesAmountTest(Component text, String expected, boolean ascending) {
        String actual = service.sortParagraphsBySentencesAmount(text, ascending).toString();
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "sentencesWithMaxLengthWord")
    public void findSentencesWithMaxLengthWordTest(Component text, String expected) {
        String actual = service.findSentencesWithMaxLengthWord(text).toString();
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "sentencesWithWordsAmountLessThanCurrent")
    public void deleteSentencesWithWordsAmountLessThanCurrentTest(Component text, String expected, int wordsAmount) {
        String actual = service.deleteSentencesWithWordsAmountLessThanCurrent(text, wordsAmount).toString();
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "sameWords")
    public void findSameWordsTest(Component text, Map<String, Integer> expected) {
        Map<String, Integer> actual = service.findSameWords(text);
        assertEquals(actual, expected);
    }
}
