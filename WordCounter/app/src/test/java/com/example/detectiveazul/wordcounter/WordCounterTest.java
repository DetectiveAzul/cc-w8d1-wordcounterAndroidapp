package com.example.detectiveazul.wordcounter;

import org.junit.Test;

import static org.junit.Assert.*;

public class WordCounterTest {
    @Test
    public void canCount() {
        assertEquals(4, WordCounter.wordCount("This is a test"));
    }
}