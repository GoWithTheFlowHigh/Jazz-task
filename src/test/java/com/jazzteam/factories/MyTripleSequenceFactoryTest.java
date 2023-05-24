package com.jazzteam.factories;

import com.jazzteam.builders.MyTripleBuilder;
import com.jazzteam.builders.MyTripleSequenceBuilder;
import com.jazzteam.interfaces.*;
import com.jazzteam.models.TripleSequence;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyTripleSequenceFactoryTest {
    static private DigitRepository digitRepository;
    static private NamedClassRepository namedClassRepository;
    static private TripleBuilder tripleBuilder;
    static private MyTripleFactory tripleFactory;
    static private TripleSequenceBuilder tripleSequenceBuilder;
    static private TripleSequenceFactory tripleSequenceFactory;

    @BeforeAll
    static void init() {
        digitRepository = new MyDigitFactoryRepository().create();
        namedClassRepository = new MyNamedClassFactoryRepository().create();
        tripleBuilder = new MyTripleBuilder();
        tripleFactory = new MyTripleFactory();
        tripleSequenceBuilder = new MyTripleSequenceBuilder();
        tripleSequenceFactory = new MyTripleSequenceFactory();

        tripleFactory.setDigitsRepository(digitRepository);
        tripleFactory.setTripleBuilder(tripleBuilder);
        tripleSequenceFactory.setNamedClassRepository(namedClassRepository);
        tripleSequenceFactory.setTripleFactory(tripleFactory);
        tripleSequenceFactory.setTripleSequenceBuilder(tripleSequenceBuilder);
    }

    static Stream<Arguments> sequences() {
        return Stream.of(
                Arguments.of("123", 1),
                Arguments.of("000", 1),
                Arguments.of("00", 1),
                Arguments.of("0", 1),
                Arguments.of("1000", 1),
                Arguments.of("1234000111", 3)
        );
    }

    @ParameterizedTest
    @DisplayName("Creates triple sequences with expected count of triples")
    @MethodSource("sequences")
    void sequencesBuilding(String numberAsString, int expectedTriplesCount) {
        tripleSequenceFactory.setSource(numberAsString);
        TripleSequence tripleSequence = tripleSequenceFactory.create();
        assertEquals(expectedTriplesCount, tripleSequence.getTriples().size());
    }


}
