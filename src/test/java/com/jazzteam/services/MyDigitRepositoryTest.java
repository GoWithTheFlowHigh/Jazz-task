package com.jazzteam.services;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import com.jazzteam.factories.MyDigitFactoryRepository;
import com.jazzteam.interfaces.DigitRepository;
import com.jazzteam.models.Digit;
import com.jazzteam.models.Grammar;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyDigitRepositoryTest {
    static DigitRepository digitRepository;

    @BeforeAll
    static void init() {
        digitRepository = new MyDigitFactoryRepository().create();
    }

    private static Stream<Arguments> digitsWithFeminineAndNeuterFormsUnderTen() {
        return Stream.of(
                Arguments.of("1", 0, "один", "одна", Grammar.Form.SINGULAR, Grammar.Case.NOMINATIVE),
                Arguments.of("2", 0, "два", "две", Grammar.Form.SINGULAR, Grammar.Case.GENITIVE)
        );
    }

    private static Stream<Arguments> digitsWithoutFeminineAndNeuterFormsUnderTen() {
        return Stream.of(
                Arguments.of("0", 0, "ноль", "", Grammar.Form.PLURAL, Grammar.Case.GENITIVE),
                Arguments.of("3", 0, "три", "", Grammar.Form.SINGULAR, Grammar.Case.GENITIVE),
                Arguments.of("4", 0, "четыре", "", Grammar.Form.SINGULAR, Grammar.Case.GENITIVE),
                Arguments.of("5", 0, "пять", "", Grammar.Form.PLURAL, Grammar.Case.GENITIVE),
                Arguments.of("6", 0, "шесть", "", Grammar.Form.PLURAL, Grammar.Case.GENITIVE),
                Arguments.of("7", 0, "семь", "", Grammar.Form.PLURAL, Grammar.Case.GENITIVE),
                Arguments.of("8", 0, "восемь", "", Grammar.Form.PLURAL, Grammar.Case.GENITIVE),
                Arguments.of("9", 0, "девять", "", Grammar.Form.PLURAL, Grammar.Case.GENITIVE)
        );
    }

    private static Stream<Arguments> numbersBetweenTenAndTwenty() {
        return Stream.of(
                Arguments.of("10", 1, "десять", "", Grammar.Form.PLURAL, Grammar.Case.GENITIVE),
                Arguments.of("11", 1, "одиннадцать", "", Grammar.Form.PLURAL, Grammar.Case.GENITIVE),
                Arguments.of("12", 1, "двенадцать", "", Grammar.Form.PLURAL, Grammar.Case.GENITIVE),
                Arguments.of("13", 1, "тринадцать", "", Grammar.Form.PLURAL, Grammar.Case.GENITIVE),
                Arguments.of("14", 1, "четырнадцать", "", Grammar.Form.PLURAL, Grammar.Case.GENITIVE),
                Arguments.of("15", 1, "пятнадцать", "", Grammar.Form.PLURAL, Grammar.Case.GENITIVE),
                Arguments.of("16", 1, "шестнадцать", "", Grammar.Form.PLURAL, Grammar.Case.GENITIVE),
                Arguments.of("17", 1, "семнадцать", "", Grammar.Form.PLURAL, Grammar.Case.GENITIVE),
                Arguments.of("18", 1, "восемнадцать", "", Grammar.Form.PLURAL, Grammar.Case.GENITIVE),
                Arguments.of("19", 1, "девятнадцать", "", Grammar.Form.PLURAL, Grammar.Case.GENITIVE)
        );
    }

    private static Stream<Arguments> tens() {
        return Stream.of(
                Arguments.of("2", 1, "двадцать", "", Grammar.Form.PLURAL, Grammar.Case.GENITIVE),
                Arguments.of("3", 1, "тридцать", "", Grammar.Form.PLURAL, Grammar.Case.GENITIVE),
                Arguments.of("4", 1, "сорок", "", Grammar.Form.PLURAL, Grammar.Case.GENITIVE),
                Arguments.of("5", 1, "пятьдесят", "", Grammar.Form.PLURAL, Grammar.Case.GENITIVE),
                Arguments.of("6", 1, "шестьдесят", "", Grammar.Form.PLURAL, Grammar.Case.GENITIVE),
                Arguments.of("7", 1, "семьдесят", "", Grammar.Form.PLURAL, Grammar.Case.GENITIVE),
                Arguments.of("8", 1, "восемьдесят", "", Grammar.Form.PLURAL, Grammar.Case.GENITIVE),
                Arguments.of("9", 1, "девяносто", "", Grammar.Form.PLURAL, Grammar.Case.GENITIVE)
        );
    }

    private static Stream<Arguments> hundreds() {
        return Stream.of(
                Arguments.of("1", 2, "сто", "", Grammar.Form.PLURAL, Grammar.Case.GENITIVE),
                Arguments.of("2", 2, "двести", "", Grammar.Form.PLURAL, Grammar.Case.GENITIVE),
                Arguments.of("3", 2, "триста", "", Grammar.Form.PLURAL, Grammar.Case.GENITIVE),
                Arguments.of("4", 2, "четыреста", "", Grammar.Form.PLURAL, Grammar.Case.GENITIVE),
                Arguments.of("5", 2, "пятьсот", "", Grammar.Form.PLURAL, Grammar.Case.GENITIVE),
                Arguments.of("6", 2, "шестьсот", "", Grammar.Form.PLURAL, Grammar.Case.GENITIVE),
                Arguments.of("7", 2, "семьсот", "", Grammar.Form.PLURAL, Grammar.Case.GENITIVE),
                Arguments.of("8", 2, "восемьсот", "", Grammar.Form.PLURAL, Grammar.Case.GENITIVE),
                Arguments.of("9", 2, "девятьсот", "", Grammar.Form.PLURAL, Grammar.Case.GENITIVE)
        );
    }

    @Test
    @DisplayName("Has 38 digits")
    void hasThirtyEightDigits() {
        assertEquals(37, digitRepository.getItems().size());
    }

    @ParameterizedTest
    @DisplayName("Returns Digit by position in triple and digit")
    @MethodSource({
                          "digitsWithFeminineAndNeuterFormsUnderTen",
                          "digitsWithoutFeminineAndNeuterFormsUnderTen",
                          "numbersBetweenTenAndTwenty",
                          "tens",
                          "hundreds"
                  })
    void getsDigitByPositionInTripleAndDigit(String symbol, int positionInTriple, String expectedMasculineForm,
                                             String expectedFeminineForm,
                                             Grammar.Form expectedForm,
                                             Grammar.Case expectedCase) {
        Digit actualDigit = digitRepository.getDigitByPositionInTripleAndSymbol(symbol, positionInTriple);
        assertEquals(expectedMasculineForm, actualDigit.getGenderForm(Grammar.Gender.MALE));
        assertEquals(expectedFeminineForm, actualDigit.getGenderForm(Grammar.Gender.FEMALE));
        assertEquals(expectedForm, actualDigit.getForm());
        assertEquals(expectedCase, actualDigit.getCase());
    }

}
