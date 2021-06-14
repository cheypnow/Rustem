package com.ekiryuhin.stemming;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PorterTest {

    private final Stemmer stemmer = new RuStemmer();

    @Test
    public void test() {
        // http://snowball.tartarus.org/algorithms/russian/diffs.txt
        List<String> input = readLines("/voc.txt");
        List<String> output = readLines("/output.txt");

        for (int i = 0; i < input.size(); i++) {
            String inputWord = input.get(i);

            String expected = output.get(i);
            String actual = stemmer.stem(inputWord);

            assertEquals(
                    expected,
                    actual,
                    "Input: " + inputWord + ". Expected: " + expected + ". Actual: " + actual
            );
        }
    }

    private List<String> readLines(String resource) {
        InputStream is = PorterTest.class.getResourceAsStream(resource);
        if (is == null) {
            throw new IllegalStateException("No file " + resource + " in resources");
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        return br.lines().collect(Collectors.toList());
    }
}
