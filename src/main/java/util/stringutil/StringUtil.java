package util.stringutil;

public class StringUtil {

    public static String removeNewLineCharacters(String text) {
        return text.replace("\n", "");
    }

    public static String removePuncuation(String text) {
        return text.replaceAll("[.,'!@#$%^&*()_+={}:;\"?/><1234567890]", "");
    }

    public static boolean isCommonWord(String word) {
        String commonWords = "a\n" + "about\n" + "all\n" + "also\n" + "and\n" + "as\n" + "at\n" + "be\n" + "because\n" + "but\n" + "by\n" + "can\n" + "come\n" + "could\n" + "day\n" + "do\n" + "even\n" + "find\n" + "first\n" + "for\n" + "from\n" + "get\n" + "give\n" + "go\n" + "have\n" + "he\n" + "her\n" + "here\n" + "him\n" + "his\n" + "how\n" + "I\n" + "if\n" + "in\n" + "into\n" + "it\n" + "its\n" + "just\n" + "know\n" + "like\n" + "look\n" + "make\n" + "man\n" + "many\n" + "me\n" + "more\n" + "my\n" + "new\n" + "no\n" + "not\n" + "now\n" + "of\n" + "on\n" + "one\n" + "only\n" + "or\n" + "other\n" + "our\n" + "out\n" + "people\n" + "say\n" + "see\n" + "she\n" + "so\n" + "some\n" + "take\n" + "tell\n" + "than\n" + "that\n" + "the\n" + "their\n" + "them\n" + "then\n" + "there\n" + "these\n" + "they\n" + "thing\n" + "think\n" + "this\n" + "those\n" + "time\n" + "to\n" + "two\n" + "up\n" + "use\n" + "very\n" + "want\n" + "way\n" + "we\n" + "well\n" + "what\n" + "when\n" + "which\n" + "who\n" + "will\n" + "with\n" + "would\n" + "year\n" + "you\n" + "your";

        return commonWords.contains(word);
    }
}
