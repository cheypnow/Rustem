package com.ekiryuhin.stemming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleTest {

    private final Stemmer stemmer = new RuStemmer();

    @Test
    public void testWords() {
        assertEquals("в", stemmer.stem("в"));
        assertEquals("вавиловк", stemmer.stem("вавиловка"));
        assertEquals("вагнер", stemmer.stem("вагнера"));
        assertEquals("вагон", stemmer.stem("вагон"));
        assertEquals("вагон", stemmer.stem("вагона"));
        assertEquals("вагон", stemmer.stem("вагоне"));
        assertEquals("вагон", stemmer.stem("вагонов"));
        assertEquals("вагон", stemmer.stem("вагоном"));
        assertEquals("вагон", stemmer.stem("вагоны"));
        assertEquals("важн", stemmer.stem("важная"));
        assertEquals("важн", stemmer.stem("важнее"));
        assertEquals("важн", stemmer.stem("важнейшие"));
        assertEquals("важн", stemmer.stem("важнейшими"));
        assertEquals("важнича", stemmer.stem("важничал"));
        assertEquals("важн", stemmer.stem("важно"));
        assertEquals("важн", stemmer.stem("важного"));
        assertEquals("важн", stemmer.stem("важное"));
        assertEquals("важн", stemmer.stem("важной"));
        assertEquals("важн", stemmer.stem("важном"));
        assertEquals("важн", stemmer.stem("важному"));
        assertEquals("важност", stemmer.stem("важности"));
        assertEquals("важност", stemmer.stem("важностию"));
        assertEquals("п", stemmer.stem("п"));
        assertEquals("па", stemmer.stem("па"));
        assertEquals("пав", stemmer.stem("пава"));
        assertEquals("павел", stemmer.stem("павел"));
        assertEquals("павильон", stemmer.stem("павильон"));
        assertEquals("павильон", stemmer.stem("павильонам"));
        assertEquals("павл", stemmer.stem("павла"));
        assertEquals("павлин", stemmer.stem("павлиний"));
        assertEquals("павлин", stemmer.stem("павлиньи"));
        assertEquals("павлин", stemmer.stem("павлиньим"));
        assertEquals("павлович", stemmer.stem("павлович"));
        assertEquals("павловн", stemmer.stem("павловна"));
        assertEquals("павловн", stemmer.stem("павловне"));
        assertEquals("павловн", stemmer.stem("павловной"));
        assertEquals("павловн", stemmer.stem("павловну"));
        assertEquals("павловн", stemmer.stem("павловны"));
        assertEquals("павловц", stemmer.stem("павловцы"));
        assertEquals("павлыч", stemmer.stem("павлыч"));
        assertEquals("павлыч", stemmer.stem("павлыча"));
        assertEquals("пагубн", stemmer.stem("пагубная"));
        assertEquals("пада", stemmer.stem("падает"));
        assertEquals("пада", stemmer.stem("падай"));
        assertEquals("пада", stemmer.stem("падал"));
        assertEquals("пада", stemmer.stem("падала"));
        assertEquals("падал", stemmer.stem("падаль"));
        assertEquals("пада", stemmer.stem("падать"));
        assertEquals("пада", stemmer.stem("падаю"));
        assertEquals("пада", stemmer.stem("падают"));
        assertEquals("пада", stemmer.stem("падающего"));
        assertEquals("пада", stemmer.stem("падающие"));
        assertEquals("падеж", stemmer.stem("падеж"));
        assertEquals("паден", stemmer.stem("падение"));
        assertEquals("паден", stemmer.stem("падением"));
        assertEquals("паден", stemmer.stem("падении"));
        assertEquals("паден", stemmer.stem("падений"));
        assertEquals("паден", stemmer.stem("падения"));
        assertEquals("паден", stemmer.stem("паденье"));
        assertEquals("паден", stemmer.stem("паденья"));
        assertEquals("падет", stemmer.stem("падет"));
        assertEquals("падут", stemmer.stem("падут"));
        assertEquals("падуч", stemmer.stem("падучая"));
        assertEquals("падчериц", stemmer.stem("падчерицей"));
        assertEquals("падчериц", stemmer.stem("падчерицы"));
        assertEquals("падш", stemmer.stem("падшая"));
        assertEquals("падш", stemmer.stem("падшей"));
        assertEquals("падш", stemmer.stem("падшему"));
        assertEquals("падш", stemmer.stem("падший"));
        assertEquals("падш", stemmer.stem("падшим"));
        assertEquals("падш", stemmer.stem("падших"));
        assertEquals("падш", stemmer.stem("падшую"));
        assertEquals("паек", stemmer.stem("паек"));
        assertEquals("пазух", stemmer.stem("пазухи"));
        assertEquals("пазух", stemmer.stem("пазуху"));
        assertEquals("па", stemmer.stem("пай"));
        assertEquals("пакет", stemmer.stem("пакет"));
        assertEquals("пакет", stemmer.stem("пакетом"));
        assertEquals("пакет", stemmer.stem("пакеты"));
        assertEquals("пакост", stemmer.stem("пакостей"));
        assertEquals("пакостн", stemmer.stem("пакостно"));
        assertEquals("пал", stemmer.stem("пал"));
    }
}
