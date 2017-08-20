package services;

import util.stringutil.StringUtil;

import java.util.*;

public class TextAnalysis {

    private String title, cleanText, originalText;
    private String[] wordArray;
    private Map<String, Integer> wordOccurrences, ascending, descending;

    public TextAnalysis(String text) {
        this.cleanText = text;
        this.originalText = text;

        this.cleanUpText();
        this.splitText();
        this.calculateWordOccurrences();
    }

    public TextAnalysis(String title, String text) {
        this.title = title;
        this.cleanText = text;
        this.originalText = text;

        this.cleanUpText();
        this.splitText();
        this.calculateWordOccurrences();
    }

    private void calculateWordOccurrences() {
        wordOccurrences = new HashMap<>();
        for (String word : wordArray) {
            if (!wordOccurrences.containsKey(word)) {
                wordOccurrences.put(word, 1);
            } else {
                wordOccurrences.put(word, wordOccurrences.get(word) + 1);
            }
        }
    }

    private void splitText() {
        wordArray = cleanText.split("\\s+");
    }

    private void cleanUpText() {
        cleanText = cleanText.toLowerCase();
        this.removeNewLines();
        this.removePunctuation();
    }

    private void removePunctuation() {
        cleanText = StringUtil.removePuncuation(cleanText);
    }

    private void removeNewLines() {
        cleanText = StringUtil.removeNewLineCharacters(cleanText);
    }

    public Map<String, Integer> getTopUniqueWords(int n) {
        Map<String, Integer> top = new LinkedHashMap<>();
        Set<Map.Entry<String, Integer>> acs = getDescending().entrySet();

        int count = 0;
        for (Map.Entry<String, Integer> entry : acs) {
            if (count >= n) {
                break;
            }
            if (!StringUtil.isCommonWord(entry.getKey())) {
                top.put(entry.getKey(), entry.getValue());
                count++;
            }
        }

        return top;
    }

    public Map<String, Integer> getTopWords(int n) {
        Map<String, Integer> top = new LinkedHashMap<>();
        Set<Map.Entry<String, Integer>> acs = getDescending().entrySet();

        int count = 0;
        for (Map.Entry<String, Integer> entry : acs) {
            if (count >= n) {
                break;
            }
            top.put(entry.getKey(), entry.getValue());
            count++;
        }

        return top;
    }

    public Map<String, Integer> getDescending() {
        if (descending != null) {
            return descending;
        }
        descending = new LinkedHashMap<>();
        wordOccurrences.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEachOrdered(x -> descending.put(x.getKey(), x.getValue()));
        return descending;
    }

    public Map<String, Integer> getAscending() {
        if (ascending != null) {
            return ascending;
        }
        ascending = new LinkedHashMap<>();
        wordOccurrences.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEachOrdered(x -> ascending.put(x.getKey(), x.getValue()));
        return ascending;
    }

    public long getWordCount() {
        return wordArray.length;
    }

    public long getUniqueWordCount() {
        return wordOccurrences.size();
    }

    public String getCleanText() {
        return cleanText;
    }

    public String getOriginalText() {
        return originalText;
    }

    public String[] getWordArray() {
        return wordArray;
    }

    public Map<String, Integer> getWordOccurrences() {
        return wordOccurrences;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (title != null) {
            sb.append("****").append(title).append(" Analysis****");
        } else {
            sb.append("****Text Analysis****");
        }
        sb.append("\n")
                .append("Total words: ").append(getWordCount()).append("\n")
                .append("Total unique words: ").append(getUniqueWordCount()).append("\n")
                .append("Most used words: ").append(getTopWords(5)).append("\n")
                .append("Most used uncommon words: ").append(getTopUniqueWords(5)).append("\n")
                .append("*********************").append("\n");
        return sb.toString();
    }
}
