package com.epam.composite.parser;

import com.epam.composite.exception.ReaderException;
import com.epam.composite.reader.TextReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TextParserTest {
    private TextReader reader = new TextReader();

    @DataProvider
    public Object[][] texts() throws ReaderException {
        return new Object[][]{
                {reader.readText("data\\text1.txt")},
                {reader.readText("data\\text2.txt")},
        };
    }

    @Test(dataProvider = "texts")
    public void parseTest(String expected) {
        Parser parser = new TextParser();
        String actual = parser.parse(expected).toString();
        assertEquals(actual, expected);
    }
}
