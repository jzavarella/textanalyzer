package services;

import org.junit.Assert;
import org.junit.Test;

public class TextAnalysisTest {

    String originalText;
    TextAnalysis textAnalysis;

    public TextAnalysisTest() {
        originalText = "The lazy brown fox \njumped over the quite brown dog.!@";
        textAnalysis = new TextAnalysis(originalText);
    }

    @Test
    public void getTopFewEntriesTest() {
        String expectedResult = "{the=2, brown=2, over=1}";
        Assert.assertEquals(expectedResult, textAnalysis.getTopWords(3).toString());
    }

    @Test
    public void getSortedDescendingTest() {
        String expectedResult = "{the=2, brown=2, over=1, lazy=1, jumped=1, quite=1, dog=1, fox=1}";
        Assert.assertEquals(expectedResult, textAnalysis.getDescending().toString());
    }

    @Test
    public void getSortedAscendingTest() {
        String expectedResult = "{over=1, lazy=1, jumped=1, quite=1, dog=1, fox=1, the=2, brown=2}";
        Assert.assertEquals(expectedResult, textAnalysis.getAscending().toString());
    }

    @Test
    public void getWordCountTest() {
        Assert.assertEquals(10, textAnalysis.getWordCount());
    }

    @Test
    public void uniqueWordsTest() {
        Assert.assertEquals(8, textAnalysis.getUniqueWordCount());
    }
}
