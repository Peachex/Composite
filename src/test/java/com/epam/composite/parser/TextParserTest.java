package com.epam.composite.parser;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TextParserTest {
    @DataProvider
    public Object[][] texts() {
        return new Object[][]{
                {"\tIt has survived - not only (five) centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the “Динамо” (Рига) with the release of Letraset sheets.toString() containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker Faclon9 including versions of Lorem Ipsum!\n" +
                        "\tIt is a long a!=b established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Ipsum is that it has a more-or-less normal distribution ob.toString(a?b:c), as opposed to using (Content here), content here's, making it look like readable English?\n" +
                        "\tIt is a established fact that a reader will be of a page when looking at its layout…\n" +
                        "\tBye бандерлоги."},

                {"\tA new study published in the journal Science shows definitive evidence of organic mat.equals(),ter on the surface of Mars. The data was collected by NASA's nuclear-powered rover Curiosity. It confirms earlier findings that the Red Planet once contained carbon-based compounds. These compounds - also called organic molecules - are essential ingredients for life as scientists understand it.\n" +
                        "\tThe organic molecules we.hashCode()re found in Mars's Gale Crater, a large area that may have been a watery lake over three billion years ago. The rover encountered traces of the molInteger_a=3;ecule in rocks extracted from the area. The rocks also contain sulfur, which scientists speculate helped preserve the organics even when the rocks were exposed to the harsh radiation on the surface of the planet.\n" +
                        "\tScientists are quick to state that the pre123,hashCodesence of these organic molecules is not sufficient evidence for anc.clone()ient life on Mars, as the molecules could have been formed by non-living processes. But it's still one of the most astonishing discoveries, which could lead to future revelations. Especially when one considers the other startling find that Curiosity uncovered around five years ago."},
        };
    }

    @Test(dataProvider = "texts")
    public void parseTest(String expected) {
        Parser parser = new TextParser();
        String actual = parser.parse(expected).toString();
        assertEquals(actual, expected);
    }
}
