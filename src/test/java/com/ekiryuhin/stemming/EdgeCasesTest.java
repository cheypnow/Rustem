package com.ekiryuhin.stemming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;


public class EdgeCasesTest {

    private final Stemmer stemmer = new RuStemmer();

    @Test
    public void testBlank() {
        assertNull(stemmer.stem("   "));
    }

    @Test
    public void testEmpty() {
        assertNull(stemmer.stem(""));
    }

    @Test
    public void testNull() {
        assertNull(stemmer.stem(null));
    }

    @Test
    public void testEngWord() {
        assertNull(stemmer.stem("abc"));
    }

    @Test
    public void testNums() {
        assertNull(stemmer.stem("123"));
    }

    @Test
    public void testRuAndEng() {
        assertNull(stemmer.stem("абвabc"));
    }

    @Test
    public void testRuAndNums() {
        assertNull(stemmer.stem("абв123"));
    }
}
