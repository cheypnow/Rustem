package com.ekiryuhin.stemming;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// http://snowball.tartarus.org/algorithms/russian/stemmer.html
public class RuStemmer implements Stemmer {

    private static final Pattern PERFECT_GERUND = Pattern.compile("((ив|ивши|ившись|ыв|ывши|ывшись)|((ая)?(в|вши|вшись)))$");
    private static final Pattern ADJECTIVE = Pattern.compile("(ее|ие|ые|ое|ими|ыми|ей|ий|ый|ой|ем|им|ым|ом|его|ого|ему|ому|их|ых|ую|юю|ая|яя|ою|ею)$");
    private static final Pattern PARTICIPLE = Pattern.compile("((ивш|ывш|ующ)|((?<=[ая])(ем|нн|вш|ющ|щ)))$");
    private static final Pattern REFLEXIVE = Pattern.compile("(с[яь])$");
    private static final Pattern VERB = Pattern.compile(
            "((ила|ыла|ена|ейте|уйте|ите|или|ыли|ей|уй|ил|ыл|им|ым|ен|ило|ыло|ено|ят|ует|уют|ит|ыт|ены|ить|ыть|ишь|ую|ю)" +
                    "|((?<=[ая])(ла|на|ете|йте|ли|й|л|ем|н|ло|но|ет|ют|ны|ть|ешь|нно)))$");
    private static final Pattern NOUN = Pattern.compile("(а|ев|ов|ие|ье|е|иями|ями|ами|еи|ии|и|ией|ей|ой|ий|й|иям|ям|ием|ем|ам|ом|о|у|ах|иях|ях|ы|ь|ию|ью|ю|ия|ья|я)$");
    private static final Pattern VOWELS = Pattern.compile("^(.*?[аеиоуыэюя])(.*)$");
    private static final Pattern DERIVATIONAL_SUFFIX = Pattern.compile("ость?$");
    private static final Pattern DERIVATIONAL = Pattern.compile(".*[^аеиоуыэюя]+[аеиоуыэюя].*" + DERIVATIONAL_SUFFIX);
    private static final Pattern SUPERLATIVE = Pattern.compile("(ейше|ейш)$");
    private static final Pattern AND = Pattern.compile("и$");
    private static final Pattern SOFT_SIGN = Pattern.compile("ь$");
    private static final Pattern NN = Pattern.compile("нн$");


    @Override
    public String stem(String word) {
        word = clear(word);

        Matcher vowelsMatcher = VOWELS.matcher(word);
        if (!vowelsMatcher.matches()) {
            return word; // stemming does not make sense if there is no vowels in word
        }

        // RV is the region after the first vowel, or the end of the word if it contains no vowel
        // R2 is the region after the first non-vowel following a vowel in R1, or the end of the word if there is no such non-vowel.
        // For example:
        //    p r o t i v o e s t e s t v e n n o m
        //         |<------       RV        ------>|
        //           |<-----       R1       ------>|
        //               |<-----     R2     ------>|

        String beforeRV = vowelsMatcher.group(1); // letters before the RV region are never examined in the stemming process
        String rv = vowelsMatcher.group(2);

        rv = step1(rv);
        rv = step2(rv);
        rv = step3(rv);
        rv = step4(rv);

        return beforeRV + rv;
    }

    private String clear(String word) {
        return word.toLowerCase().replace("ё", "е");
    }

    // Step 1: Search for a PERFECTIVE GERUND ending. If one is found remove it, and that is then the end of step 1.
    // Otherwise try and remove a REFLEXIVE ending, and then search in turn for (1) an ADJECTIVAL, (2) a VERB or (3) a NOUN ending.
    // As soon as one of the endings (1) to (3) is found remove it, and terminate step 1.
    private String step1(String rv) {
        // remove perfect gerund ending
        rv = PERFECT_GERUND.matcher(rv).replaceFirst("");
        // remove reflexive ending
        rv = REFLEXIVE.matcher(rv).replaceFirst("");
        // remove adjective ending
        String temp = ADJECTIVE.matcher(rv).replaceFirst("");

        if (!rv.equals(temp)) {
            temp = PARTICIPLE.matcher(temp).replaceFirst("");
            return temp;
        }

        rv = temp;
        // remove verb ending
        temp = VERB.matcher(rv).replaceFirst("");

        if (!rv.equals(temp)) {
            return temp;
        }

        // remove noun ending
        return NOUN.matcher(rv).replaceFirst("");
    }

    // Step 2: If the word ends with и (i), remove it.
    private String step2(String rv) {
        return AND.matcher(rv).replaceFirst("");
    }

    // Step 3: Search for a DERIVATIONAL ending in R2 (i.e. the entire ending must lie in R2), and if one is found, remove it.
    private String step3(String rv) {
        if (DERIVATIONAL.matcher(rv).matches()) {
            rv = DERIVATIONAL_SUFFIX.matcher(rv).replaceFirst("");
        }
        return rv;
    }

    // Step 4: (1) Undouble н (n), or, (2) if the word ends with a SUPERLATIVE ending, remove it and undouble н (n), or (3) if the word ends ь (') (soft sign) remove it.
    private String step4(String rv) {
        String temp = SOFT_SIGN.matcher(rv).replaceFirst("");
        if (rv.equals(temp)) {
            rv = SUPERLATIVE.matcher(rv).replaceFirst("");
            rv = NN.matcher(rv).replaceFirst("н");
        } else {
            rv = temp;
        }

        return rv;
    }
}
