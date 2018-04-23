package com.example.detectiveazul.wordcounter;

import java.util.ArrayList;
import java.util.HashMap;

public class WordCounter {
    private HashMap<String, Integer> wordsByCount;
    private String[] sentenceArray;

    public WordCounter(String string) {
        sentenceArray = string.split(" ");
        wordsByCount = new HashMap<>();
        populateHashMap();
    }

    private void populateHashMap() {
        for (String word: sentenceArray) {
            if (wordsByCount.containsKey(word))
            {
                int value = wordsByCount.get(word);
                wordsByCount.put(word, value + 1);
            } else {
                wordsByCount.put(word, 1);
            }

        }
    }

    public HashMap<String, Integer> getWordsByCount() {
        return wordsByCount;
    }

    public String getStringWordsByCount() {
        String result = "";
        for (String word: wordsByCount.keySet()) {
            result += word + ":" + wordsByCount.get(word) + "\n";
        }
        return result;
    }

    public static int wordCount(String string) {
        return string.split(" ").length;
    }

}
