package com.example.detectiveazul.wordcounter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
        //Order the map
        this.wordsByCount = WordCounter.orderMapByValue(wordsByCount);
        //Create the string
        String result = "";
        for (String word: wordsByCount.keySet()) {
            result += word + ":" + wordsByCount.get(word) + "\n";
        }
        return result;
    }

    public static int wordCount(String string) {
        return string.split(" ").length;
    }

    public static HashMap<String, Integer> orderMapByValue(HashMap<String, Integer> hashMap ) {
        //Turn into a list
        List<HashMap.Entry<String, Integer>> list = new LinkedList<>(hashMap.entrySet());
        //Sort with collection and custom Comparator
        Collections.sort(list, new Comparator<HashMap.Entry<String, Integer>>() {
            public int compare(HashMap.Entry<String, Integer> o1,
                               HashMap.Entry<String, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
        //Loop to iterate
        HashMap<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        //Return sortedmap
        return sortedMap;
    }


}
