package com.jazzteam.factories;

import com.jazzteam.builders.MyTripleBuilder;
import com.jazzteam.interfaces.DigitRepository;
import com.jazzteam.interfaces.TripleBuilder;
import com.jazzteam.interfaces.TripleFactory;
import com.jazzteam.models.Triple;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyTripleFactoryTest {
    static private TripleFactory tripleFactory;

    @BeforeAll
    static void init() {
        initTripleFactory();
    }

    static void initTripleFactory() {
        tripleFactory = new MyTripleFactory();
        TripleBuilder tripleBuilder = new MyTripleBuilder();
        DigitRepository digitRepository = new MyDigitFactoryRepository().create();

        tripleFactory.setTripleBuilder(tripleBuilder);
        tripleFactory.setDigitsRepository(digitRepository);
    }

    static Stream<Arguments> triplesOfZeroOrder() {
        return Stream.of(
                Arguments.of("0", 1),
                Arguments.of("00", 1),
                Arguments.of("10", 1),
                Arguments.of("100", 1),
                Arguments.of("200", 1),
                Arguments.of("000", 1),
                Arguments.of("101", 2),
                Arguments.of("110", 2),
                Arguments.of("111", 2),
                Arguments.of("123", 3),
                Arguments.of("121", 3)
        );
    }

    @ParameterizedTest
    @DisplayName("Builds triple with valid count of Digit")
    @MethodSource("triplesOfZeroOrder")
    void buildTriples(String tripleAsString, int expectedDigitsCount) {
        tripleFactory.setSource(tripleAsString);
        Triple result = tripleFactory.create();
        assertEquals(expectedDigitsCount, result.getDigits().size());
    }
}
