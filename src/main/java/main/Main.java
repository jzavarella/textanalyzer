package main;

import services.TextAnalysis;
import util.ioutil.IOUtil;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String bible = IOUtil.readFileToString("src/main/resources/text-files/bible.txt");
        TextAnalysis bibleAnalysis = new TextAnalysis("Bible", bible);

        System.out.println(bibleAnalysis);
    }
}
