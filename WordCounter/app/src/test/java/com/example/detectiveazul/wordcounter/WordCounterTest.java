package com.example.detectiveazul.wordcounter;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WordCounterTest {
    private WordCounter wordCounter00;

    @Before
    public void setup() {
        wordCounter00 = new WordCounter("this this this");

    }
    @Test
    public void canCount() {
        assertEquals(4, WordCounter.wordCount("This is a test"));
    }

    @Test
    public void canCountByWord() {
        int result = wordCounter00.getWordsByCount().get("this");
        assertEquals(3, result);
    }

    @Test
    public void canReturnStringOfWordsByCount() {
        String result = wordCounter00.getStringWordsByCount();
        assertEquals("this:3\n", result);
    }
}