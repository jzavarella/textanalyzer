package util.stringutil;

import org.junit.Assert;
import org.junit.Test;

public class StringUtilTest {


    @Test
    public void removeNewLinesTest() {
        String originalText = "Hello. \nThis string has some \nnew \nlines.";
        String expectedResult = "Hello. This string has some new lines.";
        Assert.assertEquals(expectedResult, StringUtil.removeNewLineCharacters(originalText));
    }

    @Test
    public void removePunctuationTest() {
        String originalText = ".,'!@#$%^&*()_+={}:;\"?/><";
        String expectedResult = "";
        Assert.assertEquals(expectedResult, StringUtil.removePuncuation(originalText));
    }
}
