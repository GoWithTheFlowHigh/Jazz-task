package com.jazzteam.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NamedClassTest {
    private NamedClass namedClass;

    private static Stream<Arguments> firstTwoOrders() {

        return Stream.of(
                Arguments.of(0, "", "", "", "", "", Grammar.Gender.MALE),
                Arguments.of(1, "тысяч", "тысяча", "тысячи", "тысячи", "тысяч", Grammar.Gender.FEMALE)
        );
    }

    private static Stream<Arguments> namedOrdersFromTwoToFive() {
        return Stream.of(
                Arguments.of(2, "миллион", "", "", "", ""),
                Arguments.of(3, "миллиард", "", "", "", ""),
                Arguments.of(4, "трилион", "", "", "", ""),
                Arguments.of(5, "квадриллион", "", "", "", "")
        );
    }

    @BeforeEach
    void init() {
        namedClass = new NamedClass();
    }

    @ParameterizedTest
    @DisplayName("Creates valid named order, that have order number greater than 2 and default gender")
    @MethodSource("namedOrdersFromTwoToFive")
    void namedOrders(int namedOrderNumber, String root, String expectedSingularNominative,
                     String expectedSingularGenitive,
                     String expectedPluralNominative, String expectedPluralGenitive) {
        namedClass.setRoot(root);
        namedClass.setIndex(namedOrderNumber);
        namedClass.setSingular(Grammar.Case.NOMINATIVE, expectedSingularNominative);
        namedClass.setSingular(Grammar.Case.GENITIVE, expectedSingularGenitive);
        namedClass.setPlural(Grammar.Case.NOMINATIVE, expectedPluralNominative);
        namedClass.setPlural(Grammar.Case.GENITIVE, expectedPluralGenitive);

        assertEquals(Grammar.Gender.MALE, namedClass.getGender());
        assertEquals(expectedSingularNominative, namedClass.getSingular(Grammar.Case.NOMINATIVE));
        assertEquals(expectedSingularGenitive, namedClass.getSingular(Grammar.Case.GENITIVE));
        assertEquals(expectedPluralNominative, namedClass.getPlural(Grammar.Case.NOMINATIVE));
        assertEquals(expectedPluralGenitive, namedClass.getPlural(Grammar.Case.GENITIVE));
    }

    @ParameterizedTest
    @DisplayName("Creates valid named orders. that have order number less or equal than 2 and non-masculine gender")
    @MethodSource("firstTwoOrders")
    void namedOrders(int expectedNumber, String root, String expectedSingularNominative,
                     String expectedSingularGenitive,
                     String expectedPluralNominative, String expectedPluralGenitive, Grammar.Gender expectedGender) {
        namedClass.setRoot(root);
        namedClass.setIndex(expectedNumber);
        namedClass.setSingular(Grammar.Case.NOMINATIVE, expectedSingularNominative);
        namedClass.setSingular(Grammar.Case.GENITIVE, expectedSingularGenitive);
        namedClass.setPlural(Grammar.Case.NOMINATIVE, expectedPluralNominative);
        namedClass.setPlural(Grammar.Case.GENITIVE, expectedPluralGenitive);
        namedClass.setGender(expectedGender);

        assertEquals(expectedGender, namedClass.getGender());
        assertEquals(expectedSingularNominative, namedClass.getSingular(Grammar.Case.NOMINATIVE));
        assertEquals(expectedSingularGenitive, namedClass.getSingular(Grammar.Case.GENITIVE));
        assertEquals(expectedPluralNominative, namedClass.getPlural(Grammar.Case.NOMINATIVE));
        assertEquals(expectedPluralGenitive, namedClass.getPlural(Grammar.Case.GENITIVE));
    }
}
