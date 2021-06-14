# Rustem
Java implementation of Porter's Stemming Algorithm for Russian language.

Desciption of the algorithm: http://snowball.tartarus.org/algorithms/russian/stemmer.html.

Usage:
```
Stemmer stemmer = new RuStemmer();

assertEquals("важн", stemmer.stem("важная"));
assertEquals("важн", stemmer.stem("важнее"));
assertEquals("важн", stemmer.stem("важнейшие"));
```

Tested on the sample vocabulary http://snowball.tartarus.org/algorithms/russian/diffs-t.txt.
